package lxp.crud.controller;

import lxp.crud.domain.Student;
import lxp.crud.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Author ASUS
 * @Date 2020/10/31
 * @Description TODO
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    IStudentService studentService;

    @PostMapping("/insert")
    public void insert(@RequestBody Student student) {
        studentService.insert(student);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
        studentService.delete(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @GetMapping("/select")
    public List<Student> select(HttpServletRequest request) {
        String keywords = request.getParameter("keywords");
        List<Student> students =  studentService.selectByName(keywords);
        return students;
    }


}
