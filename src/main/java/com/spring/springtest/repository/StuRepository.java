package com.spring.springtest.repository;

import com.spring.springtest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuRepository extends JpaRepository<Student,Long> {

    List<Student> findByName(String name);
}
