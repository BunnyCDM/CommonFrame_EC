package com.example.latte.delegates.web.event;

import com.example.latte.util.log.LatteLogger;

/**
 * Created by mac on 2017/9/16.
 */

public class UndefineEvent extends Event {

    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent", params);
        return null;
    }

}