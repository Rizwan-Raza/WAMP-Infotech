package com.wampinfotech.wampinfotech.modals;

public class Client {
    private String clientToken;
    private String clientOwner;
    private String projectName;
    private String projectUrl;
    private String projectVisitors;

    public Client() {
    }

    public Client(String clientToken, String clientOwner, String projectName, String projectUrl, String projectVisitors) {
        this.clientToken = clientToken;
        this.clientOwner = clientOwner;
        this.projectName = projectName;
        this.projectUrl = projectUrl;
        this.projectVisitors = projectVisitors;
    }

    public String getClientToken() {
        return clientToken;
    }

    public String getClientOwner() {
        return clientOwner;
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
}
