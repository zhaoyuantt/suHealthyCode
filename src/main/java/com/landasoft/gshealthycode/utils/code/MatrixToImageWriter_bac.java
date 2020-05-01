package com.landasoft.gshealthycode.utils.code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public final class MatrixToImageWriter_bac {

    private static final int BLACK = 0xFFFF0000; //二维码图形的颜色
    private static final int WHITE = 0xFFFFFFFF; //背景色

    private MatrixToImageWriter_bac() {}
    //这个方法是给二维码图形添加相同的颜色，可以改里面的代码，实现你想要的效果
    public static BufferedImage toBufferedImage(BitMatrix matrix){
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file)throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    public static void main(String []args)throws Exception{
        String text = "你好";
        int width = 300;
        int height = 300;
        String format = "png";
        Hashtable<EncodeHintType, Object>hints= new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
        File outputFile = new File("G://images//QRCode.png");
        MatrixToImageWriter_bac.writeToFile(bitMatrix, format, outputFile);
    }
}
