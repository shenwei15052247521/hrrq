package com.lanswon.util.imgcompression;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * 图片压缩工具类
 * @author Jaswine
 */
public class PIcompreessionUtil {

	public static void main(String[] args) throws IOException {
		Thumbnails.of(new File("F:\\Jasmine\\Pictures\\desktop.png"))
				.scale(1f)
				.outputQuality(0.5f)
				.toFile(new File("F:\\Jasmine\\Pictures\\kl"));

		System.out.println("OK");
	}
}
