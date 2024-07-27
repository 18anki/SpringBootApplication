package com.sample.test.Repository;

import com.sample.test.beanProjection.MobileBean;
import com.sample.test.beanProjection.StudentAndAddress;
import com.sample.test.beanProjection.StudentBean;
import com.sample.test.dto.StudentSaveDTO;
import com.sample.test.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Long> {
    /**As this is studentRepository so it is saving the data od student entity and I am using this method to save studententity object so thats why i have defined StudentEntity object**/
    Optional<StudentEntity> findById(Long id);

//    Optional<StudentEntity> deleteById(Long id);


    @Query(value = "SELECT s.id as id,s.email_id as email FROM student_database s WHERE s.email_id = :email ", nativeQuery = true)
    Optional<StudentBean> findByEmailId(@Param("email") String email);

    @Query(value = "SELECT s.id as id, s.mobile_no as mobileno FROM student_database s WHERE s.mobile_no =:mobileno", nativeQuery = true)
    Optional<MobileBean> findByMobileNo(@Param("mobileno") Long mobileno);

    @Query(value = "SELECT s.id as id,s.email_id as email FROM student_database s", nativeQuery = true)
    List<StudentBean> findAllEmailAndId();

    @Query(value = "\n" +
            "SELECT s.id as studentId, s.first_name as name, a.address as address, a.id as Id, a.city as city, a.state as state,a.type as type \n" +
            "FROM student_database s \n" +
            "INNER JOIN address_database a ON s.id=a.student_id",nativeQuery = true)
    List<StudentAndAddress> findJoinDataAddress();


    @Query(value = "SELECT s.id as studentId,p.id as parentId,p.first_name as parentName,p.mobile_no as phoneNo,p.type as parentType\n" +
            "FROM student_database s \n" +
            "INNER JOIN parent_database p ON s.id=p.student_id",nativeQuery = true)
    List<StudentAndAddress> findJoinDataParent();

    @Query(value ="SELECT s.id as studentId,s.first_name as name,p.id as parentId,p.first_name as parentName,p.mobile_no as phoneNo,p.type as parentType\n" +
            "FROM student_database s \n" +
            "INNER JOIN parent_database p ON s.id=p.student_id\n" +
            "WHERE s.id= :id",nativeQuery = true )
    List<StudentAndAddress> findJoinDataByIdParent(@Param("id") Long id);

    @Query(value="SELECT a.address as address,a.id as Id, a.city as city,a.state as state,a.type as type\n" +
            "FROM student_database s \n" +
            "INNER JOIN address_database a ON s.id=a.student_id\n" +
            "WHERE s.id= :id",nativeQuery = true)
    List<StudentAndAddress> findJoinDataByIdAddress(@Param("id") Long id);


}
