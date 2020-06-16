package com.huangyunchi.common;

import com.huangyunchi.entity.Member;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseDAOTest {

    @Test
    public void testQuery() {

        String sql = "select * from member where mobile=?";
        try {
            Member member = BaseDAO.getQr().query(sql, new BeanHandler<>(Member.class), "13344445555");
            assertEquals(member.getMobile(), "13344445555");
            System.out.println(member);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
