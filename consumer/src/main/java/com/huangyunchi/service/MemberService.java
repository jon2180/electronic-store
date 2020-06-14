package com.huangyunchi.service;

import com.huangyunchi.dao.MemberDAO;
import com.huangyunchi.dao.impl.MemberDAOImpl;
import com.huangyunchi.entity.Member;
import com.huangyunchi.entity.common.Page;

import java.util.List;

/**
 * 会员相关的业务逻辑类---->CRUD操作
 *
 * @author Administrator
 */
public class MemberService {

    private final MemberDAO memberDAO = new MemberDAOImpl();

    /**
     * 新增一个会员
     *
     * @param member 要新增的会员对象
     * @return 新增成功后的会员对象
     */
    public Member save(Member member) {
        memberDAO.save(member);
        return member;
    }

    /**
     * 根据ID删除该会员
     *
     * @param id 会员的ID
     */
    public void delete(Integer id) {
        memberDAO.remove(id);
    }

    /**
     * 更新会员的详细信息
     *
     * @param member 要更新的会员对象
     */
    public void update(Member member) {
        memberDAO.update(member);
    }

    /**
     * 根据ID获取该会员对象
     *
     * @param id 会员对象的ID
     * @return 返回指定编号的会员对象
     */
    public Member findOne(Integer id) {
        return memberDAO.findByID(id);
    }

    /**
     * 根据手机号获取该会员对象
     *
     * @param mobile
     * @return
     */
    public Member findByMobile(String mobile) {
        return memberDAO.findByMobile(mobile);
    }


    /**
     * 获取所有会员的列表
     *
     * @return 会员列表对象
     */
    public List<Member> findAll() {
        return memberDAO.findAll();
    }


    /**
     * 统计会员总数量
     *
     * @return
     */
    public long count() {
        return memberDAO.getCount();
    }

    /**
     * @param number 页号
     * @param size   每页的记录数
     */
    public Page<Member> findByPager(int number, int size) {
        return memberDAO.findByPager(number, size);
    }
}
