package com.huangyunchi.common;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DbHelper单元测试类
 *
 * @author Administrator
 */

public class DbHelperTest {

    @Test
    public void testGetConnection() {
        try {
            Connection conn = DbHelper.getConn();

            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
