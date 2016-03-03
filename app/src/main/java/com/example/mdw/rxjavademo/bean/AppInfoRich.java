package com.example.mdw.rxjavademo.bean;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by mdw on 2016/3/3.
 */
public class AppInfoRich implements Comparable<Object> {

    String mName = null;

    private Context mContext;


    private ResolveInfo mResolveInfo;


    //包含指定的试图信息，配合intent的使用
    private ComponentName mComponentName = null;


    private PackageInfo pi = null;

    private Drawable icon = null;


    public AppInfoRich(Context ctx, ResolveInfo ri) {
        mContext = ctx;
        mResolveInfo = ri;

        mComponentName = new ComponentName(ri.activityInfo.applicationInfo.packageName, ri.activityInfo.name);

        try {
            pi = ctx.getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }
    }


    public String getActivityName() {
        return mResolveInfo.activityInfo.name;
    }

    public String getPackageName() {

        return mResolveInfo.activityInfo.packageName;
    }


    public ComponentName getComponentName() {

        return mComponentName;
    }

    public String getComponentInfo() {
        if (getComponentName() != null) {
            return getComponentInfo().toString();
        } else {
            return "";
        }
    }


    public ResolveInfo getResolveInfo() {

        return mResolveInfo;

    }

    public PackageInfo getPackageInfo() {

        return pi;
    }

    public int getVersionCode() {
        PackageInfo pi = getPackageInfo();

        if (pi != null) {
            return pi.versionCode;
        } else {
            return 0;
        }

    }

    public Drawable getIcon() {
        if (icon == null) {
            icon = getResolveInfo().loadIcon(mContext.getPackageManager());
        }

        return icon;
    }


    public long getFirstInstallTime() {
        PackageInfo pi = getPackageInfo();

        if (pi != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return pi.firstInstallTime;
        } else {
            return 0;
        }
    }


    public long getLastUpdateTime() {
        PackageInfo pi = getPackageInfo();
        if (pi != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return pi.lastUpdateTime;
        } else {
            return 0;
        }
    }


    public String getVersionName() {
        PackageInfo pi = getPackageInfo();
        if (pi != null) {
            return pi.versionName;

        } else {
            return "";
        }
    }

    public String getName() {
        if (mName != null) {
            return mName;
        } else {
            return getNameFromResolveInfo(mResolveInfo);
        }
    }

    private String getNameFromResolveInfo(ResolveInfo ri) {

        String name = ri.resolvePackageName;

        if (ri.activityInfo != null) {
            try {
                Resources res = mContext.getPackageManager().getResourcesForApplication(ri.activityInfo.applicationInfo);
                Resources engRes = getEnglishRessources(res);

                if (ri.activityInfo.labelRes != 0) {
                    name = engRes.getString(ri.activityInfo.labelRes);

                    if (name == null || name.equals("")) {
                        name = res.getString(ri.activityInfo.labelRes);
                    }
                } else {
                    name = ri.activityInfo.applicationInfo.loadLabel(mContext.getPackageManager()).toString();
                }

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    private Resources getEnglishRessources(Resources standardResources) {
        AssetManager assets = standardResources.getAssets();
        DisplayMetrics metrics = standardResources.getDisplayMetrics();
        Configuration config = new Configuration(standardResources.getConfiguration());
        config.locale = Locale.US;

        return new Resources(assets, metrics, config);
    }


    @Override
    public int compareTo(Object another) {
        AppInfoRich f = (AppInfoRich) another;

        return getName().compareTo(f.getName());
    }


}
