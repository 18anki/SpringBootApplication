package com.sample.test.utile;


import com.sample.test.Repository.StudentRepository;
import com.sample.test.beanProjection.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UtileService {
    @Autowired
    private static StudentRepository studentRepo;

    /**
     * Here i am creating a method to validate all the data
     **/

    public static boolean validAddressString(String name) {
        return name.matches("[A-Za-z0-9'\\.\\-\\s\\,]*");

    }

    public static boolean validString(String stringVar) {
        return stringVar.matches("[A-z][a-z]*");
    }

    public static boolean validateCode(int code) {
        String codeint = String.valueOf(code);
        return codeint.matches("[0-9]{6}");
    }

    public static boolean validateMobileNo(long mobileNo) {
        String mobno = String.valueOf(mobileNo);
        return mobno.matches("[0-9]{10}");
    }

    public static boolean validateEmail(String email) {

        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }


//    public static boolean validateEmail(String email) throws InvalidNameException {
//        // Validate email format
//        if (!isValidEmailFormat(email)) {
//            throw new InvalidNameException("Invalid email format");
//        }
//
//
//        return true; // Or return false if you just want to validate without throwing exceptions
//    }
//
//    public static boolean isValidEmailFormat(String email) {
//        // Example of a more comprehensive email validation regex
//        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
//    }

//


}



