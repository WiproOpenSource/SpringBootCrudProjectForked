package com.crud.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.hibernate.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
