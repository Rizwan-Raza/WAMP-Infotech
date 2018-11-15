package com.wampinfotech.wampinfotech.modals;

import java.io.Serializable;
import java.util.Date;

public class Query implements Serializable {
    private int qid;
    private String name;
    private String number;
    private String email;
    private String msg;
    private Date time;

    public Query(int qid, String name, String number, String email, String msg, Date time) {
        this.qid = qid;
        this.name = name;
        this.number = number;
        this.email = email;
        this.msg = msg;
        this.time = time;
    }

    public Query() {

    }

    public int getQid() {
        return qid;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getMsg() {
        return msg;
    }

    public Date getTime() {
        return time;
    }
}
