package com.huangyunchi.vendor.web.servlet.memeber;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.util.Validator;
import com.huangyunchi.vendor.web.KeyConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/sign-in")
public class MemberSignInServlet extends BaseHttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // read the parameters
        String mobile = req.getParameter("mobile");          // mobile phone number
        String rawPassword = req.getParameter("password");   // password
        String captcha = req.getParameter("captcha");        // verification code

        if (mobile == null || rawPassword == null || captcha == null) {
            // empty parameters
            // TODO
            return;
        }

        if (!captcha.toLowerCase().equals(req.getSession().getAttribute(KeyConfig.captchaName).toString().toLowerCase())) {
            // wrong captcha
            // TODO
            return;
        }

        if (!Validator.mobilePhone(mobile) || !Validator.checkPwd(rawPassword)) {
            // invalid mobile or password
            // TODO
            return;
        }

        // check password
        // TODO
        System.out.println("test");
    }
}
