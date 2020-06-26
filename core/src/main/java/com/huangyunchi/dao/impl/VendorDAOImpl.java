package com.huangyunchi.dao.impl;

import com.huangyunchi.common.BaseDAO;
import com.huangyunchi.dao.VendorDAO;
import com.huangyunchi.entity.Vendor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class VendorDAOImpl extends BaseDAO implements VendorDAO {
    @Override
    public int save(Vendor vendor) throws SQLException {
        String sql = "insert into vendor(vendor_name, vendor_license, vendor_tel, vendor_email, vendor_password, vendor_score, vendor_level, vendor_register_time, vendor_status) VALUES (?,?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(getDataSource());
        Long rst = qr.insert(sql, new ScalarHandler<>(),
                vendor.getVendorName(), vendor.getVendorLicense(), vendor.getVendorTel(),
                vendor.getVendorEmail(), vendor.getVendorPassword(), vendor.getVendorScore(),
                vendor.getVendorLevel(), vendor.getVendorRegisterTime(), vendor.getVendorStatus()
        );

        vendor.setVendorId(rst);
        return 0;
    }

    @Override
    public int update(Vendor vendor) throws SQLException {
        String sql = "update vendor set vendor_name=?, vendor_license=?, vendor_tel=?, vendor_email=?, vendor_password=?, vendor_score=?, vendor_level=?,vendor_register_time=?,vendor_status=? where vendor_id=?";
        QueryRunner qr = new QueryRunner(getDataSource());
        return qr.update(sql,
                vendor.getVendorName(), vendor.getVendorLicense(), vendor.getVendorTel(),
                vendor.getVendorEmail(), vendor.getVendorPassword(), vendor.getVendorScore(),
                vendor.getVendorLevel(), vendor.getVendorRegisterTime(), vendor.getVendorStatus(),
                vendor.getVendorId());
    }

    @Override
    public int remove(Integer id) throws SQLException {
        QueryRunner qr = new QueryRunner(getDataSource());
        return qr.update("delete from vendor where vendor_id=?", id);
    }

    @Override
    public Vendor findById(Integer id) throws SQLException {
        QueryRunner qr = new QueryRunner(getDataSource());
        return qr.query("select * from vendor where vendor_id=?", new BeanHandler<>(Vendor.class), id);
    }

    @Override
    public Vendor findByTel(String tel) throws SQLException {
        QueryRunner qr = new QueryRunner(getDataSource());
        return qr.query("select * from vendor where vendor_tel=?", new BeanHandler<>(Vendor.class), tel);
    }
}
