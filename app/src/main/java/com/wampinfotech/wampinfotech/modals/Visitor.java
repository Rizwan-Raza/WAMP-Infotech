package com.wampinfotech.wampinfotech.modals;

import java.util.Date;

public class Visitor {
    private int vid;
    private String ipAddr;
    private Date time;

    public Visitor(int vid, String ipAddr, Date time) {
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

    public Date getTime() {
        return time;
    }
}
