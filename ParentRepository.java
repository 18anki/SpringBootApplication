package com.sample.test.Repository;

import com.sample.test.entity.AddressEntity;
import com.sample.test.entity.ParentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ParentRepository extends CrudRepository<ParentEntity,Integer> {

    List<ParentEntity> findByStudentId(Long student_id);

    @Transactional
    public void deleteByStudentId(Long student_id);

}
