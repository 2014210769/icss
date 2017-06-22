package com.cont.dao;

import java.util.List;

import com.cont.model.UserModel;



/**
 * CompanyDAO
 */
public interface UserDAO {

    List<UserModel> userLogin(UserModel model);
}



