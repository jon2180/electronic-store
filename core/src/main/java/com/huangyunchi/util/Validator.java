package com.huangyunchi.util;

public class Validator {
    /**
     * 用户名验证
     *
     * @param name
     * @return
     */
    public static boolean checkName(String name) {
        String regExp = "^[^0-9][\\w_]{5,9}$";
        return name.matches(regExp);
    }

    public static boolean mobilePhone(String tel) {
        return tel.matches("^[1][3456789][0-9]{9}$");
    }

    /**
     * 密码验证
     *
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        String regExp = "^[\\w_]{6,20}$";
        return pwd.matches(regExp);
    }

    public static boolean checkComplexPassword(String pwd) {
        return pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*?[#?!@$%^&*-]).{6,}$");
    }
}
