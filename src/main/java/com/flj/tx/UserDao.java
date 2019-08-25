package com.flj.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author flj
 * @Description:
 * @date 2019-08-25 18:42
 **/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into user (username,age)VALUES(?,?);";
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,username,19);
    }

}
