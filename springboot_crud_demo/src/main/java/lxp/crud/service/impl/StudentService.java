package lxp.crud.service.impl;

import lxp.crud.domain.Student;
import lxp.crud.mapper.StudentMapper;
import lxp.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ASUS
 * @Date 2020/10/31
 * @Description TODO
 **/
@Service
public class StudentService implements IStudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public int insert(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public List<Student> selectByName(String keywords) {
        if(keywords == null || keywords.equals("")) {
            return studentMapper.selectAll();
        }
        else {
            return studentMapper.selectByName(keywords);
        }
    }
}
