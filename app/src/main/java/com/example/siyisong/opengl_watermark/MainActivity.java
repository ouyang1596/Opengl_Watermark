package com.example.siyisong.opengl_watermark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.siyisong.opengl_watermark.watermark.helper.MagicFilterType;
import com.example.siyisong.opengl_watermark.watermark.mediacodec.VideoClipper;

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
                VideoClipper clipper = new VideoClipper();
                clipper.setInputVideoPath("/sdcard/testvideo.mp4");
//                String outputPath = Constants.getPath("video/clip/", System.currentTimeMillis() + "");
                String outputPath = "/sdcard/testvideo2.mp4";
                clipper.setFilterType(filterType);
                clipper.setOutputVideoPath(outputPath);
                clipper.setOnVideoCutFinishListener(new VideoClipper.OnVideoCutFinishListener() {
                    @Override
                    public void onFinish() {
                        Log.i("Ryan", "success");
                    }
                });
                try {
                    Log.e("hero", "-----PreviewActivity---clipVideo");
                    clipper.clipVideo(0, 23406 * 1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
