package com.spring.springtest.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfomationDto {

    private String addr;
    private String univ;
    private String major;

}
