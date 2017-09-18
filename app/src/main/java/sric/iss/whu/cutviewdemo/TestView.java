package sric.iss.whu.cutviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 2017/9/18.
 */

public class TestView extends RelativeLayout {

    private Paint mPaintRect;
    private Paint mPaintCirle;
    private Paint mPaintExtra;
    private Bitmap mBgBitmap;
    private Canvas mCanvas;
    private RectF mRect;
    private List<Points> rectList = new ArrayList<>();
    private boolean startDrawing  =false;

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addRects(Points points) {
        if (rectList.size() >= 6) return;
        if (!hasValue(points))
            rectList.add(points);
        if(rectList.size() == 6) {
            startDrawing = true;
            postInvalidate();
        }
    }

    private boolean hasValue(Points points) {
        for (Points points1 : rectList) {
            if (points1.tag == points.tag) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRect = new RectF(0, 0, getWidth(), getHeight());
        init();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(startDrawing){
            mBgBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBgBitmap);

            mCanvas.drawRect(mRect, mPaintRect);
//
//            for (Points points : rectList) {
//                Log.e("12345",points.toString());
//                Rect rect = new Rect(points.left, points.top, points.right, points.bottom);
//                mCanvas.drawRect(rect, mPaintCirle);
//                mCanvas.save();
//                mCanvas.clipRect(new RectF(points.right,points.top,points.right +(points.bottom - points.top)/2,points.bottom));
//                mCanvas.drawCircle(points.right ,(points.top + points.bottom)/2,(points.bottom - points.top)/2,mPaintCirle);
//                mCanvas.restore();
//            }




            for (Points points : rectList) {
                if(points.tag <=5){
                    Log.e("12345",points.toString());
                    Rect rect = new Rect(points.left, points.top, points.right -(points.bottom - points.top)/2, points.bottom);
                    mCanvas.drawRect(rect, mPaintCirle);
                    mCanvas.save();
                    mCanvas.clipRect(new RectF(points.right - (points.bottom - points.top)/2,points.top,points.right ,points.bottom));
                    mCanvas.drawCircle(points.right- (points.bottom - points.top)/2 ,(points.top + points.bottom)/2,(points.bottom - points.top)/2,mPaintCirle);
                    mCanvas.restore();
                }else {
                    drawLeftView(points);
                    mCanvas.drawCircle(200,500,50,mPaintCirle);
                }


            }



            canvas.drawBitmap(mBgBitmap, null, mRect, new Paint());
        }

    }



    private void drawLeftView(Points points){
        Rect rect = new Rect(points.left + (points.bottom - points.top)/2, points.top, points.right, points.bottom);
        mCanvas.drawRect(rect, mPaintCirle);
        mCanvas.save();
        mCanvas.clipRect(new RectF(points.left ,points.top,points.left+ (points.bottom - points.top)/2 ,points.bottom));
        mCanvas.drawCircle(points.left+ (points.bottom - points.top)/2 ,(points.top + points.bottom)/2,(points.bottom - points.top)/2,mPaintCirle);
        mCanvas.restore();
    }


    private void init() {

        mPaintRect = new Paint();
        mPaintRect.setColor(Color.TRANSPARENT);
        mPaintRect.setAlpha(200);

        mPaintCirle = new Paint();
        mPaintCirle.setStyle(Paint.Style.FILL);
        mPaintCirle.setAntiAlias(true);
        mPaintCirle.setColor(Color.WHITE);
        mPaintCirle.setAlpha(255);
        mPaintCirle.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));


        mPaintExtra = new Paint();
        mPaintExtra.setStyle(Paint.Style.FILL);
        mPaintExtra.setAntiAlias(true);
        mPaintExtra.setColor(Color.WHITE);
        mPaintExtra.setAlpha(255);
        mPaintExtra.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));


    }


}
