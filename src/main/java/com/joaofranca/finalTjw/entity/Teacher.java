package com.joaofranca.finalTjw.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
    @Table(name = "teachers")
    @NoArgsConstructor
    @Getter
    @Setter
    public class Teacher {
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
        private Integer age;

        @OneToMany(mappedBy = "teacher")
        private List<Classroom> classrooms;

        @Builder
        public Teacher(String name, String cpf, Integer age,List<Classroom> classrooms) {
            this.name = name;
            this.cpf = cpf;
            this.age = age;
            this.classrooms = classrooms;
        }
    }


