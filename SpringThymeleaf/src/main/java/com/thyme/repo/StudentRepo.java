package com.thyme.repo;

import org.springframework.data.repository.CrudRepository;

import com.thyme.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
