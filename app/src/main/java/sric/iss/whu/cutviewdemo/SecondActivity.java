package sric.iss.whu.cutviewdemo;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ly on 2017/9/18.
 */

public class SecondActivity extends Activity {
    private TestView testView;
    private ImageView img1, img2, img3, img4, img5, img6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initRes();
    }

    private void initRes() {
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);
        testView = (TestView) findViewById(R.id.testView);

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        int[] locals = new int[2];
//        img1.getLocationOnScreen(locals);
//        Log.d("1233",locals[0] + "    "+locals[1] +"   " +img1.getWidth()+"  "+ img1.getHeight());


//    Log.d("1234",img1.getLeft() +"  " +img1.getTop() +"    " +img1.getRight() +"   "+img1.getBottom());
        initPoints(img1, 1);
        initPoints(img2, 2);
        initPoints(img3, 3);
        initPoints(img4, 4);
        initPoints(img5, 5);
        initPoints(img6, 6);
    }

    private void initPoints(View view, int tag) {
        Points points = new Points(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        points.setTag(tag);
        testView.addRects(points);
    }
}
