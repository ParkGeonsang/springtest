package com.spring.springtest.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Infomation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addr;
    private String univ;
    private String major;
    private Long stu_id;

}
