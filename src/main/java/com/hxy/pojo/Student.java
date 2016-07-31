package com.hxy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by hxy-pc on 2016/7/31.
 */
@Data
public class Student {
    private int id;
    private String name;
    private String email;
    private Date date;
}
