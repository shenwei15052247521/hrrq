package com.lanswon.util.validator;//package com.jaswine.util.validator;
//
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * 验证工具类
// * @author Jaswine
// */
//@SuppressWarnings("static-access")
//public class ValidateUtils {
//
//	private ValidateUtils(){}
//	/**
//	 * 是否是整数
//	 * @param value 参数
//	 */
//	public static boolean isInteger(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^-?[1-9]\\d*$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是正整数
//	 * @param value 参数
//	 */
//	public static boolean isUnsignedInteger(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[1-9]\\d*$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是负整数
//	 * @param value 参数
//	 */
//	public static boolean isIntege2(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^-[1-9]\\d*$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是数字
//	 * @param value 参数
//	 */
//	public static boolean isNum(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^([+-]?)\\d*\\.?\\d+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是正数（正整数 + 0）
//	 * @param value 参数
//	 */
//	public static boolean isNum1(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[1-9]\\d*|0$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是负数（负整数 + 0）
//	 * @param value 参数
//	 */
//	public static boolean isNum2(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^-[1-9]\\d*|0$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是浮点数
//	 * @param value 参数
//	 */
//	public static boolean isDecmal(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^([+-]?)\\d*\\.\\d+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是正浮点数
//	 * @param value 参数
//	 */
//	public static boolean isDecmal1(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 判断是否金额格式
//	 * @param value 参数
//	 * @return
//	 */
//	public static boolean isMoney(String value) {
//
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,8})?$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//
//	}
//
//	/**
//	 * 是否是负浮点数
//	 * @param value 参数
//	 */
//	public static boolean isDecmal2(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是浮点数
//	 * @param value 参数
//	 */
//	public static boolean isDecmal3(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是非负浮点数（正浮点数 + 0）
//	 * @param value 参数
//	 */
//	public static boolean isDecmal4(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是非正浮点数（负浮点数 + 0）
//	 * @param value 参数
//	 */
//	public static boolean isDecmal5(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是邮件
//	 * @param value 参数
//	 */
//	public static boolean isEmail(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是颜色
//	 * @param value 参数
//	 */
//	public static boolean isColor(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[a-fA-F0-9]{6}$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是url
//	 * @param value 参数
//	 */
//	public static boolean isUrl(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是中文
//	 * @param value 参数
//	 */
//	public static boolean isChinese(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是ACSII字符
//	 * @param value 参数
//	 */
//	public static boolean isAscii(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[\\x00-\\xFF]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是邮编
//	 * @param value 参数
//	 */
//	public static boolean isZipcode(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^\\d{6}$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是手机
//	 * @param value 参数
//	 */
//	public static boolean isMobile(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^1[345678][0-9]{9}$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是ip地址
//	 * @param value 参数
//	 */
//	public static boolean isIp(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是非空
//	 * @param value 参数
//	 */
//	public static boolean isNotempty(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^\\S+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是图片
//	 * @param value 参数
//	 */
//	public static boolean isPicture(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是压缩文件
//	 * @param value 参数
//	 */
//	public static boolean isRar(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("(.*)\\.(rar|zip|7zip|tgz)$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是日期
//	 * @param value 参数
//	 */
//	public static boolean isDate(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是QQ号码
//	 * @param value 参数
//	 */
//	public static boolean isQq(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[1-9]*[1-9][0-9]*$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是电话号码的函数(包括验证国内区号,国际区号,分机号)
//	 * @param value 参数
//	 */
//	public static boolean isTel(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 用来用户注册。只能包含英文字母、数字、"-"和"_"
//	 * @param value 参数
//	 */
//	public static boolean isUsername(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[a-zA-Z][\u4e00-\u9fa5A-Za-z0-9-_]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是字母
//	 * @param value 参数
//	 */
//	public static boolean isLetter(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是大写字母
//	 * @param value 参数
//	 */
//	public static boolean isLetter_u(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[A-Z]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是大写字母
//	 * @param value 参数
//	 */
//	public static boolean isLetter_l(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^[a-z]+$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是价格
//	 * @param value 参数
//	 */
//	public static boolean isPrice(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("^([1-9]{1}[0-9]{0,}(\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|\\.[0-9]{1,2})$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否是身份证号
//	 * @param value 参数
//	 */
//	public static boolean isIdNo(String value) {
//		Pattern p1 ;
//		Matcher m  ;
//		Matcher m1 ;
//		boolean b ;
//		boolean b1 ;
//		Pattern pattern = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
//		p1 = p1.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$");
//		m = pattern.matcher(value);
//		b = m.matches();
//		m1 = p1.matcher(value);
//		b1 = m1.matches();
//		return b || b1;
//	}
//
//	/**
//	 * 是否是中国人姓名
//	 * @param value 参数
//	 */
//	public static boolean isPersonName(String value) {
//		Matcher m ;
//		boolean b ;
//		Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*");
//		m = pattern.matcher(value);
//		b = m.matches();
//		return b;
//	}
//
//	/**
//	 * 是否符合密码格式
//	 * @param value 参数
//	 * @return
//	 */
//	public static boolean isPassword(String value) {
//		// 先得判断是否含有特殊字符
//		Pattern pattern = Pattern.compile("^(?!\\W*[0-9]+\\W*$)(?!\\W*[a-zA-Z]+\\W*$)[^\\s'\"]{6,16}$");
//		Matcher matcher = pattern.matcher(value);
//		return matcher.matches();
//	}
//}
