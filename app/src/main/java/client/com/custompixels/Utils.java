package client.com.custompixels;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class Utils {
    //设计稿的参考宽高
    private static final float STANDARD_WIDTH=750;
    private static final float STANDARD_HEIGHT=1334;

    //这里显示屏幕的宽和高
    private   int  mDisplayWidth;
    private   int mDisplayHeight;
    private static Utils instance;
    private Utils(Context context){

        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dp=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dp);
        if(dp.widthPixels>dp.heightPixels){//横屏
            mDisplayWidth=dp.heightPixels;
            mDisplayHeight=dp.widthPixels;
        }else {
            mDisplayWidth=dp.widthPixels;
            mDisplayHeight=dp.heightPixels-getStatusBarHeight(context);
        }

        Log.e("====width===",mDisplayWidth+"");
        Log.e("====height===",mDisplayHeight+"");
    }

    /**
     * 获取手机状态栏的高度
     * */
    private int getStatusBarHeight(Context context) {
        int resId=context.getResources().getIdentifier("status_bar_height","dimen","android");
        if(resId>0){
            return context.getResources().getDimensionPixelSize(resId);
        }
        return 0;
    }

    public static Utils getInstance(Context context){
        if(instance==null){
            instance=new Utils(context.getApplicationContext());
        }
        return instance;
    }

    //获取水平方向的缩放比例
    public float getWidthScale(){
        return mDisplayWidth/STANDARD_WIDTH;
    }
    //获取垂直方向的缩放比例
    public float getHeightScale(){
        return mDisplayHeight/STANDARD_HEIGHT;
    }

}
