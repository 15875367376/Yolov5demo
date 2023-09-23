package com.example.yolov5.yolov5;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.util.Log;


import com.example.yolov5.yolov5.tflite.Classifier;
import com.example.yolov5.yolov5.tflite.DetectorFactory;
import com.example.yolov5.yolov5.tflite.YoloV5Classifier;

import java.io.IOException;
import java.util.List;

public class yolov5demo {

    private  final AssetManager a;

    private YoloV5Classifier detector;

    public yolov5demo(AssetManager a){
        this.a = a;
    }

    public String start(Bitmap bitmap){
        //   模型初始化
        try {
            detector = DetectorFactory.getDetector(this.a,"test.tflite");
            detector.useCPU();
            detector.setNumThreads(4);
        }catch (IOException e){
            e.printStackTrace();
        }

        //开始识别
        List<Classifier.Recognition> results = detector.recognizeImage(bitmap);
        if (results == null) {
            Log.d("yolov5识别:", "result = null");
        }
        // 遍历回传
        String text = "";
        for (Classifier.Recognition result : results){
            text += result.toString() + "\n";
        }
        String text1 = "";
        text1 = detector.lightRGB();
        return text1;
    }


}
