package sric.iss.whu.cutviewdemo;

/**
 * Created by ly on 2017/9/18.
 */

public class Points {
    public int top;
    public int left;
    public int right;
    public int bottom;
    public int tag;

    public void setTag(int tag) {
        this.tag = tag;
    }


    public Points(int left, int top, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public String toString() {
//        return super.toString();
        return "left-->>" + left + "   top-->>" + top + "  right-->>" + right + "  bottom-->>" + bottom;
    }
}
