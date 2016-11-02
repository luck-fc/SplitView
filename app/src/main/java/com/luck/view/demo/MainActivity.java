package com.luck.view.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.luck.view.splitview.FRect;
import com.luck.view.splitview.Split;
import com.luck.view.splitview.SplitImageView;
import com.luck.view.splitview.SplitView;

import java.util.ArrayList;
import java.util.List;

import static com.luck.view.demo.R.id.splitImageView1;

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
        SplitView splitView1 = (SplitView) findViewById(splitImageView1);
        splitView1.setOnSplitClickListener(new Split.onSplitClickListener() {
            @Override
            public void onSplitClick(View v, int position) {
                show("点到了2*2SplitView的第" + (position + 1) + "个区域");
            }
        });
        SplitImageView splitImageView2 = (SplitImageView) findViewById(R.id.splitImageView2);
        splitImageView2.setOnSplitClickListener(new Split.onSplitClickListener() {
            @Override
            public void onSplitClick(View v, int position) {
                show("点到了3*2SplitImageView的第" + (position + 1) + "个区域");
            }
        });
        SplitImageView splitImageView3 = (SplitImageView) findViewById(R.id.splitImageView3);
        splitImageView3.setOnSplitClickListener(new Split.onSplitClickListener() {
            @Override
            public void onSplitClick(View v, int position) {
                show("点到了3*3SplitImageView的第" + (position + 1) + "个区域");
            }
        });
        SplitImageView splitImageView4 = (SplitImageView) findViewById(R.id.splitImageView4);
        splitImageView4.setOtherStyle(three_Three());
        splitImageView4.setOnSplitClickListener(new Split.onSplitClickListener() {
            @Override
            public void onSplitClick(View v, int position) {
                show("点到了自定义SplitImageView的第" + (position + 1) + "个区域");
            }
        });
    }

    private List<FRect> three_Three(){
        float f0_0= 0.0f;
        float f1_2= 1.0f/2;
        float f1_4= 1.0f/4;
        float f3_8= 3.0f/8;
        float f1_8= 1.0f/8;
        float f1_0= 1.0f;
        List<FRect> mFRects = new ArrayList<>();
        mFRects.add(new FRect(f0_0,f0_0,f1_8,f1_8));
        mFRects.add(new FRect(f1_8,f0_0,f1_2,f3_8));
        mFRects.add(new FRect(f1_2,f0_0,f1_0,f1_2));
        mFRects.add(new FRect(f0_0,f1_8,f1_8,f1_4));
        mFRects.add(new FRect(f0_0,f1_4,f1_8,f3_8));
        mFRects.add(new FRect(f0_0,f3_8,f3_8,f1_2));
        mFRects.add(new FRect(f3_8,f3_8,f1_2,f1_2));
        mFRects.add(new FRect(f0_0,f1_2,f1_2,f1_0));
        mFRects.add(new FRect(f1_2,f1_2,f1_0,f1_0));
        return mFRects;
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
