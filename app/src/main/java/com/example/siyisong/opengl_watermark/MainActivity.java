package com.example.siyisong.opengl_watermark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.siyisong.opengl_watermark.utils.VideoUitls;
import com.watermark_libbrary.watermark.bean.VideoInfo;
import com.watermark_libbrary.watermark.helper.MagicFilterType;
import com.watermark_libbrary.watermark.mediacodec.VideoClipper;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    private MagicFilterType filterType = MagicFilterType.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "/storage/emulated/0/DCIM/Camera/222.mp4";
                Log.i("Ryan", "mine==" + VideoUitls.getVideoInfo(path));
                addWatermark(path);
//                VideoClipper clipper = new VideoClipper();
//                clipper.setInputVideoPath("/storage/emulated/0/DCIM/Camera/1551766608150.mp4");
//                VideoInfo.Watermark watermark = new VideoInfo.Watermark();
//                watermark.setWatermark(R.mipmap.watermark);
//                watermark.setPosition(0, 100, 0, 0);
//                clipper.setWatermark(watermark);
////                String outputPath = Constants.getPath("video/clip/", System.currentTimeMillis() + "");
//                String outputPath = "/sdcard/testvideo2.mp4";
//                clipper.setFilterType(filterType);
//                clipper.setOutputVideoPath(outputPath);
//                clipper.setOnVideoCutFinishListener(new VideoClipper.OnVideoCutFinishListener() {
//                    @Override
//                    public void onFinish() {
//                        Log.i("Ryan", "success");
//                    }
//                });
//                try {
//                    Log.e("hero", "-----PreviewActivity---clipVideo");
//                    clipper.clipVideo(0, 10000 * 1000);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }

    private void addWatermark(final String filePath) {
        VideoClipper clipper = new VideoClipper();
        clipper.setInputVideoPath(filePath);
        VideoInfo.Watermark watermark = new VideoInfo.Watermark();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ms_live_watermark);
        watermark.setBitmapWatermark(bitmap);
//        watermark.setPosition(0, 100, 0, 0);
        clipper.setWatermark(watermark);
        final String outputPath = "/storage/emulated/0/DCIM/Camera/333.mp4";
        clipper.setOutputVideoPath(outputPath);
        clipper.setOnVideoCutFinishListener(new VideoClipper.OnVideoCutFinishListener() {

            @Override
            public void onFinish() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "succ", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        try {
            clipper.clipVideo(0, VideoUitls.getDuration(filePath) * 1000);
        } catch (IOException e) {
        }
    }


}
