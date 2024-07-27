package com.sample.test.Repository;


import com.sample.test.entity.StudentDB;

import org.springframework.data.repository.CrudRepository;

public interface StudentDBRepository extends CrudRepository<StudentDB,Integer> {
}
