package com.hxy;

import com.hxy.mapper.StudentMapper;
import com.hxy.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        App app = new App();
        app.foo();
    }

    public void foo() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setDate(new Date());
        student.setName("houxiaoyu");
        student.setEmail("oheasy@163.com");
        mapper.insertStudent(student);

        sqlSession.commit();
        sqlSession.close();
    }
}
