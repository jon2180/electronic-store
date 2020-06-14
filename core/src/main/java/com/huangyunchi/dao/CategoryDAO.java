package com.huangyunchi.dao;

import com.huangyunchi.entity.Category;

import java.util.List;

public interface CategoryDAO {

    Category save(Category category);

    int update(Category category);

    Category find(Integer id);

    List<Category> findAll();

    void remove(Integer id);
}
