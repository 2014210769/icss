package com.cont.service;



import java.util.List;

import com.cont.model.UserModel;

/**
 * Created by lz on 2017/5/18.
 */
public interface UserService {


    
	List<UserModel> userLogin(String uname,String pass);
}
