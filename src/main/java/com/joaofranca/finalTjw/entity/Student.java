package com.joaofranca.finalTjw.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = "name",nullable = false,unique = false)
    private String name;
    @Column(name = "cpf",nullable = false,unique = true)
    private String cpf;
    @Column(name = "age",nullable = false,unique = false)
    private int age;


//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "students_classrooms",
//            joinColumns = @JoinColumn(name = "student_id" ),
//            inverseJoinColumns = @JoinColumn(name = "classroom_id")
//    )
    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private List<Classroom> classrooms;

    @Builder
    public Student(String name, String cpf, int age, List<Classroom> classrooms) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.classrooms = classrooms;
    }
}
