package com.jianmi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.pingplusplus.android.Pingpp;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 2016/12/7
 * @time 下午1:50
 */

public class PingppActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    String charge = getIntent().getStringExtra("charge");
    String qqId = getIntent().getStringExtra("qqId");
    Pingpp.createPayment(this, charge, qqId);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    PingppModule.mResultCallback.invoke(data.getStringExtra("pay_result"));
    finish();
  }
}
