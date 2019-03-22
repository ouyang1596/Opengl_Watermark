package com.watermark_libbrary.watermark.bean;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/29 0029.
 * 视频的信息bean
 */

public class VideoInfo implements Serializable {
    public String path;//路径
    public int rotation;//旋转角度
    public int width;//宽
    public int height;//高
    public int bitRate;//比特率
    public int frameRate;//帧率
    public int frameInterval;//关键帧间隔
    public int duration;//时长

    public int expWidth;//期望宽度
    public int expHeight;//期望高度
    public int cutPoint;//剪切的开始点
    public int cutDuration;//剪切的时长
    public Watermark watermark;

    public static class Watermark {
        /**
         * 水印的放置位置和宽高
         */
        private int x, y, width, height;
//        private int watermark;//水印资源id
        private Bitmap bitmapWatermark;

//        public int getWatermark() {
//            return watermark;
//        }
//
//        public void setWatermark(int watermark) {
//            this.watermark = watermark;
//        }

        public void setPosition(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public Bitmap getBitmapWatermark() {
            return bitmapWatermark;
        }

        public void setBitmapWatermark(Bitmap bitmapWatermark) {
            this.bitmapWatermark = bitmapWatermark;
        }
    }
}
