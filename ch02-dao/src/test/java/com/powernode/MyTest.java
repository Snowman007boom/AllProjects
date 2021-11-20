package com.powernode;

import com.powernode.domain.Student;
import com.powernode.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void testSelectById(){
        SqlSession session = MybatisUtil.getSqlSession();
        String sqlId ="com.bjpowenode.dao.StudentDao.seleceById";
        Student student = (Student) session.selectOne(sqlId,1002);
        System.out.println(student.toString());
        session.close();
    }
}
