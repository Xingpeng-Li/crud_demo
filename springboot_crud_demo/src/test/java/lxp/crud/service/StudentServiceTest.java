package lxp.crud.service;

import lxp.crud.domain.Student;
import lxp.crud.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@SuppressWarnings("deprecation")
class StudentServiceTest {

    @Resource
    IStudentService studentService;

    @Test
    void insert() {
        Student student = new Student(null,"John","male",new Date(),"450-531-3173","John@google.com");
        studentService.insert(student);
    }

    @Test
    void delete() {
        studentService.delete(1);
    }

    @Test
    void update() {
        Student student = new Student(3,"Mary","female",new Date(),"407-268-3258","BeautyMary@google.com");
        studentService.update(student);
    }

    @Test
    void selectByName() {
        List<Student> students = studentService.selectByName("");
        System.out.println(students);
    }
}