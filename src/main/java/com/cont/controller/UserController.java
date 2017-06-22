package com.cont.controller;

import com.cont.model.UserModel;
import com.cont.service.UserService;
import com.cont.utils.APIRestResponse;
import com.cont.utils.ResponseUtils;
import com.cont.utils.RestOperateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;   
//@RequestParam(value="ids",required=false) String ids
    @ResponseBody
    @RequestMapping("/login")
    public APIRestResponse login(HttpServletRequest request) {
    	String uname = request.getParameter("uname");
    	String pass = request.getParameter("pass");
    	
    	List<UserModel> userList = userService.userLogin(uname,pass);
    	if(userList!=null && userList.size()>0){
    		UserModel userInfo = userList.get(0);
    		request.getSession().setAttribute("userInfo", userInfo);
    		return ResponseUtils.getSuccessAPI(true,"true", RestOperateCode.OP_LOGIN);
    	}
    	return ResponseUtils.getSuccessAPI(false,"false", RestOperateCode.OP_LOGIN);
    }

}



