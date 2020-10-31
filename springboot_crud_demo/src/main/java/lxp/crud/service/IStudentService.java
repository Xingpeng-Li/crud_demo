package lxp.crud.service;

import lxp.crud.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ASUS
 * @Date 2020/10/31
 * @Description TODO
 **/
@Service
public interface IStudentService {
    int insert(Student student);
    void delete(Integer id);
    void update(Student student);
    List<Student> selectByName(String keywords);
}
