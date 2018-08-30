package com.example.service;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class IntegralOrderServiceTest {

    @Autowired
    StringEncryptor stringEncryptor;
    @Test
    public void add() {
        String result = stringEncryptor.encrypt("123456");
        System.out.println(result);
    }
}