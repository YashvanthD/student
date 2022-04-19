package com.example.student.controller;


import com.example.student.Entity.student;
import com.example.student.services.studentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/student")
public class studentController {

    @Autowired
    private studentServices StuServices;


@PostMapping(path="/add")
    public student addStudent(@RequestBody student stu){
    log.info("Inside Student ");
    return StuServices.saveStudent(stu);
    }
@RequestMapping(method = RequestMethod.GET,path="/{id}")
    public Optional<student> findStudent(@PathVariable Long id){
    log.info("Searching Student ... ");
    System.out.print(id);
    return StuServices.findStudentByid(id);

    }

    @PutMapping(path="/update")
    public Optional<student> updateStudent(@RequestBody student stu){
        log.info("Searching Student ... ");
       Optional<student> nstu = StuServices.findStudentByid(stu.getId());
       if(!nstu.isPresent()){
           log.info("User Not found So initializing with new one");
           return Optional.ofNullable(StuServices.saveStudent(stu));
       }
        log.info("User Updated");
        return Optional.ofNullable(StuServices.updateStudent(stu));
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
    log.info("Student id " + id);
        return StuServices.deteteStudent(id);
    }

}
