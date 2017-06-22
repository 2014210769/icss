package com.cont.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.UserDAO;
import com.cont.model.UserModel;
import com.cont.service.UserService;
import com.cont.utils.Encode;
import com.cont.utils.StatusCodeConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2017/5/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

	@Override
	public List<UserModel> userLogin(String uname, String pass) {
		String password = Encode.encode(pass);
		UserModel model = new UserModel();
		model.setU_name(uname);
		model.setU_password(password);
	    List<UserModel> resultList = userDAO.userLogin(model);

	  return resultList;
	}

}
