package com.wampinfotech.wampinfotech.modals;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Client implements Serializable {
    private String clientToken;
    private String clientName;
    private String projectName;
    private String projectUrl;
    private String projectVisitors;

    public Client() {
    }

    public Client(String clientToken, String clientName, String projectName, String projectUrl, String projectVisitors) {
        this.clientToken = clientToken;
        this.clientName = clientName;
        this.projectName = projectName;
        this.projectUrl = projectUrl;
        this.projectVisitors = projectVisitors;
    }

    public String getClientToken() {
        return clientToken;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public String getProjectVisitors() {
        return projectVisitors;
    }

    @NonNull
    @Override
    public String toString() {
        return getClientToken() + "-" + getClientName() + "-" + getProjectName() + "-" + getProjectUrl() + "-" + getProjectVisitors();
    }
}
