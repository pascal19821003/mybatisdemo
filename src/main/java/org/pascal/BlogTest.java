package org.pascal;

import org.mybatis.example.Blog;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by pascal on 2/27/19.
 *  crud operations
 */
public class BlogTest {
    public static void main(String[] args) {
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne( "org.mybatis.example.BlogMapper.selectBlog", 101);
            System.out.println(blog.getName());
        } finally {
           // session.close();
        }

        //add
        try {
            Blog blog = new Blog();
            blog.setName("Jim");
            blog.setId(2);
            int insert = session.insert("org.mybatis.example.BlogMapper.insertBlog", blog);
            System.out.println("insert successful! insert: " + insert);
            session.commit();
        } finally {
           // session.close();
        }


        //update
        try {
            Blog blog = new Blog();
            blog.setName("Jim2");
            blog.setId(2);
            int update = session.update("org.mybatis.example.BlogMapper.updateBlog", blog);
            System.out.println("update successful! update: " + update);
            session.commit();
        } finally {
            // session.close();
        }




        // select all
        try{
            List<Blog> blogs = session.selectList("org.mybatis.example.BlogMapper.selectAll");
            System.out.println("blogs.size: " + blogs.size());
            for (Blog blog : blogs) {
                System.out.println(blog.getId() + " " +blog.getName());
            }
        }finally {

        }

        //delete
        try{
            int id=2;
            int delete = session.delete("org.mybatis.example.BlogMapper.deleteBlogById", id);
            System.out.println("delete successful. delete: " + delete);
            session.commit();
        }finally {

        }


    }
}
