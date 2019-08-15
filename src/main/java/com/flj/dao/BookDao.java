package com.flj.dao;

import org.springframework.stereotype.Repository;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:46
 **/
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
