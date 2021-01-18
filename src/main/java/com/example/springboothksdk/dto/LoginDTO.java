package com.example.springboothksdk.dto;


public class LoginDTO {

    String m_sDeviceIP;

    String m_sUsername;

    String m_sPassword;

    Short wPort;

    Integer bUseAsynLogin; //是否异步登录

    public String getM_sDeviceIP() {
        return m_sDeviceIP;
    }

    public void setM_sDeviceIP(String m_sDeviceIP) {
        this.m_sDeviceIP = m_sDeviceIP;
    }

    public String getM_sUsername() {
        return m_sUsername;
    }

    public void setM_sUsername(String m_sUsername) {
        this.m_sUsername = m_sUsername;
    }

    public String getM_sPassword() {
        return m_sPassword;
    }

    public void setM_sPassword(String m_sPassword) {
        this.m_sPassword = m_sPassword;
    }

    public Short getwPort() {
        return wPort;
    }

    public void setwPort(Short wPort) {
        this.wPort = wPort;
    }

    public Integer getbUseAsynLogin() {
        return bUseAsynLogin;
    }

    public void setbUseAsynLogin(Integer bUseAsynLogin) {
        this.bUseAsynLogin = bUseAsynLogin;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "m_sDeviceIP='" + m_sDeviceIP + '\'' +
                ", m_sUsername='" + m_sUsername + '\'' +
                ", m_sPassword='" + m_sPassword + '\'' +
                ", wPort=" + wPort +
                ", bUseAsynLogin=" + bUseAsynLogin +
                '}';
    }
}
