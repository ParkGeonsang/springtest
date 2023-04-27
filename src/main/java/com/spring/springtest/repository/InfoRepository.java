package com.spring.springtest.repository;

import com.spring.springtest.entity.Infomation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Infomation,Long> {

//    Infomation findByStuId(Long stu_id);

}
