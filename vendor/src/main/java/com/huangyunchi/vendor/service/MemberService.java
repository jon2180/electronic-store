package com.huangyunchi.vendor.service;

import com.huangyunchi.dao.MemberDAO;
import com.huangyunchi.dao.impl.MemberDAOImpl;
import com.huangyunchi.entity.Member;

public class MemberService {

    private final MemberDAO memberDAO = new MemberDAOImpl();

    public boolean register(String mobile, String password) {

        Member member = memberDAO.findByMobile(mobile);

        if (member == null) {
            return false;
        }

        if (!password.equals(member.getPwd())) {
            return false;
        }

        return true;
    }

}
