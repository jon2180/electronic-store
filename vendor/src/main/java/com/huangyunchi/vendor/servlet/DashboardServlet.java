package com.huangyunchi.vendor.servlet;

import com.huangyunchi.common.BaseHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends BaseHttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String tab = req.getParameter("tab");
//        if (tab == null || tab.equals("home")) {
//            index(req, resp);
//            return;
//        }
        dispatchToPrivateView("/dashboard.jsp", req, resp);
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) {

    }
}
