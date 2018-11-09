package com.wampinfotech.wampinfotech.modals;

public class Visitor {
    private int vid;
    private String ipAddr;
    private String time;

    public Visitor(int vid, String ipAddr, String time) {
        this.vid = vid;
        this.ipAddr = ipAddr;
        this.time = time;
    }

    public int getVid() {
        return vid;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getTime() {
        return time;
    }
}
