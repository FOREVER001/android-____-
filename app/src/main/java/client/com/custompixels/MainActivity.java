package client.com.custompixels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_item01;
    private TextView tv_item02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_item01=findViewById(R.id.tv_item01);
        tv_item02=findViewById(R.id.tv_item02);

      int itemWidth=  tv_item01.getLayoutParams().width;
      int itemWidth2=  tv_item02.getLayoutParams().width;
        Log.e("==实际宽001==",itemWidth+"");
        Log.e("==实际宽002==",itemWidth2+"");
    }
}
