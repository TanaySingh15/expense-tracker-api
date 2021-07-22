package com.apiexample.expensetrackerapi.Repositories;

import com.apiexample.expensetrackerapi.Domain.User;
import com.apiexample.expensetrackerapi.Exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstname,String lastname,String email,String password)throws EtAuthException;
    User findEmailAndPassword(String email,String password) throws EtAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
}
