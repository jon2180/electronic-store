package com.huangyunchi.dao;

import com.huangyunchi.entity.Vendor;

import java.sql.SQLException;

public interface VendorDAO {

    int save(Vendor vendor) throws SQLException;

    int update(Vendor vendor) throws SQLException;

    int remove(Integer id) throws SQLException;

    Vendor findById(Integer id) throws SQLException;

    Vendor findByTel(String tel) throws SQLException;
}
