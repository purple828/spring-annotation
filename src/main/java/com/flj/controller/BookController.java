package com.flj.controller;

import com.flj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:44
 **/
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
