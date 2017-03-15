package com.cl.news.modules.news.newslist;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/3/11 0011.
 */

class RecyclerItemDecoration extends RecyclerView.ItemDecoration {

    private final Paint paint;

    public  RecyclerItemDecoration(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
       outRect.set(0,0,0, (int) paint.getStrokeWidth());
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
         int left=parent.getPaddingLeft();
        int right=parent.getMeasuredWidth()-parent.getPaddingRight();
        int count=parent.getChildCount();
        for (int i=0;i<count;i++){
            View child=parent.getChildAt(i);
            int bottom=child.getBottom();
            c.drawLine(left,bottom,right,bottom,paint);
        }
    }
}
