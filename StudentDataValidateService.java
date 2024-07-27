package com.sample.test.validService;

import com.sample.test.Repository.StudentRepository;
import com.sample.test.beanProjection.MobileBean;
import com.sample.test.beanProjection.StudentBean;
import com.sample.test.dto.*;
import com.sample.test.entity.AddressEntity;
import com.sample.test.entity.ParentEntity;
import com.sample.test.entity.StudentEntity;
import com.sample.test.utile.UtileService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentDataValidateService {

    @Autowired
    private @NotNull
    StudentRepository studentRepository;


    public StudentSaveDTO studentValidate(StudentCreateDTO studentCreateDTO) throws InvalidNameException {

        //I wanted to acces the variables betweemn different dto so thats why i created a studentcreate dto which contains
        //all the dto objects by creating their getter and setter im using them

        StudentDTO studentDTO = studentCreateDTO.getStudentinfo();
        ParentDTO fatherDTO = studentCreateDTO.getFatherinfo();
        ParentDTO motherDTO = studentCreateDTO.getMotherinfo();
        AddressDTO localAddress = studentCreateDTO.getLocalAddress();
        AddressDTO permanentAddress = studentCreateDTO.getPermanentAddress();

        StudentSaveDTO studentSaveDTO=new StudentSaveDTO();
//While loop because I want to make sure that untill and unless user enters the details correctly i will not move forward

        /**Student data validate method**/
        StudentEntity studentData =this.validateStudent(studentDTO);
        /** i have created a new dto class which contains objects of entity and why i have created only a dto because from here I am passing the data to controller and DTO is used to transfer data**/
        /**DTO=Data transfer Object**/
        studentSaveDTO.setStudentEntity(studentData);
        /**Student data validate method**/
        ParentEntity fatherData= this.validateFather(fatherDTO);
        studentSaveDTO.setFatherEntity(fatherData);
        /**Student data validate method**/
        ParentEntity motherData= this.validateMother(motherDTO);
        studentSaveDTO.setMotherEntity(motherData);
        /**Student data validate method**/
        AddressEntity localAddData= this.validateLocalAddress(localAddress);
        studentSaveDTO.setLocalEntity(localAddData);
        /**Student data validate method**/
        AddressEntity parmanentAddData= this.validatePermanentAddress(permanentAddress);
        studentSaveDTO.setParmanentEntity(parmanentAddData);

        //setting the data in the entity so that all the data gets stored in the database

        return studentSaveDTO;
    }


    /**parmanent address validate**/
    private AddressEntity validatePermanentAddress(AddressDTO permanentAddress) throws InvalidNameException {

        AddressEntity permanentEntity=new AddressEntity();

        if(permanentAddress.getAddress().isEmpty()){
            throw new InvalidNameException("Addresss should not be empty");
        }

        else if(UtileService.validAddressString(permanentAddress.getAddress())){
            permanentEntity.setAddress(permanentAddress.getAddress());

        }
        else {
            throw new InvalidNameException("Address is in bad format ");

        }

         if(permanentAddress.getCity().isEmpty()){
                throw new InvalidNameException("City should not be empty");
        }
         else if(UtileService.validString(permanentAddress.getCity())){
             permanentEntity.setCity(permanentAddress.getCity());
         }
         else {
             throw new InvalidNameException("city name is in bad format");
         }

        /**state valid**/
         if(permanentAddress.getState().isEmpty()){
                throw new InvalidNameException("State should not be empty");
        }
         else if(UtileService.validString(permanentAddress.getState())){
             permanentEntity.setState(permanentAddress.getState());
         }

        else {
             throw new InvalidNameException("Wrong city name");
         }

        if(permanentAddress.getPincode()==null){
            throw new InvalidNameException("Pincode should not be zero");
        }
        else if(UtileService.validateCode(permanentAddress.getPincode())){
            permanentEntity.setPincode(permanentAddress.getPincode());
        }

        else {
            throw new InvalidNameException("Pin code should be of six digits only");
        }

        permanentEntity.setStudentid(permanentAddress.getStudentId());
        if(permanentAddress.getType()==null) {
           throw new InvalidNameException("Type for permanent address is required");
        }
        else {
            permanentEntity.setType(permanentAddress.getType());
        }
        return permanentEntity;
    }


    /**Local address validator**/
    private AddressEntity validateLocalAddress(AddressDTO localAddress) throws InvalidNameException {

        AddressEntity localEntity=new AddressEntity();

        if(localAddress.getAddress().isEmpty()){
            throw new InvalidNameException("Addresss should not be empty");
        }

        else if(UtileService.validAddressString(localAddress.getAddress())){
            localEntity.setAddress(localAddress.getAddress());

        }
        else {
            throw new InvalidNameException("Address is in bad format ");

        }

        if(localAddress.getCity().isEmpty()){
            throw new InvalidNameException("City should not be empty");
        }
        else if(UtileService.validString(localAddress.getCity())){
            localEntity.setCity(localAddress.getCity());
        }
        else {
            throw new InvalidNameException("city name is in bad format");
        }

        /**state valid**/
        if(localAddress.getState().isEmpty()){
            throw new InvalidNameException("State should not be empty");
        }
        else if(UtileService.validString(localAddress.getState())){
            localEntity.setState(localAddress.getState());
        }

        else {
            throw new InvalidNameException("Wrong city name");
        }

        if(localAddress.getPincode()==null){
            throw new InvalidNameException("Pincode should not be zero");
        }
        else if(UtileService.validateCode(localAddress.getPincode())){
            localEntity.setPincode(localAddress.getPincode());
        }

        else {
            throw new InvalidNameException("Pin code should be of six digits only");
        }


        localAddress.setStudentId(localAddress.getStudentId());
        if(localAddress.getType()==null){
            throw new InvalidNameException("Local Address Type is required");
        }
        else {
            localEntity.setType(localAddress.getType());
        }
        return localEntity;


    }

    /**Mother info validator**/
    private ParentEntity validateMother(ParentDTO motherDTO) throws InvalidNameException {

        ParentEntity motherEntity=new ParentEntity();

            if (motherDTO.getFirstName()==null) {
                throw new InvalidNameException("First Name should not be empty");
            }
            else if(UtileService.validString(motherDTO.getFirstName())){
                motherEntity.setFirstName(motherDTO.getFirstName());

            }
            else{
                throw new InvalidNameException("First Name is in bad format");
            }

             if (motherDTO.getMiddleName()==null) {
                throw new InvalidNameException("First Name should not be empty");
            }
             else if(UtileService.validString(motherDTO.getMiddleName())){
                 motherEntity.setMiddleName(motherDTO.getMiddleName());
             }
             else{
                 throw new InvalidNameException("Middle Name is in bad format");
             }

             if (motherDTO.getLastName()==null) {
                throw new InvalidNameException("First Name should not be empty");
            }
             else if(UtileService.validString(motherDTO.getLastName())){
                 motherEntity.setLastName(motherDTO.getLastName());
             }
             else{
                 throw new InvalidNameException("last Name is in bad format");
             }

             if (motherDTO.getEmail()==null) {
                throw new InvalidNameException("Email should not be empty");
            }
             else if(UtileService.validateEmail(motherDTO.getEmail())){
                 motherEntity.setEmail(motherDTO.getEmail());
             }
             else{
                 throw new InvalidNameException("Email is in bad format");
             }
        if (motherDTO.getMobileNo()==null) {
            throw new InvalidNameException("Email should not be empty");
        }
        else if(UtileService.validateMobileNo(motherDTO.getMobileNo())){
            motherEntity.setMobileNo(motherDTO.getMobileNo());
        }
        else{
            throw new InvalidNameException("Email is in bad format");
        }


        motherEntity.setStudentId(motherDTO.getStudentId());

        if(motherDTO.getType()==null) {
            throw new InvalidNameException("Type for MotherInfo is required");
        }
        else {
            motherEntity.setType(motherDTO.getType());
        }
        return motherEntity;

    }

    /**father info validator**/
    private ParentEntity validateFather(ParentDTO fatherDTO) throws InvalidNameException {
        /** To validate father first name present or not*/

        ParentEntity fatherentity=new ParentEntity();

        if (fatherDTO.getFirstName()==null) {
            throw new InvalidNameException("First Name should not be empty");
        }
        else if(UtileService.validString(fatherDTO.getFirstName())){
            fatherentity.setFirstName(fatherDTO.getFirstName());

        }
        else{
            throw new InvalidNameException("First Name is in bad format");
        }

        if (fatherDTO.getMiddleName()==null) {
            throw new InvalidNameException("First Name should not be empty");
        }
        else if(UtileService.validString(fatherDTO.getMiddleName())){
            fatherentity.setMiddleName(fatherDTO.getMiddleName());
        }
        else{
            throw new InvalidNameException("Middle Name is in bad format");
        }

        if (fatherDTO.getLastName()==null) {
            throw new InvalidNameException("First Name should not be empty");
        }
        else if(UtileService.validString(fatherDTO.getLastName())){
            fatherentity.setLastName(fatherDTO.getLastName());
        }
        else{
            throw new InvalidNameException("last Name is in bad format");
        }

        if (fatherDTO.getEmail()==null) {
            throw new InvalidNameException("Email should not be empty");
        }
        else if(UtileService.validateEmail(fatherDTO.getEmail())){
            fatherentity.setEmail(fatherDTO.getEmail());
        }
        else{
            throw new InvalidNameException("Email is in bad format");
        }
        if (fatherDTO.getMobileNo()==0) {
            throw new InvalidNameException("Email should not be empty");
        }
        else if(UtileService.validateMobileNo(fatherDTO.getMobileNo())){
            fatherentity.setMobileNo(fatherDTO.getMobileNo());
        }
        else{
            throw new InvalidNameException("Email is in bad format");
        }

        fatherentity.setStudentId(fatherDTO.getStudentId());
        if(fatherDTO.getType()==null){
            throw new InvalidNameException("Type for FatherInfo is required");
        }
        else {
            fatherentity.setType(fatherDTO.getType());
        }

        return fatherentity;

    }


    /**Student info validator**/
    private StudentEntity validateStudent(StudentDTO studentDTO) throws InvalidNameException {
        StudentEntity studentEntity = new StudentEntity();
        /** To validate student first name present or not*/
        if (studentDTO.getFirstName()==null) {
            throw new InvalidNameException("name should not be empty");
        }
        else if(UtileService.validString(studentDTO.getFirstName())){
            studentEntity.setFirstName(studentDTO.getFirstName());
        }
        else{
            throw new InvalidNameException("First Name is in bad format");
        }


        if (Objects.isNull(studentDTO.getMiddleName())) {
                throw new InvalidNameException("middle name should not be empty");
        }
        else if(UtileService.validString(studentDTO.getMiddleName())){
            studentEntity.setMiddleName(studentDTO.getMiddleName());
        }
        else{
            throw new InvalidNameException("Middle Name is in bad format");
        }


         if (Objects.isNull(studentDTO.getLastName())) {
                throw new InvalidNameException("lastname should not be empty");
        }
         else if(UtileService.validString(studentDTO.getLastName())){
             studentEntity.setLastName(studentDTO.getLastName());
         }
         else{
             throw new InvalidNameException("last Name is in bad format");
         }


         if (studentDTO.getMobileNo()==null) {
                throw new InvalidNameException("mobile number should not be greater than 10 digit");
        }
         else if(UtileService.validateMobileNo(studentDTO.getMobileNo())){

             Optional<MobileBean> existingStudent= studentRepository.findByMobileNo(studentDTO.getMobileNo());

             if(existingStudent.isPresent()){
                 throw new InvalidNameException("Mobile_No is already in use");
             }

             else {
                 studentEntity.setMobileNo(studentDTO.getMobileNo());
             }
         }
         else{
             throw new InvalidNameException("Mobile no is in format");
         }


        if (studentDTO.getEmail()==null) {
                throw new InvalidNameException("email should not be empty");
        }
        else if(UtileService.validateEmail(studentDTO.getEmail())){
            Optional<StudentBean> existingStudentOptional = studentRepository.findByEmailId(studentDTO.getEmail());

            if(existingStudentOptional.isPresent()) {
                throw new InvalidNameException("Email is already in use");
            }
            else {
                studentEntity.setEmail(studentDTO.getEmail());
            }
        }
        else{
            throw new InvalidNameException("Email is in bad format");
        }
        return studentEntity;
    }

//    public static boolean emailAlreadyExists(String email) {
////        Optional<StudentBean> existingStudent = studentRepo.findByEmailId(email);
////        return existingStudent.isPresent();
//
//
//        if (existingStudentOptional.isPresent()) {
//            StudentBean existingStudent = existingStudentOptional.get();
//            // Process existingStudent
//        } else {
//            return false;
//            // Handle case where no student with the email exists
//        }
//        return false;
//    }
}
