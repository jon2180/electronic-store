package com.huangyunchi.web.servlet;

import com.huangyunchi.common.BaseHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForgotPasswordServlet extends BaseHttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchToPrivateView("/reset_password.jsp", req, resp);
    }
}
