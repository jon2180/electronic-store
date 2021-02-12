package com.huangyunchi.dao.impl;

import com.huangyunchi.common.DbHelper;
import com.huangyunchi.dao.MemberDAO;
import com.huangyunchi.entity.Member;
import com.huangyunchi.entity.common.Page;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 会员相关的业务逻辑类---->CRUD操作
 *
 * @author Administrator
 */
public class MemberDAOImpl implements MemberDAO {

    /**
     * common-dbutils包提供的一个SQL执行器类
     */
    private final QueryRunner qr = new QueryRunner();

    /**
     * 单行单列的结果集处理器
     */
    private final ScalarHandler<BigInteger> scalarHandler = new ScalarHandler<>();
    /**
     * 单行多列的结果集处理
     */
    private final BeanHandler<Member> beanHandler = new BeanHandler<>(Member.class);
    private final BeanListHandler<Member> beanListHandler = new BeanListHandler<>(Member.class);

    /**
     * 新增一个会员
     *
     * @param member 要新增的会员对象
     * @return 新增结果
     */
    @Override
    public boolean save(Member member) {
        String sql = "insert into member(mobile,pwd,real_name,nick_name,email,"
                + "gender,register_time) values(?,?,?,?,?,?,?)";

        Object[] params = {member.getMobile(), member.getPwd(),
                member.getReal_name(), member.getNick_name(), member.getEmail(),
                member.isGender(), member.getRegister_time()
        };

        Connection conn = null;
        try {
            conn = DbHelper.getConn(); //获取连接
            conn.setAutoCommit(false); //启动事务

            //执行数据库的插入操作，返回生成的主键值

            BigInteger temp = qr.insert(conn, sql, scalarHandler, params);
            if (temp != null) {
                member.setId(temp.intValue());
            }

            DbUtils.commitAndCloseQuietly(conn); //提交事务并关闭连接
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);//回滚事务并关闭连接

            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 根据ID删除该会员
     *
     * @param id 会员的ID
     */
    @Override
    public boolean remove(Integer id) {
        String sql = "delete from member where id=?";

        Connection conn = null;
        try {
            conn = DbHelper.getConn();
            conn.setAutoCommit(false);

            qr.update(conn, sql, id);

            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);

            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 更新会员的详细信息
     *
     * @param member 要更新的会员对象
     */
    @Override
    public boolean update(Member member) {
        String sql = "update member  set mobile=?,pwd=?,real_name=?,nick_name=?,"
                + "email=?,gender=?,register_time=? where id=?";

        Object[] params = {member.getMobile(), member.getPwd(),
                member.getReal_name(), member.getNick_name(), member.getEmail(),
                member.isGender(), member.getRegister_time(), member.getId()
        };

        Connection conn = null;
        try {
            conn = DbHelper.getConn(); //获取连接
            conn.setAutoCommit(false); //启动事务

            qr.update(conn, sql, params);

            DbUtils.commitAndCloseQuietly(conn); //提交事务并关闭连接
        } catch (SQLException e) {

            DbUtils.rollbackAndCloseQuietly(conn);//回滚事务并关闭连接

            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据ID获取该会员对象
     *
     * @param id 会员对象的ID
     * @return 返回指定编号的会员对象
     */
    @Override
    public Member findByID(Integer id) {
        Member member = null;

        //id,mobile,pwd,real_name,nick_name,email,gender,register_time
        String sql = "select * from member where id=?";

        Connection conn = null;
        try {
            conn = DbHelper.getConn(); //获取连接

            member = qr.query(conn, sql, beanHandler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return member;
    }

    /**
     * 根据手机号获取该会员对象
     *
     * @param mobile
     * @return
     */
    @Override
    public Member findByMobile(String mobile) {
        Member member = null;

        String sql = "select * from member where mobile=?";

        Connection conn = null;
        try {
            conn = DbHelper.getConn(); //获取连接

            member = qr.query(conn, sql, beanHandler, mobile);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return member;
    }


    /**
     * 获取所有会员的列表
     *
     * @return 会员列表对象
     */
    @Override
    public List<Member> findAll() {
        List<Member> list = new ArrayList<Member>();

        String sql = "select * from member";

        Connection conn = null;
        try {
            conn = DbHelper.getConn();

            list = qr.query(conn, sql, beanListHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }

        return list;
    }


    /**
     * 统计会员总数量
     *
     * @return
     */
    @Override
    public long getCount() {
        long count = 0;

        String sql = "select count(id) from member";

        Connection conn = null;
        try {
            conn = DbHelper.getConn();
            final ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
            Long temp = qr.query(conn, sql, scalarHandler);
            if (temp != null) {
                count = temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }

        return count;
    }

    /**
     * @param number 页号
     * @param size   每页的记录数
     */
    @Override
    public Page<Member> findByPager(int number, int size) {
        Page<Member> page = new Page<>(number, size);

        long totalElements = getCount();
        if (totalElements > 0) {
            page.setTotalElements(totalElements);

            String sql = "select * from member limit ?,?";
            Object[] params = {(number - 1) * size, size};

            Connection conn = null;
            try {
                conn = DbHelper.getConn();

                List<Member> list = qr.query(conn, sql, beanListHandler, params);

                page.setItems(list);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(conn);
            }
        }

        return page;
    }
}