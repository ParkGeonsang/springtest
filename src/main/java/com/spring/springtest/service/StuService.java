package com.spring.springtest.service;

import com.spring.springtest.entity.Infomation;
import com.spring.springtest.entity.Student;
import com.spring.springtest.repository.InfoRepository;
import com.spring.springtest.repository.StuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class StuService {
    private final StuRepository stuRepository;
    private final InfoRepository infoRepository;

    public void join(Student student){
        stuRepository.save(student);
    }

    public void infoSave(Infomation infomation){
        infoRepository.save(infomation);
    }

    public List<Student> findStudent(){
        return stuRepository.findAll();
    }

    public List<Student> findByname(String name){
        return stuRepository.findByName(name);
    }
    public void deleteStudent(Long id){
        infoRepository.deleteById(id);

        stuRepository.deleteById(id);
    }

    public Student findById(Long id){
        Optional<Student> findid = stuRepository.findById(id);
        return findid.get();
    }

    public Infomation findStuInfo(Long stu_id){
        Optional<Infomation> info = infoRepository.findById(stu_id);
        return info.get();
    }

}
