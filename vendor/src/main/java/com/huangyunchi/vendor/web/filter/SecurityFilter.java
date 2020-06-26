package com.huangyunchi.vendor.web.filter;

import com.huangyunchi.entity.Member;
import com.huangyunchi.vendor.web.KeyConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 对会员的操作进行安全验证的过滤器
 *
 * @author Administrator
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        Member mbr = (Member) session.getAttribute(KeyConfig.memberName);
        if (mbr != null || checkInAllowList(request)) { //登录后的会员发起的请求，通过
            chain.doFilter(request, res);
        } else { //未登录的会员发起的请求，要阻止
            session.setAttribute("msg", "会员的相关操作，需要登录！");
            response.sendRedirect(request.getContextPath() + "/signin.jsp");
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    private boolean checkInAllowList(HttpServletRequest req) {
        final String[] allowList = {
                "/member/sign-in", "/member/sign-on", "/signin.jsp", "/signon.jsp",
        };

        System.out.println(req.getContextPath());
        System.out.println(req.getRequestURL());

        for (String str : allowList) {
            if (str.equals(req.getContextPath() + req.getRequestURL().toString())) {
                return true;
            }
        }

        return false;
    }
}
