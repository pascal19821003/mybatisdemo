package org.pascal;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Created by pascal on 2/27/19.
 */
public class StudentTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        //Create a new student object
        Student student = new Student("Pascal4" );

        //Insert student data
        int insert = session.insert("org.mybatis.example.StudentMapper.insert", student);
        System.out.println("record inserted successfully");
        System.out.println(student);

        session.commit();

        // get by id
        Student o = session.selectOne("org.mybatis.example.StudentMapper.getById", 1);
        System.out.println("---------one---------");
        System.out.println(o);

        // get all
        List<Student> students = session.selectList("org.mybatis.example.StudentMapper.getAll");
        System.out.println("---------list---------");
        for (Student student1 : students) {
            System.out.println(student1);
        }

        //get by name
//        Student queryStudent = new Student("%al%");
        Student queryStudent = new Student(null);
        List<Student> studentList = session.selectList("org.mybatis.example.StudentMapper.getByName", queryStudent);
        System.out.println("---------get by name---------");
        for (Student student1 : studentList) {
            System.out.println(student1);
        }

        session.close();
    }


}
