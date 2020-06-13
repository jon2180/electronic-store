package com.huangyunchi.web.servlet.member;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.entity.Address;
import com.huangyunchi.entity.Member;
import com.huangyunchi.service.AddressService;
import com.huangyunchi.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 会员的地址列表
 */
@WebServlet("/member/address/list")
public class AddressListServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        Member mbr = (Member) request.getSession().getAttribute("curr_mbr");


        //
        AddressService service = ServiceFactory.getAddressService();
        List<Address> list = service.findByMember(mbr.getId());

        //
        request.setAttribute("list", list);

        dispatchToPrivateView("/member/address.jsp", request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
