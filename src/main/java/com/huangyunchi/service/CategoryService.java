package com.huangyunchi.service;

import com.huangyunchi.dao.CategoryDAO;
import com.huangyunchi.dao.impl.CategoryDAOImpl;
import com.huangyunchi.entity.Category;

import java.util.List;


/**
 * @author qiujy
 */
public class CategoryService {

    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    public Category save(Category cate) throws RuntimeException {
        categoryDAO.save(cate);
        return cate;
    }

    public void update(Category cate) throws RuntimeException {
        categoryDAO.update(cate);
    }

    public Category findOne(Integer id) throws RuntimeException {
        return categoryDAO.find(id);
    }

    public List<Category> findAll() throws RuntimeException {
        return categoryDAO.findAll();
    }


    public void delete(Integer id) throws RuntimeException {
        categoryDAO.remove(id);
    }
}