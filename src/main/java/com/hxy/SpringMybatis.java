package com.hxy;

import com.hxy.mapper.StudentMapper;
import com.hxy.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * mybatis 结合spring
 * Created by hxy-pc on 2016/7/31.
 *
 */
public class SpringMybatis {
    private static ApplicationContext  applicationContext = null;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

//    SqlSession sqlSession = (SqlSession) applicationContext.getBean("sqlSession");
    public static void main(String[] args) {
        new SpringMybatis().foo();
    }

    @Transactional
    public void foo() {
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);


        StudentMapper mapper = (StudentMapper) applicationContext.getBean("studentMapper"); //直接获取mapper bean，不用获取sqlsession
        Student student = new Student();
        student.setDate(new Date());
        student.setEmail("oheasy@gmail.com");
        student.setName("okok");

        mapper.insertStudent(student);
        throw new RuntimeException();
    }
}
