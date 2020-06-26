package com.huangyunchi.vendor.service;

import com.huangyunchi.dao.VendorDAO;
import com.huangyunchi.dao.impl.VendorDAOImpl;
import com.huangyunchi.entity.Vendor;

import java.sql.SQLException;

public class VendorService {

    private final VendorDAO vendorDAO = new VendorDAOImpl();

    public boolean register(Vendor v) {

        Vendor vendor = null;
        try {
            vendor = vendorDAO.findByTel(v.getVendorTel());

            if (vendor != null) {
                return false;
            }
            vendorDAO.save(v);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }

}
