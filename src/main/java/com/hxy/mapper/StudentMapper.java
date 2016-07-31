package com.hxy.mapper;

import com.hxy.pojo.Student;

import java.util.List;

/**
 * Created by hxy-pc on 2016/7/31.
 */
public interface StudentMapper {
    List<Student> queryAllStudents();

    int insertStudent(Student student);
}
