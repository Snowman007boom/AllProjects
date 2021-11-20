package com.bjpowenode.dao;

import com.bjpowenode.domian.Student;

public interface StudentDao {

    Student selectStudentById(Integer id);

    int insertStudent(Student student);

    int updateStudent(Student student);
}
