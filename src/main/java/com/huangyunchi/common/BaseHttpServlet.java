package com.huangyunchi.common;

import com.huangyunchi.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseHttpServlet extends HttpServlet {

    protected final String baseUrl = "/WEB-INF/views";

    protected void dispatchToPrivateView(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(baseUrl + url).forward(request, response);
    }

    protected void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(url);
    }

    protected <T> void json(HttpServletResponse resp, int code, String desc, T dto) throws IOException {
        resp.setHeader("Content-Type", "application/json;charset=UTF-8");
        resp.getWriter().println(JsonUtil.getJson(code, desc, dto));
    }

    protected void html(HttpServletResponse resp, String htmlStr) throws IOException {
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.getWriter().println(htmlStr);
    }
}
