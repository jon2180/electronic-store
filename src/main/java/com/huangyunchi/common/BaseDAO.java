package com.huangyunchi.common;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO {

    private final QueryRunner qr = new QueryRunner();


    public <T> T executeUpdate(String sql, ResultSetHandler<T> rsh, Object... params) {
        Connection conn = null;
        T rs;
        try {
            conn = DbHelper.getConn(); //获取数据库连接
            conn.setAutoCommit(false); //开启事务

            //执行数据库操作的插入操作，返回生成的主键值
            rs = qr.insert(conn, sql, rsh, params);

            DbUtils.commitAndCloseQuietly(conn); //提交事务并关闭连接
        } catch (Exception e) {
            DbUtils.rollbackAndCloseQuietly(conn); //回滚事务并关闭连接

            throw new RuntimeException(e);
        }
        return rs;
    }

    public <T> List<T> executeListQuery(String sql, BeanListHandler<T> rsh, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DbHelper.getConn();
            list = qr.query(conn, sql, rsh, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }

    public <T> T executeQuery(String sql, BeanHandler<T> rsh, Object... params) {
        T rs = null;
        Connection conn = null;
        try {
            conn = DbHelper.getConn();
            rs = qr.query(conn, sql, rsh, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return rs;
    }
}
