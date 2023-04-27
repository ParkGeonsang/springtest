package com.spring.springtest.controller;

import com.spring.springtest.entity.Infomation;
import com.spring.springtest.entity.InfomationDto;
import com.spring.springtest.entity.Student;
import com.spring.springtest.entity.StudentDto;
import com.spring.springtest.service.StuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class mainController {

    private final StuService stuService;

    @GetMapping("/")
    public String index(Model model){
        List<Student> student = stuService.findStudent();
        if (student != null){
            model.addAttribute("student",student);
        }

        return "index";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute StudentDto studentDto,
                       @ModelAttribute InfomationDto infomationDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        stuService.join(student);

        Infomation infomation = new Infomation();
        infomation.setAddr(infomationDto.getAddr());
        infomation.setUniv(infomationDto.getUniv());
        infomation.setMajor(infomationDto.getMajor());
        infomation.setStu_id(student.getId());
        stuService.infoSave(infomation);

        return "redirect:/";
    }

    @GetMapping("/shStu")
    public String stu(){
        return "shStu";
    }

    @GetMapping("/sh")
    public String sh(@RequestParam("name") String name,
                     Model model){
        List<Student> li = stuService.findByname(name);
        model.addAttribute("li",li);
        return "shStu";
    }

    @GetMapping("/info")
    public String info(@RequestParam("stu_id") Long stu_id,
                       Model model){
        Student student = stuService.findById(stu_id);
        Infomation infomation = stuService.findStuInfo(stu_id);
        model.addAttribute("info",infomation);
        model.addAttribute("stu",student);
        return "info";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("stu_id") Long stu_id){
        stuService.deleteStudent(stu_id);
        return "redirect:shStu";
    }

    @PostMapping("/modify")
    public String modify_pro(@RequestParam("idx") Long idx,
                           @ModelAttribute InfomationDto infomationDto,
                             Model model){
        Student student = stuService.findById(idx);
        Infomation infomation = stuService.findStuInfo(student.getId());
        infomation.setAddr(infomationDto.getAddr());
        infomation.setUniv(infomationDto.getUniv());
        infomation.setMajor(infomationDto.getMajor());
        infomation.setStu_id(student.getId());
        model.addAttribute("stu",student);
        model.addAttribute("info",infomation);

        stuService.infoSave(infomation);
        return "info";
    }

}
