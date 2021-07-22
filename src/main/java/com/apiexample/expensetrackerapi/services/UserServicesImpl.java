package com.apiexample.expensetrackerapi.services;

import com.apiexample.expensetrackerapi.Domain.User;
import com.apiexample.expensetrackerapi.Exceptions.EtAuthException;
import com.apiexample.expensetrackerapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServicesImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email!=null) email=email.toLowerCase();
        return userRepository.findEmailAndPassword(email,password);
    }

    @Override
    public User registerUser(String firstname, String lastname, String email, String password) throws EtAuthException {
        Pattern pattern=Pattern.compile("(.+)@(.+)$");//Checking if email format is vaild
        if(email!=null) email=email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        Integer count=userRepository.getCountByEmail((email));
        if(count>0)
            throw new EtAuthException("Email already in use");
        Integer userId=userRepository.create(firstname,lastname,email,password);
        return userRepository.findById(userId);
    }
}
