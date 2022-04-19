package com.example.student.services;


import com.example.student.Entity.student;
import com.example.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class studentServices  {

    @Autowired
    private StudentRepository studentRepo;

    public student saveStudent(student stu) {
        log.info(" Student Created ");
        return studentRepo.save(stu);
    }

    public Optional<student> findStudentByid(Long id) {
        log.info(" Student Search ");
        student stu =new student();
        if (!studentRepo.findById(id).isPresent())
        {

            log.info("Studen not found");
        }
       return studentRepo.findById(id);
    }

    public student updateStudent(student stu) {
        log.info(" Student Updated ");
        return studentRepo.save(stu);
    }

    public String deteteStudent(Long id) {
        Optional<student> stu = studentRepo.findById(id);
        if(stu.isPresent()){
            student dstu=stu.get();
            log.info(String.valueOf(dstu));
            studentRepo.delete(dstu);
            return "Student Deleted ";
        }
        else{
            log.info(String.valueOf(stu));
            return "Student not found";
        }

    }
}
