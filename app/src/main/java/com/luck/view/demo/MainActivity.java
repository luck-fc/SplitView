package com.luck.view.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.luck.view.splitview.SplitImageView;

/**
 * 作者：luck on 2016/10/27 19:29
 * 邮箱：fc_dream@163.com
 * app
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SplitImageView splitImageView = (SplitImageView) findViewById(R.id.splitImageView);
        splitImageView.setOnXYClickListener(new SplitImageView.onSplitClickListener() {
            @Override
            public void onSplitClick(View v, int position) {
                show("点到了第" + (position + 1) + "个区域");
            }
        });
    }

    private Toast mToast;
    private void show(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
