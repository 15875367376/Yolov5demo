# Yolov5demo
yolo5安卓移植demo

只需换assets的.tflite模型文件和.txt标签文件即可，命名按照我test的的命名


如果要自己命名需要更改需要自己改动DetectorFactor.java的     "test.tflite" 和  "file:///android_asset/test.txt"

else if (modelFilename.equals("test.tflite")) {
            labelFilename = "file:///android_asset/test.txt";
            isQuantized = true;
            inputSize = 320;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
            
以及yolov5demo的   "test.tflite"

detector = DetectorFactory.getDetector(this.a,"test.tflite");  

然后直接运行项目即可
