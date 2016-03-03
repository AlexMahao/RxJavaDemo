package com.example.mdw.rxjavademo.bean;

/**
 * Created by mdw on 2016/3/2.
 */
public class AppInfo implements Comparable<Object> {

    long mLastUpdateTime;

    String mName;

    String mIcon;


    public AppInfo(long mLastUpdateTime, String mName, String mIcon) {
        this.mLastUpdateTime = mLastUpdateTime;
        this.mName = mName;
        this.mIcon = mIcon;
    }


    @Override
    public int compareTo(Object another) {
        AppInfo f = (AppInfo) another;

        return getmName().compareTo(f.getmName());
    }

    public long getmLastUpdateTime() {
        return mLastUpdateTime;
    }

    public void setmLastUpdateTime(long mLastUpdateTime) {
        this.mLastUpdateTime = mLastUpdateTime;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }
}
