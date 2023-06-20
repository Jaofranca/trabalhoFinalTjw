package com.joaofranca.finalTjw.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "classrooms")
@NoArgsConstructor
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = "name",nullable = false,unique = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "classrooms",cascade = CascadeType.PERSIST)
    private List<Student> students;

    @Builder
    public Classroom(String name, Teacher teacher, List<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

}
