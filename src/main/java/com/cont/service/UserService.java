package com.cont.service;



import java.util.List;

import com.cont.model.UserModel;

/**
 * Created by lz on 2017/5/18.
 */
public interface UserService {

    /**
     * 查询全部
     * @return
     */
    List<UserModel> retrieveAll();

    /**
     * 分页查询,包括条件查询
     * @param vo
     * @return
     */
    List<UserModel> retrieveAllWithPage(UserModel vo);

    /**
     * 插入数据
     * @param model
     * @return
     */
    int insertByMo(UserModel model);

    /**
     * 更新数据
     * @param model
     * @return
     */
    int updateByPk(UserModel model);

    /**
     * 按pk批量删除
     * @param pks
     * @return
     */
    int deleteByPks(List<String> pks);

    /**
     * 按编码，密码查询用户
     * @param user_code
     * @param password
     * @return
     */
    UserModel checkByCodeAndPwd(UserModel model);


  
    //用户登录
    List<UserModel> loginByCodeAndPwd(UserModel model);
    //修改密码
    int updatePwd(UserModel model);

    List<UserModel> oldPwd(UserModel model);
}
