package com.huangyunchi.service;

import com.huangyunchi.entity.Member;
import com.huangyunchi.entity.common.Page;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class MemberServiceTest {

    @Test
    public void testDelete() {
        MemberService service = ServiceFactory.getMemberService();
        service.delete(2);
    }

    @Test
    public void testUpdate() {
        MemberService service = ServiceFactory.getMemberService();
        Member mbr = service.findOne(Integer.valueOf(1));
        mbr.setMobile("0000");
        service.update(mbr);
    }

    @Test
    public void testFindByPage() {
        MemberService service = ServiceFactory.getMemberService();
        Page<Member> page = service.findByPager(1, 10);
        System.out.println(page);
    }

    @Test
    public void testFindAll() {
        MemberService service = ServiceFactory.getMemberService();
        List<Member> list = service.findAll();
        for (Member member : list) {
            System.out.println(member);
        }
    }

    @Test
    public void testFindByMobile() {
        MemberService service = ServiceFactory.getMemberService();
        Member mbr = service.findByMobile("11111");
        System.out.println(mbr);
    }

    @Test
    public void testFindOne() {
        MemberService service = ServiceFactory.getMemberService();
        Member mbr = service.findOne(Integer.valueOf(1));
        System.out.println(mbr);
    }

//    @Test
    public void testSave() {
        Member member = mock(Member.class);
        MemberService service = ServiceFactory.getMemberService();
        Member newMbr = service.save(member);
        assertNotNull(newMbr);
    }
}
