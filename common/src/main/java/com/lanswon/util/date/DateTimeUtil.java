package com.lanswon.util.date;



import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

/**
 * 日期/时间工具类
 *
 * <p>
 *     提供对日期和时间的常规操作，基于Jdk1.8编写。Java8中新增日期和时间是符合{@code ISO-8601}标准的
 *     对时间格式返回进行了基本的封装，提拱了几种时间格式
 *
 *     {@link java.util}中对时间的操作的类不是安全的，Java8提供了新的日期时间类来操作
 * </p>
 *
 * @see LocalDate
 * @see LocalTime
 * @see LocalDateTime
 * @see java.time.Duration
 *
 * @author Jaswine
 * @version 1.0
 *
 */
public final class DateTimeUtil {


	/**
	 * 获得时间(默认:10:10：10)
	 * @return hh:mm:ss
	 */
	public static String getTime(){
		return getTime(LocalTime.now(),DateFormatEnum.HH_MM_SS);
	}

	/**
	 * 获得时间 - 指定返回格式
	 * @param time 时间
	 * @param dateFormatEnum 时间格式
	 * @throws UnsupportedTemporalTypeException 不支持的时间格式
	 * @return 对应格式的时间
	 */
	public static String getTime(LocalTime time,DateFormatEnum dateFormatEnum) throws UnsupportedTemporalTypeException{
		return DateTimeFormatter.ofPattern(dateFormatEnum.getValue()).format(time);
	}

	/**
	 * 获得日期(默认:2018-10-10)
	 * @return yyyy-mm-dd
	 */
	public static String getDate(){
		return getDate(LocalDate.now(),DateFormatEnum.YYYY_MM_DD);
	}

	/**
	 * 获得日期 - 指定返回格式
	 * @param date 本地日期对象
	 * @param dateFormat 日期格式
	 * @return 对应格式的日期
	 * @throws UnsupportedTemporalTypeException 不支持的日期格式异常
	 */
	public static String getDate(LocalDate date,DateFormatEnum dateFormat) throws UnsupportedTemporalTypeException {
		return DateTimeFormatter.ofPattern(dateFormat.getValue()).format(date);
	}

	/**
	 * 获得日期时间(默认:2018-10-10 10:10:10)
	 * @return yyyy-mm-dd hh:mm:ss
	 */
	public static String getDateTime(){
		return getDateTime(LocalDateTime.now(),DateFormatEnum.YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 获得日期时间 - 指定返回格式
	 * @param dateTime 本地日期时间
	 * @param dateFormat 日期时间格式
	 * @throws UnsupportedTemporalTypeException 不支持的日期时间格式
	 * @return 对应格式的日期时间
	 */
	public static String getDateTime(LocalDateTime dateTime,DateFormatEnum dateFormat) throws UnsupportedTemporalTypeException{
		return DateTimeFormatter.ofPattern(dateFormat.getValue()).format(dateTime);
	}


	/**
	 * string->localDate
	 * @param date string
	 * @return
	 */
	public static LocalDate getDate(String date){
		return LocalDate.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
	}

	/**
	 * string->localDateTime
	 * @param date string
	 * @return
	 */
	public static LocalDateTime getDateTime(String date){
		return LocalDateTime.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
	}

	/**
	 * Instant转Date
	 * @param instant 时间戳
	 * @return date
	 */
	public static Date convert(Instant instant){
		return Date.from(instant);
	}

	/**
	 * LocalDate转Date
	 * @param date 日期
	 * @return date
	 */
	public static Date convert(LocalDate date){
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * LocalDateTime转Date
	 * @param dateTime 日期时间
	 * @return date
	 */
	public static Date convert(LocalDateTime dateTime){
		return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalTime string2LocalTime(String time){
		return LocalTime.parse(time);
	}


	enum WeekEnum {

		/**
		 * 周一
		 */
		MONDAY("星期一", "Monday", "Mon.", 1),
		/**
		 * 周二
		 */
		TUESDAY("星期二", "Tuesday", "Tues.", 2),
		/**
		 * 周三
		 */
		WEDNESDAY("星期三", "Wednesday", "Wed.", 3),
		/**
		 * 周四
		 */
		THURSDAY("星期四", "Thursday", "Thur.", 4),
		/**
		 * 周五
		 */
		FRIDAY("星期五", "Friday", "Fri.", 5),
		/**
		 * 周六
		 */
		SATURDAY("星期六", "Saturday", "Sat.", 6),
		/**
		 * 周末
		 */
		SUNDAY("星期日", "Sunday", "Sun.", 7);

		/**
		 * 中文_形式
		 */
		private String nameCN;
		/**
		 * 英文_形式
		 */
		private String nameEN;
		/**
		 * 英文缩写_形式
		 */
		private String nameShortEN;
		/**
		 * 阿拉伯数字_形式
		 */
		int number;

		WeekEnum(String nameCN, String nameEN, String nameShortEN, int number) {
			this.nameCN = nameCN;
			this.nameEN = nameEN;
			this.nameShortEN = nameShortEN;
			this.number = number;
		}

		public String getChineseName() {
			return this.nameCN;
		}

		public String getNameEn() {
			return this.nameEN;
		}

		public String getShortName() {
			return this.nameShortEN;
		}

		public int getNumber() {
			return this.number;
		}
	}


}

