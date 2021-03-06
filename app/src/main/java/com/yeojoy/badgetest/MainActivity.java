package com.yeojoy.badgetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View view) {
        Intent intent;
        
        Log.d(TAG, "Package Name : " + getComponentName().getPackageName());
        Log.d(TAG, "Class Name : " + getComponentName().getClassName());

        switch (view.getId()) {
            case R.id.btn_send_badge:
                intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                // 패키지 네임과 클래스 네임 설정
                intent.putExtra("badge_count_package_name", getComponentName().getPackageName());
                intent.putExtra("badge_count_class_name", getComponentName().getClassName());
                // 업데이트 카운트
                Log.d(TAG, "MAX_VALUE : " + Integer.MAX_VALUE);
                intent.putExtra("badge_count", Integer.MAX_VALUE);
                sendBroadcast(intent);
                
                break;
            
            case R.id.btn_update_badge:

                intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                // 패키지 네임과 클래스 네임 설정
                intent.putExtra("badge_count_package_name", getComponentName().getPackageName());
                intent.putExtra("badge_count_class_name", getComponentName().getClassName());
                
                // 업데이트 카운트
                intent.putExtra("badge_count", 1.0);
                sendBroadcast(intent);
                
                break;
            
            case R.id.btn_clear_badge:

                intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                // 패키지 네임과 클래스 네임 설정
                intent.putExtra("badge_count_package_name", getComponentName().getPackageName());
                intent.putExtra("badge_count_class_name", getComponentName().getClassName());
                // 업데이트 카운트
                intent.putExtra("badge_count", 0);
                sendBroadcast(intent);
                
                break;
            
            case R.id.btn_goto_second_activity:
                
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                
                break;
                
        }
        
    }
}
