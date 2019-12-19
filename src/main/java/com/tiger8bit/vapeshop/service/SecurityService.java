package com.tiger8bit.vapeshop.service;
public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}