package com.wampinfotech.wampinfotech.modals;

public class ServiceCard {
    private String _Title;
    private int _Icon;

    public ServiceCard(String title, int icon) {
        this._Title = title;
        this._Icon = icon;
    }

    public String getTitle() {
        return _Title;
    }

    public void setTitle(String _Title) {
        this._Title = _Title;
    }

    public int getIcon() {
        return _Icon;
    }

    public void setIcon(int _Icon) {
        this._Icon = _Icon;
    }
}