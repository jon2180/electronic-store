package com.huangyunchi.dao;

import com.huangyunchi.entity.Product;
import com.huangyunchi.entity.common.Page;

import java.util.List;

public interface ProductDAO {

    boolean save(Product product);

    boolean remove(Integer ID);

    boolean update(Product product);

    Product findByID(Integer ID);

    List<Product> findByIDs(Integer... IDs);

    Page<Product> findAll(int cate_id, String title, int number, int size);

    Page<Product> findByPaging(int number, int size);

    Page<Product> findBySubCategory(Integer categoryID, int number, int size);

    Page<Product> findHot(int number, int size);

    Page<Product> findHotTopCategory(Integer cate_id, int number, int size);

    Page<Product> findHotSubCategory(Integer cate_id, int number, int size);

    Page<Product> findByLikeName(String name, int number, int size);

    Page<Product> findByTopCategory(Integer cate_id, int number, int size);

    long getCount();


}
