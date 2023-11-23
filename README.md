# Yolov5demo
yolo5安卓移植demo

Just change assets's ".tflite" model file and ".txt" label file is enough,name it as I "test"'s it.


If you want to name yourself you need to change it you need to change it yourself "DetectorFactor.java"'s   "test.tflite" and  "file:///android_asset/test.txt"

Here is the corresponding code snippet:
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
            
As well as "yolov5demo.java"'s   "test.tflite"

Here is the corresponding code snippet:
detector = DetectorFactory.getDetector(this.a,"test.tflite");  

Then run the project directly.
