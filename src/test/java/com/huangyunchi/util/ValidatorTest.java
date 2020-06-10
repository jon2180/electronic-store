package com.huangyunchi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void testCheckUser() {
        String name = "usernamae";
        assertTrue(Validator.checkName(name));
    }

    @Test
    public void testCheckMobile() {
        String mobile = "1231456";
        assertFalse(Validator.mobilePhone(mobile));
        assertTrue(Validator.mobilePhone("13344445555"));
        assertFalse(Validator.mobilePhone("12344445555"));
        assertFalse(Validator.mobilePhone("1,344445555"));
    }

    @Test
    public void testCheckPwd() {
        String pwd = "fafasdf";
        assertTrue(Validator.checkPwd(pwd));
        assertFalse(Validator.checkComplexPassword(pwd));
    }

}
