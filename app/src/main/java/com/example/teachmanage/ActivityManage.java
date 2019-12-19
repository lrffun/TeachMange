package com.example.teachmanage;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityManage {           //活动管理类
    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void delateActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAllActivity(){
        for (Activity activity:activities){
            activity.finish();
        }
    }
}
