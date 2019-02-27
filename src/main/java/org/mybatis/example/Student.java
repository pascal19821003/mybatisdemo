package org.mybatis.example;

/**
 * Created by pascal on 2/27/19.
 *
 *  create table student(id int(4) not null auto_increment, name varchar(100) not null, primary key(id))
 *
 *
 */
public class Student {
    private int id;
    private String name;

    public Student( String name) {
        this.name = name;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
