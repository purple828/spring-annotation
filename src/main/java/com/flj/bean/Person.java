package com.flj.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author flj
 * @Description:
 * @date 2019-08-14 16:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String name;

    private Integer age;

}
