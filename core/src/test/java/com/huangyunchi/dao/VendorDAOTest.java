package com.huangyunchi.dao;

import com.huangyunchi.dao.impl.VendorDAOImpl;
import com.huangyunchi.entity.Vendor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class VendorDAOTest {

    VendorDAO vendorDAO = new VendorDAOImpl();

    @Test
    @Disabled
    public void testInsert() {
        Vendor vendor = new Vendor();
        try {
            System.out.println(vendorDAO.save(vendor));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Test
    @Disabled
    public void testFindById() {
        try {
            vendorDAO.findById(1);
            assertNotNull(vendorDAO.findById(1));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }
}
