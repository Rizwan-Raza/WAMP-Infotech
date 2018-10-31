package com.wampinfotech.wampinfotech.modals;

import java.net.URL;

public class ClientAuth {
    private URL authUrl;
    private String method;
    private String username;
    private String password;

    public ClientAuth() {
    }

    public ClientAuth(URL authUrl, String method, String username, String password) {
        this.authUrl = authUrl;
        this.method = method;
        this.username = username;
        this.password = password;
    }

    public URL getAuthUrl() {
        return authUrl;
    }

    public String getMethod() {
        return method;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
