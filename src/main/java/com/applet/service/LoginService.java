package com.applet.service;

import com.applet.utils.result.Result;

public interface LoginService {
    Result login(String username, String password);
}
