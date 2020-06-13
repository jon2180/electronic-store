package com.huangyunchi.web.servlet.member;

import com.huangyunchi.common.BaseHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/update_pwd")
public class UpdatePassword extends BaseHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchToPrivateView("/member/updatepwd.jsp", req, resp);
    }
}
