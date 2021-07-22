package com.apiexample.expensetrackerapi.services;

import com.apiexample.expensetrackerapi.Domain.Category;
import com.apiexample.expensetrackerapi.Exceptions.EtBadRequestException;
import com.apiexample.expensetrackerapi.Exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId,Integer categoryId)throws EtResourceNotFoundException;
    Category addCategory(Integer userId,String title,String description) throws EtBadRequestException;
    void update(Integer userId,Integer categoryId,Category category)throws EtBadRequestException;
    void removeCategoryWithAllTransactions(Integer userId,Integer categoryId) throws EtResourceNotFoundException;
}
