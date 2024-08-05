package com.tms.lesson52.hw.repository;

import java.util.List;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import com.tms.lesson52.hw.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentBySurname(String surname);

    Student findStudentByName(String name);

    @Query("SELECT s FROM Student s WHERE s.groupId = :groupId")
    List<Student> findStudentsByGroupId(@Param("groupId") Integer groupId);

    @Query("SELECT s FROM Student s WHERE s.ispaid = :ispaid")
    List<Student> findStudentsByPayment(@Param("ispaid") Boolean ispaid);
}
