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
    public List<UserModel> retrieveAll() {

        List<UserModel> result = userDAO.retrieveAll();

        for (UserModel model: result) {
            model.setPassword(Encode.decode(model.getPassword()));
        }

        return result;
    }

    @Override
    public List<UserModel> retrieveAllWithPage(UserModel vo) {

        List<UserModel> result = userDAO.retrieveAllWithPage(vo);

        for (UserModel model: result) {
            model.setPassword(Encode.decode(model.getPassword()));
        }

        return result;
    }

    @Override
    public int insertByMo(UserModel model) {

        List<UserModel> resultList = userDAO.retrieveByCode(model.getUser_code());
        if(resultList != null && resultList.size() > 0){
            return StatusCodeConstants.Code_Repeat;
        }

        model.setPassword(Encode.encode(model.getPassword()));

        Integer result = userDAO.insertByMo(model);

        return result < 1 ? StatusCodeConstants.Fail : StatusCodeConstants.Success;
    }

    @Override
    public int updateByPk(UserModel model) {

        if(model.getPassword() != null && model.getPassword().trim().length() > 0){
            model.setPassword(Encode.encode(model.getPassword()));
        }

        Integer result = userDAO.updateByPk(model);

        return result < 1 ? StatusCodeConstants.Fail : StatusCodeConstants.Success;
    }

    @Override
    public int deleteByPks(List<String> pks) {

        Integer result = userDAO.deleteByPks(pks);

        return result < 1 ? StatusCodeConstants.Fail : StatusCodeConstants.Success;
    }

    @Override
    public UserModel checkByCodeAndPwd(UserModel model) {

        model.setPassword(Encode.encode(model.getPassword()));

        List<UserModel> resultList = userDAO.retrieveByCodeAndPwd(model);

        return resultList != null && resultList.size() == 1 ? resultList.get(0) : null;
    }
    @Override
    public  List<UserModel> loginByCodeAndPwd(UserModel model) {
        model.setPassword(Encode.encode(model.getPassword()));
        List<UserModel> resultList = userDAO.loginByCodeAndPwd(model);
        return resultList;
    }
    @Override
    public int updatePwd(UserModel model) {
        model.setPassword(Encode.encode(model.getPassword()));
        return userDAO.updatePwd(model);
    }

    @Override
    public List<UserModel> oldPwd(UserModel model) {
        model.setOldpwd(Encode.encode(model.getOldpwd()));
        List<UserModel> List =userDAO.oldPwd(model);
        return List;
    }

}
