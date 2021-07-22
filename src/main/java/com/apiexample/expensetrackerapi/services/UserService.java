package com.apiexample.expensetrackerapi.services;

import com.apiexample.expensetrackerapi.Domain.User;
import com.apiexample.expensetrackerapi.Exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email,String password) throws EtAuthException;
    User registerUser(String firstName,String lastName,String email,String password) throws EtAuthException;
}

