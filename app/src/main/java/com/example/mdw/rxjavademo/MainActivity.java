package com.example.mdw.rxjavademo;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.example.mdw.rxjavademo.bean.AppInfo;
import com.example.mdw.rxjavademo.bean.AppInfoRich;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity {

    String mFilesDir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFilesDir = Environment.getExternalStorageDirectory().getAbsolutePath();

    }


    private Observable<AppInfo> getApps() {
        return Observable.create(new Observable.OnSubscribe<AppInfo>() {
            @Override
            public void call(Subscriber<? super AppInfo> subscriber) {
                List<AppInfoRich> apps = new ArrayList<AppInfoRich>();
                final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> infos = getPackageManager().queryIntentActivities(mainIntent,0);

                for(ResolveInfo info : infos){
                    apps.add(new AppInfoRich(MainActivity.this,info));
                }

                for(AppInfoRich appInfo : apps){
                    Bitmap icon = Utils.drawableToBitmap(appInfo.getIcon());
                    String name = appInfo.getName();

                    String iconPath = mFilesDir +"/"+name;

                    Utils.storeBitmap(MainActivity.this,icon,name);

                    if(subscriber.isUnsubscribed()){
                        return;
                    }

                    subscriber.onNext(new AppInfo(appInfo.getLastUpdateTime(),name,iconPath));

                    if(!subscriber.isUnsubscribed()){
                        subscriber.onCompleted();
                    }
                }
            }
        });
    }


}
