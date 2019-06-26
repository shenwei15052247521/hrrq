package com.lanswon.util.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 生成二维码工具类
 *
 * @version 1.0
 * @author Jaswine
 */
public class QRcode {

	/**
	 * 生成二维码方法
	 * @param content 内容
	 * @param width 宽度(400+)
	 * @param height 高度(400+)
	 * @param format 图片格式(gif,png,jpg)
	 * @param logoImg logo图片文件
	 * @throws IOException IO异常
	 * @throws WriterException 写异常
	 */
	public static void Encode_QR_CODE(String content, int width, int height, String format,File logoImg) throws IOException, WriterException {

		Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
		// 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 内容所使用字符集编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		// 设置二维码边的空度，非负数
		hints.put(EncodeHintType.MARGIN, 1);

		// 生成二维码
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE,
				// 条形码的宽度
				width,
				// 条形码的高度
				height,
				// 生成条形码时的一些配置,此项可选
				hints);
		// 输出到制定路径
		File outputFile = new File("d:" + File.separator + "new-1.gif");
		MatrixToImageWriter.writeToFile(bitMatrix, format, logoImg,outputFile);
	}
}
