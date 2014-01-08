package com.huibinfeng0810.Sample;

import android.app.Activity;

/**
 * User: fenghb
 * Date: 14-1-8
 * Time: 下午1:27
 */
public class ActivityInfo {
    public Class<? extends Activity> class_;
    public int titleResourceId;

    public ActivityInfo(Class<? extends Activity> class_, int titleResourceId) {
        this.class_ = class_;
        this.titleResourceId = titleResourceId;
    }
}
