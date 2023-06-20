package com.joaofranca.finalTjw.repository;

import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
