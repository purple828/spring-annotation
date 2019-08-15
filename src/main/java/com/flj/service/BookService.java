package com.flj.service;

import com.flj.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:45
 **/
@Service
public class BookService {

//    @Qualifier("bookDao")
//    @Autowired(required = false)
    @Resource
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao="+bookDao+"]";
    }
}
