package com.lanswon.util.json;

import com.lanswon.util.date.DateFormatEnum;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Json工具类
 * <p>
 *     Json工具类:使用Jackson对Json对象的操作进行了简单的封装
 * </p>
 *
 * @author Jaswine
 **/
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static SerialConfigBuilder builder() {
		return new SerialConfigBuilder();
	}

	static class SerialConfigBuilder {

		/**
		 * 序列化配置
		 *
		 * @param inclusion
		 * @return SerializationConfigBuilder
		 */
		SerialConfigBuilder setSerializationInclusion(Inclusion inclusion) {
			objectMapper.setSerializationInclusion(inclusion);
			return this;

		}

		/**
		 * 序列化时间格式
		 *
		 * @param dateFormat
		 * @return SerializationConfigBuilder
		 */
		SerialConfigBuilder setDateFormat(DateFormatEnum dateFormat) {
			objectMapper.setDateFormat(new SimpleDateFormat(dateFormat.getValue()));
			return this;
		}

		/**
		 * 是否将日期时间转换成时间戳格式
		 *
		 * @param flag true/false
		 * @return SerializationConfigBuilder
		 */
		SerialConfigBuilder setDateToTimestamps(boolean flag) {
			objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, flag);
			return this;
		}

		/**
		 * 是否忽略空bean转换错误
		 *
		 * @param flag true/false
		 * @return SerializationConfigBuilder
		 */
		SerialConfigBuilder setEmptyBeans(boolean flag) {
			objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, flag);
			return this;
		}

		/**
		 * 完成配置
		 * @return 配置后的objectMapper对象
		 */
		ObjectMapper endConfig() {
			return objectMapper;
		}
	}

//	static {
//		// 对象字段全部列入
//		objectMapper.setSerializationInclusion(Inclusion.NON_DEFAULT);
////
//		// 取消默认转换timestamps形式
//		objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);
////
////		// 忽略空bean转json的错误
////		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
////
//		// 统一日期格式yyyy-MM-dd HH:mm:ss
//		objectMapper.setDateFormat(new SimpleDateFormat(DateFormatEnum.YYYY_MM_DD_HH_MM_SS.getValue()));
////
////		// 忽略在json字符串中存在,但是在java对象中不存在对应属性的情况
//		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//	}

	private JsonUtil() {}

	/**
	 * Object转json字符串
	 *
	 * @param obj 对象
	 * @param <T>
	 * @return json字符串
	 */
	public static <T> String obj2String(T obj) throws Exception {
		if (obj == null) {
			return null;
		}
		return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
	}

	/**
	 * Object转json字符串并格式化美化
	 *
	 * @param obj 对象
	 * @param <T>
	 * @return json字符串
	 */
	public static <T> String obj2StringPretty(T obj) throws Exception {
		if (obj == null) {
			return null;
		}
		return obj instanceof String ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	}

	/**
	 * string转object
	 *
	 * @param str   json字符串
	 * @param clazz 被转对象class
	 * @param <T>
	 * @return
	 */
	public static <T> T string2Obj(String str, Class<T> clazz) throws IOException {
		if (StringUtils.isEmpty(str) || clazz == null) {
			return null;
		}
		return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
	}

	/**
	 * string转object
	 *
	 * @param str           json字符串
	 * @param typeReference 被转对象引用类型
	 * @param <T>
	 * @return
	 */
	public static <T> T string2Obj(String str, TypeReference<T> typeReference) throws IOException {
		if (StringUtils.isEmpty(str) || typeReference == null) {
			return null;
		}
		return (T) (typeReference.getType().equals(String.class) ? str : objectMapper.readValue(str, typeReference));
	}

	/**
	 * string转object 用于转为集合对象
	 *
	 * @param str             json字符串
	 * @param collectionClass 被转集合class
	 * @param elementClasses  被转集合中对象类型class
	 * @param <T>
	 * @return
	 */
	public static <T> T string2Obj(String str, Class<?> collectionClass, Class<?>... elementClasses) throws IOException {
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		return objectMapper.readValue(str, javaType);

	}

}
