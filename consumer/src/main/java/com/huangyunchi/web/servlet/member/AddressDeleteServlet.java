package com.huangyunchi.web.servlet.member;

import com.huangyunchi.service.AddressService;
import com.huangyunchi.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会员的地址删除功能
 */
@WebServlet("/member/address/delete")
public class AddressDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String id = request.getParameter("id");

        //
        AddressService service = ServiceFactory.getAddressService();
        service.delete(Integer.parseInt(id));

        //
        response.sendRedirect(request.getContextPath() + "/member/address/list");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
