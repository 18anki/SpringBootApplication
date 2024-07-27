package com.sample.test.Repository;

import com.sample.test.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository

public interface AddressRepository extends CrudRepository<AddressEntity,Integer> {

    List<AddressEntity> findByStudentid(Long student_id);

   @Transactional
    public void deleteByStudentid(Long student_id);


}
