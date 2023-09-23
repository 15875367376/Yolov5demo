package com.example.yolov5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

import com.example.yolov5.yolov5.env.Utils;
import com.example.yolov5.yolov5.yolov5demo;

public class MainActivity extends AppCompatActivity {

    public static final float MINIMUM_CONFIDENCE_TF_OD_API = 0.5f;

    private ImageView ivShow;
    private Button btStart;
    private TextView tvShow;
    private Bitmap bitmap, bitmap1;

    public static final int TF_OD_API_INPUT_SIZE = 320;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   判断Opencv是否加载成功
        if (OpenCVLoader.initDebug()) {
            Toast.makeText(this, "OpenCv加载成功", Toast.LENGTH_SHORT).show();
        }

        //  初始化控件
        intView();
    }

    private void intView() {
        ivShow = findViewById(R.id.iv_show);             //  图像显示控件
        tvShow = findViewById(R.id.tv_show);            //   文本框控件
        btStart = findViewById(R.id.bt_start);          //   按钮控件

        //     把指定图片传给bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.train1);

        Log.d("KaiXuan", "w: " + bitmap.getWidth() + "h: " + bitmap.getHeight());

        //     将传完后的bitmap显示出来
        ivShow.setImageBitmap(bitmap);

        //   按钮点击
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "测试", Toast.LENGTH_SHORT).show();
                /*   将bitmap传给Utils的processBitmap的方法函数进行分辨率处理，
                     将需要的分辨率传进去，这里我设置了一个固定变量TF_OD_API_INPUT_SIZE，
                     在上面可以通过修改TF_OD_API_INPUT_SIZE的值来改变你想修改的分辨率
                     将修改分辨率后的bitmap传给bitmap1
                */
                bitmap1 = Utils.processBitmap(bitmap, TF_OD_API_INPUT_SIZE);
                        /*
                        打印修改后的分辨率，判断是否有进行分辨率修改，
                        判断bitmap1是否为空，
                        要防止bitmap1出现空指针
                         */
                        Log.d("KaiXuan","w: " + bitmap1.getWidth() + "h: "+bitmap1.getHeight());
                        if (bitmap1 == null){
                            Log.d("RGBlight:","bitmap = null");
                        }

                        // 开始识别
                /*
                调用写好的yolov5demo类的star函数
                将上面处理好的bitmap1传进去
                进行识别处理
                yolov5demo这个类是处理模型的类，对模型初始化等等
                 */
                        yolov5demo yolov5demo = new yolov5demo(getAssets());
                        String text33 = yolov5demo.start(bitmap1);
                        ivShow.setImageBitmap(bitmap1);

                          //  显示识别
                         tvShow.setText(text33);
                         Log.d("RGBlight","test: " + text33);
                         if (text33 == null){
                         Log.d("RGBlight","test = null");
                         }
                           }
                         });
    }
}