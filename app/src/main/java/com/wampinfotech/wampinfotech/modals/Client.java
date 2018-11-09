package com.wampinfotech.wampinfotech.modals;

import java.io.Serializable;

public class Client implements Serializable {
    private String authApiUrl;
    private String clientName;
    private String clientToken;
    private String projectName;
    private String projectUrl;
    private String queriesApiUrl;
    private String visitorsApiUrl;

    public Client() {
    }

    public Client(String authApiUrl, String clientName, String clientToken, String projectName, String projectUrl, String queriesApiUrl, String visitorsApiUrl) {
        this.authApiUrl = authApiUrl;
        this.clientName = clientName;
        this.clientToken = clientToken;
        this.projectName = projectName;
        this.projectUrl = projectUrl;
        this.queriesApiUrl = queriesApiUrl;
        this.visitorsApiUrl = visitorsApiUrl;
    }

    public String getAuthApiUrl() {
        return authApiUrl;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientToken() {
        return clientToken;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public String getQueriesApiUrl() {
        return queriesApiUrl;
    }

    public String getVisitorsApiUrl() {
        return visitorsApiUrl;
    }

    @Override
    public String toString() {
        return "Client{" +
                "authApiUrl='" + authApiUrl + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientToken='" + clientToken + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectUrl='" + projectUrl + '\'' +
                ", queriesApiUrl='" + queriesApiUrl + '\'' +
                ", visitorsApiUrl='" + visitorsApiUrl + '\'' +
                '}';
    }
}
