package com.huangyunchi.dao;

import com.huangyunchi.entity.Member;
import com.huangyunchi.entity.common.Page;

import java.util.List;

public interface MemberDAO {

    boolean save(Member member);

    boolean remove(Integer id);

    boolean update(Member member);

    Member findByID(Integer id);

    Member findByMobile(String mobile);

    List<Member> findAll();

    long getCount();

    Page<Member> findByPager(int number, int size);

}
