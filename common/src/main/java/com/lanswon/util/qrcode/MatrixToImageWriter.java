package com.lanswon.util.qrcode;

import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二维码输出成图片工具类
 *
 * @version 1.0
 * @author Jaswine
 */
 class MatrixToImageWriter {

	/**
	 * 用于设置图案的颜色
	 */
	private static final int BLACK = 0xFF000000;
	/**
	 * 用于背景色
	 */
	private static final int WHITE = 0xFFFFFFFF;

	private MatrixToImageWriter() {}

	private static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y,  (matrix.get(x, y) ? BLACK : WHITE));
			}
		}
		return image;
	}

	/**
	 * 文件形式输出图片
	 * @param matrix 二维码矩阵
	 * @param format 图片格式
	 * @param logoImg logo图片
	 * @param outImg 输出图片文件
	 * @throws IOException IO异常
	 */
	protected static void writeToFile(BitMatrix matrix, String format, File logoImg, File outImg) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		//设置logo图标
		LogoConfig logoConfig = new LogoConfig();
		image = logoConfig.LogoMatrix(image,logoImg);

		if (!ImageIO.write(image, format, outImg)) {
			throw new IOException("Could not write an image of format " + format + " to " + outImg);
		}else{
			System.out.println("图片生成成功！");
		}
	}

	/**
	 * 流的形式输出图片
	 * @param matrix 二维码矩阵
	 * @param format 输出图片格式
	 * @param logoImg logo图片
	 * @param stream 输出图片文件流
	 * @throws IOException IO异常
	 */
	protected static void writeToStream(BitMatrix matrix, String format, File logoImg, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		//设置logo图标
		LogoConfig logoConfig = new LogoConfig();
		image = logoConfig.LogoMatrix(image,logoImg);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

}
