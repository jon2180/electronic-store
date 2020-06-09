package com.huangyunchi.util;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void testCheckUser(String[] args) {
        String name = "usernamae";
        Validator.checkName(name);
    }

    @Test
    public void testCheckPwd() {
        String pwd = "fafasdf";
        Validator.checkPwd(pwd);
    }

}
