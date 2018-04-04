package com.example.mac.commonframe_ec.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alibaba.fastjson.JSONObject;
import com.example.latte.util.log.LatteLogger;

import java.util.Set;

/**
 * Created by mac on 2017/10/8.
 */

public class PushReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle=intent.getExtras();
        final Set<String> keys=bundle.keySet();
        final JSONObject json=new JSONObject();
        for (String key:keys) {
            final  Object val=bundle.get(key);
            json.put(key,val);
        }

        LatteLogger.json("PushReceiver",json.toJSONString());

        final String pushAbction=intent.getAction();

        if(pushAbction.equals("")){
            onReceivedMessage(bundle);

        }else if(pushAbction.equals("")){
            onOpenNotification(context,bundle);
        }

    }


    private void onReceivedMessage(Bundle bundle){

    }

    private void onOpenNotification(Context context,Bundle bundle){

    }



}
