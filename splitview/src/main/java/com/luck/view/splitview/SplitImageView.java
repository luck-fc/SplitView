package com.luck.view.splitview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：luck on 2016/10/27 19:29
 * 邮箱：fc_dream@163.com
 * spliteview
 */
public class SplitImageView extends ImageView {

    public final static int STYLE_2_2 = 1;
    public final static int STYLE_3_2 = 2;
    public final static int STYLE_3_3 = 3;
    public final static int STYLE_Other = 4;

    private int check_STYLE = 1;
    private int position = -1;
    private int width = -1, height = -1;
    private List<Rect> mRects = new ArrayList<>();
    private List<FRect> mFRects;
    private Rect mRect;
    private float mTouchX;
    private float mTouchY;
    private onSplitClickListener mOnSplitClickListener;

    public SplitImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public SplitImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SplitImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SplitImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int w = getWidth();
        int h = getHeight();
        if (width != w || height != h) {
            width = w;
            height = h;
            initView();
            setStyle(check_STYLE);
        }
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setClickable(true);
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.SplitImageView,
                    defStyleAttr,
                    0);
            check_STYLE = ta.getInt(R.styleable.SplitImageView_style, 1);
            ta.recycle();
        }
    }

    public void initValues() {
        this.position = -1;
        this.mRect = null;
        this.check_STYLE = 1;
    }

    private void two_Two() {

        Rect myRect1 = new Rect(0, 0, width * 1 / 2, height * 1 / 2);
        Rect myRect2 = new Rect(width * 1 / 2, 0, width, height * 1 / 2);

        Rect myRect3 = new Rect(0, height * 1 / 2, width * 1 / 2, height);
        Rect myRect4 = new Rect(width * 1 / 2, height * 1 / 2, width, height);

        mRects.clear();
        mRects.add(myRect1);
        mRects.add(myRect2);
        mRects.add(myRect3);
        mRects.add(myRect4);
    }

    private void three_Two() {

        Rect myRect1 = new Rect(0, 0, width * 1 / 3, height * 1 / 2);
        Rect myRect2 = new Rect(width * 1 / 3, 0, width * 2 / 3, height * 1 / 2);
        Rect myRect3 = new Rect(width * 2 / 3, 0, width, height * 1 / 2);

        Rect myRect4 = new Rect(0, height * 1 / 2, width * 1 / 3, height);
        Rect myRect5 = new Rect(width * 1 / 3, height * 1 / 2, width * 2 / 3, height);
        Rect myRect6 = new Rect(width * 2 / 3, height * 1 / 2, width, height);

        mRects.clear();
        mRects.add(myRect1);
        mRects.add(myRect2);
        mRects.add(myRect3);
        mRects.add(myRect4);
        mRects.add(myRect5);
        mRects.add(myRect6);
    }

    private void three_Three() {

        Rect myRect1 = new Rect(0, 0, width * 1 / 3, height * 1 / 3);
        Rect myRect2 = new Rect(width * 1 / 3, 0, width * 2 / 3, height * 1 / 3);
        Rect myRect3 = new Rect(width * 2 / 3, 0, width, height * 1 / 3);

        Rect myRect4 = new Rect(0, height * 1 / 3, width * 1 / 3, height * 2 / 3);
        Rect myRect5 = new Rect(width * 1 / 3, height * 1 / 3, width * 2 / 3, height * 2 / 3);
        Rect myRect6 = new Rect(width * 2 / 3, height * 1 / 3, width, height * 2 / 3);

        Rect myRect7 = new Rect(0, height * 2 / 3, width * 1 / 3, height);
        Rect myRect8 = new Rect(width * 1 / 3, height * 2 / 3, width * 2 / 3, height);
        Rect myRect9 = new Rect(width * 2 / 3, height * 2 / 3, width, height);

        mRects.clear();
        mRects.add(myRect1);
        mRects.add(myRect2);
        mRects.add(myRect3);
        mRects.add(myRect4);
        mRects.add(myRect5);
        mRects.add(myRect6);
        mRects.add(myRect7);
        mRects.add(myRect8);
        mRects.add(myRect9);
    }

    private void other() {
        mRects.clear();
        if(mFRects==null){
            return;
        }
        for(int i=0;i<mFRects.size();i++){
            FRect mFRect = mFRects.get(i);
            Rect mRect = new Rect((int)(width*mFRect.left),(int)(height*mFRect.top),(int)(width*mFRect.right),(int)(height*mFRect.bottom));
            mRects.add(mRect);
        }
    }

    private void initView() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSplitClickListener != null) {
                    mOnSplitClickListener.onSplitClick(v, position);
                }
            }
        });
    }

    public void setStyle(int style) {
        initValues();
        switch (style) {
            case STYLE_2_2:
                check_STYLE = STYLE_2_2;
                two_Two();
                break;
            case STYLE_3_2:
                check_STYLE = STYLE_3_2;
                three_Two();
                break;
            case STYLE_3_3:
                check_STYLE = STYLE_3_3;
                three_Three();
                break;
            case STYLE_Other:
                check_STYLE = STYLE_Other;
                other();
                break;
            default:
                check_STYLE = STYLE_2_2;
                two_Two();
                break;
        }
    }

    public void setOtherStyle(List<FRect> fRects) {
        if (fRects != null) {
            this.mFRects = fRects;
        } else {
            this.mFRects=null;
        }
        setStyle(STYLE_Other);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mRect != null) {
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setAlpha(180);
            canvas.drawRect(mRect, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mTouchX = event.getX();
                mTouchY = event.getY();
                if (mRects != null) {
                    for (int i = 0; i < mRects.size(); i++) {
                        Rect myRect = mRects.get(i);
                        if (myRect.contains((int) mTouchX, (int) mTouchY)) {
                            position = i;
                            mRect = myRect;
                            invalidate();
                            break;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                mRect = null;
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setOnSplitClickListener(onSplitClickListener onSplitClickListener) {
        this.mOnSplitClickListener = onSplitClickListener;
    }

    public interface onSplitClickListener {
        void onSplitClick(View v, int position);
    }

}
