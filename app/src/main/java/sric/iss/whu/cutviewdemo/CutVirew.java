package sric.iss.whu.cutviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by ly on 2017/9/18.
 */

public class CutVirew extends RelativeLayout {

    private Paint mPaintCirle;
    private Paint mPaintRect;
    private Canvas mCanvas;//阴影层画布
    private RectF mRect;//整个屏幕
    private Bitmap mBgBitmap;//用于绘制阴影层的bitmap

    public CutVirew(Context context) {
        this(context, null);
    }

    public CutVirew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CutVirew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaintRect = new Paint();
        mPaintRect.setColor(Color.TRANSPARENT);
        mPaintRect.setAlpha(200);

        mPaintCirle = new Paint();
        mPaintCirle.setStyle(Paint.Style.FILL);
        mPaintCirle.setAntiAlias(true);
        mPaintCirle.setColor(Color.WHITE);
        mPaintCirle.setAlpha(255);
        mPaintCirle.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));//XOR模式：重叠部分被掏空
    }


    private void drawSpacing() {

        Bitmap mBgBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBgBitmap);
        RectF mRect = new RectF(0, 0, getWidth(), getHeight());

        Paint mPaintRect = new Paint();
        mPaintRect.setColor(Color.TRANSPARENT);
        mPaintRect.setAlpha(200);

        Paint mPaintCirle = new Paint();
        mPaintCirle.setStyle(Paint.Style.FILL);
        mPaintCirle.setAntiAlias(true);
        mPaintCirle.setColor(Color.WHITE);
        mPaintCirle.setAlpha(255);
        mPaintCirle.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));//XOR模式：重叠部分被掏空


        mCanvas.drawRect(mRect, mPaintRect);
        mCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mPaintCirle);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mBgBitmap == null) {
            mBgBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBgBitmap);
            mRect = new RectF(0, 0, getWidth(), getHeight());
        }


        mCanvas.drawRect(mRect, mPaintRect);
        mCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mPaintCirle);

//        mCanvas.drawRect(0,0,200,100,mPaintCirle);

        canvas.drawBitmap(mBgBitmap, null, mRect, new Paint());


    }


}
