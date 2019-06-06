package client.com.custompixels;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class NLinearLayout extends LinearLayout {
    private boolean flag;
    public NLinearLayout(Context context) {
        this(context,null);
    }

    public NLinearLayout(Context context,  @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NLinearLayout(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(!flag){
        float scaleX=Utils.getInstance(getContext()).getWidthScale();
        float scaleY=Utils.getInstance(getContext()).getHeightScale();
        //获取当前屏幕的宽度缩放比例
        //获取当前屏幕的高度缩放比例
        //  遍历子view
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) child.getLayoutParams();
            params.width=(int)(params.width*scaleX);
            params.height=(int)(params.height*scaleY);
            params.leftMargin=(int)(params.leftMargin*scaleX);
            params.rightMargin=(int)(params.rightMargin*scaleX);
            params.topMargin=(int)(params.topMargin*scaleY);
            params.bottomMargin=(int)(params.bottomMargin*scaleY);
        }
        flag=true;
    }
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
