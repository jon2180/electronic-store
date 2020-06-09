package com.huangyunchi.service;

import com.huangyunchi.entity.Member;
import com.huangyunchi.entity.common.Page;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class MemberServiceTest {

    @Test
    public void testDelete() {
        MemberService service = new MemberService();

        service.delete(2);
    }

    @Test
    public void testUpdate() {
        MemberService service = new MemberService();

        Member mbr = service.findOne(Integer.valueOf(1));
        mbr.setMobile("0000");

        service.update(mbr);
    }

    @Test
    public void testFindByPage() {
        MemberService service = new MemberService();

        Page<Member> page = service.findByPager(1, 10);

        System.out.println(page);
    }

    @Test
    public void testFindAll() {
        MemberService service = new MemberService();

        List<Member> list = service.findAll();

        for (Member member : list) {
            System.out.println(member);
        }
    }

    @Test
    public void testFindByMobile() {
        MemberService service = new MemberService();

        Member mbr = service.findByMobile("11111");

        System.out.println(mbr);
    }

    @Test
    public void testFindOne() {
        MemberService service = new MemberService();

        Member mbr = service.findOne(Integer.valueOf(1));

        System.out.println(mbr);
    }

    @Test
    public void testSave() {
//        Member mbr = new Member();
//        mbr.setMobile("119");
//        mbr.setPwd("119");
//        mbr.setReal_name("火哥");
//        mbr.setNick_name("火火火");
//        mbr.setGender(true);
//        mbr.setEmail("119@119.com");
//        mbr.setRegister_time(new Date());
//
//
//        MemberService service = new MemberService();
//        Member newMbr = service.save(mbr);
//
//        System.out.println(newMbr);
    }
}
