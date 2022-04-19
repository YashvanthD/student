package com.example.student.Entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class student {

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String subject;


}
