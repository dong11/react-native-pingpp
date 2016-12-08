package com.jianmi;

import android.content.Intent;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/12/6
 * @time 下午9:41
 */

public class PingppModule extends ReactContextBaseJavaModule {

  public static Callback mResultCallback;

  public PingppModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override public String getName() {
    return "PingppModule";
  }
  
  @ReactMethod
  public void createPayment(String charge, String qqId, Callback resultCallback) {
    mResultCallback = resultCallback;
    Intent intent = new Intent(getCurrentActivity(), PingppActivity.class);
    intent.putExtra("charge", charge);
    intent.putExtra("qqId", qqId);
    getCurrentActivity().startActivity(intent);
  }
}
