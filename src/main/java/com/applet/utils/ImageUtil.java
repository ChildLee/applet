package com.applet.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将上传的图片进行压缩后返回图片流
     *
     * @param is     图片流
     * @param suffix 图片类型(后缀)
     * @return 图片流
     */
    public static InputStream imgZip(InputStream is, String suffix) {
        BufferedImage bufferedImage;
        InputStream inputStream = null;
        try {
            bufferedImage = ImageIO.read(is);
            //等比压缩倍数,1为正常,小于1为缩放
            double scale = 0.8;
            //获取图片宽度
            int width = bufferedImage.getWidth();
            //获取图片高度
            int height = bufferedImage.getHeight();
            //将宽度等比缩放
            width = (int) (width * scale);
            //将高度等比缩放
            height = (int) (height * scale);
            //压缩处理
            Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            //将image转成流
            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = outputImage.createGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            //将BufferedImage转换成inputStream流
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(outputImage, suffix, os);
            inputStream = new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            log.error("图片压缩失败");
            System.out.println("图片压缩失败");
        }
        return inputStream;
    }
}