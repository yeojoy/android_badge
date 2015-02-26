package com.yeojoy.badgetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;


public class SecondActivity extends ActionBarActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    
    public void onClick(View view) {
        Intent intent;
        
        Log.d(TAG, "Package Name : " + getComponentName().getPackageName());
        Log.d(TAG, "Class Name : " + getComponentName().getClassName());
        Log.d(TAG, "Main Canonical Name : " + MainActivity.class.getSimpleName());

        String className = MainActivity.class.getSimpleName();
        
        switch (view.getId()) {
            case R.id.btn_send_badge:
                intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                // 패키지 네임과 클래스 네임 설정
                intent.putExtra("badge_count_package_name", getComponentName().getPackageName());
                intent.putExtra("badge_count_class_name", className);
                // 업데이트 카운트
                intent.putExtra("badge_count", 1);
                sendBroadcast(intent);
                
                break;
            
            case R.id.btn_update_badge:

                intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                // 패키지 네임과 클래스 네임 설정
                intent.putExtra("badge_count_package_name", getComponentName().getPackageName());
                intent.putExtra("badge_count_class_name", className);
                // 업데이트 카운트
                intent.putExtra("badge_count", 999999);
                sendBroadcast(intent);
                
                break;
            
            case R.id.btn_clear_badge:

                intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                // 패키지 네임과 클래스 네임 설정
                intent.putExtra("badge_count_package_name", getComponentName().getPackageName());
                intent.putExtra("badge_count_class_name", className);
                // 업데이트 카운트
                intent.putExtra("badge_count", 0);
                sendBroadcast(intent);
                
                break;
                
        }
        
    }
}
