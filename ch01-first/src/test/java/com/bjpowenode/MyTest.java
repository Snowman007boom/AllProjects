package com.bjpowenode;

import com.bjpowenode.domian.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    @Test
    public void testSelectStudentById() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类：SqlSessionFactory

        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


        //4.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //5.指定要执行sql语句的id
        // sql的id = namespace + "."+ select|update|insert|delete标签的属性id
        String sqlid ="com.bjpowenode.dao.StudentDao"+"."+"selectStudentById";

        //6.通过sqlsession方法执行sql语句
        Student student = sqlSession.selectOne(sqlid);
        System.out.println(student);

        //7.关闭session
        sqlSession.close();

    }
    @Test
    public void testSelectStudentById2() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类：SqlSessionFactory

        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


        //4.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //5.指定要执行sql语句的id
        // sql的id = namespace + "."+ select|update|insert|delete标签的属性id
        String sqlid ="com.bjpowenode.dao.StudentDao"+"."+"selectStudentById";

        //6.通过sqlsession方法执行sql语句
        Student student = sqlSession.selectOne(sqlid,1001);
        System.out.println(student);

        //7.关闭session
        sqlSession.close();

    }

    @Test
    public void testInsertStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类：SqlSessionFactory

        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


        //4.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //5.指定要执行sql语句的id
        // sql的id = namespace + "."+ select|update|insert|delete标签的属性id
        String sqlid ="com.bjpowenode.dao.StudentDao"+"."+"insertStudent";

        //6.通过sqlsession方法执行sql语句
        int a =sqlSession.insert(sqlid);
        System.out.println(a);

        //手动提交事务
        sqlSession.commit();

        //7.关闭session
        sqlSession.close();

    }

    @Test
    public void testInsertStudent2() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类：SqlSessionFactory

        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


        //4.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //5.指定要执行sql语句的id
        // sql的id = namespace + "."+ select|update|insert|delete标签的属性id
        String sqlid ="com.bjpowenode.dao.StudentDao"+"."+"insertStudent";

        //6.通过sqlsession方法执行sql语句
        Student student = new Student();
        student.setAge(22);
        student.setEmail("10000");
        student.setName("张飞");
        student.setId(1021);

        int a =sqlSession.insert(sqlid,student);
        System.out.println(a);

        //手动提交事务
        sqlSession.commit();

        //7.关闭session
        sqlSession.close();

    }

    @Test
    public void testupdateStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件中的sql语句
        //mybatis核心类：SqlSessionFactory

        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


        //4.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //5.指定要执行sql语句的id
        // sql的id = namespace + "."+ select|update|insert|delete标签的属性id
        String sqlid ="com.bjpowenode.dao.StudentDao"+"."+"updateStudent";

        //6.通过sqlsession方法执行sql语句
        Student student = new Student();
        student.setAge(23);
        student.setEmail("10001");
        student.setName("张飞2");
        student.setId(1021);

        int a =sqlSession.update(sqlid,student);
        System.out.println(a);

        //手动提交事务
        sqlSession.commit();

        //7.关闭session
        sqlSession.close();

    }

}
