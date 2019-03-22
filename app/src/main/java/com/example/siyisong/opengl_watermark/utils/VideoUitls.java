package com.example.siyisong.opengl_watermark.utils;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.util.Log;


import java.io.IOException;

/**
 * Created by 杨杰 on 2017/3/21.
 * 获取音频或视频的信息
 */

public class VideoUitls {

    /**
     * 获取视频信息
     *
     * @param url
     * @return 视频时长（单位毫秒）
     */
    public static long getDuration(String url) {
        long time = 0;
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            time = mediaPlayer.getDuration();//获得了视频的时长（以毫秒为单位）
            mediaPlayer.release();
        } catch (IOException e) {
            Log.e("Ryan", "e==" + e.getLocalizedMessage());
            return 0;
        }
        return time;
    }

    //    public static VideoInfoBean getVideoInfo(String filePath) {
//        MediaMetadataRetriever retr = new MediaMetadataRetriever();
//        retr.setDataSource(filePath);
//        String width = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
//        String height = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
//        String rotation = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
//        VideoInfoBean videoInfoBean = new VideoInfoBean();
//        videoInfoBean.setVideoWidth(Integer.parseInt(width));
//        videoInfoBean.setVideoHeight(Integer.parseInt(height));
//        videoInfoBean.setVideoRotation(Integer.parseInt(rotation));
//        return videoInfoBean;
//    }
    public static String getVideoInfo(String filePath) {
        MediaMetadataRetriever retr = new MediaMetadataRetriever();
        retr.setDataSource(filePath);
        String width = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
        String height = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
        String rotation = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
        String mime = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
        return mime;
//        VideoInfoBean videoInfoBean = new VideoInfoBean();
//        videoInfoBean.setVideoWidth(Integer.parseInt(width));
//        videoInfoBean.setVideoHeight(Integer.parseInt(height));
//        videoInfoBean.setVideoRotation(Integer.parseInt(rotation));
//        return videoInfoBean;
    }
}
