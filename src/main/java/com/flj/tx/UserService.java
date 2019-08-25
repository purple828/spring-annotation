package com.flj.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author flj
 * @Description:
 * @date 2019-08-25 18:42
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void  insert(){
        userDao.insert();
        System.out.println("插入完成...");

        int i = 10/0;

    }

}
