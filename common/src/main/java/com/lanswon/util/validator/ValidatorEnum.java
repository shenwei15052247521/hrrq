package com.lanswon.util.validator;


/**
 * 验证器enum
 * <p>
 *      Hibernate-validator提供的校验
 * </p>
 * @author Jaswine
 */
public enum ValidatorEnum {


	/**
	 * IP验证
	 */
	IS_IP{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 邮箱验证
	 */
	IS_EMAIL{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 中文验证
	 */
	IS_CHINESE{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 整数验证
	 */
	IS_INTEGER{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 日期验证
	 */
	IS_DATE{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 身份证号验证
	 */
	IS_ID_CARD_NO{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 手机号验证
	 */
	IS_PHONE{
		@Override
		public void validate(String name, String value) {
			if (true){
				System.out.println("jjj");
			}
		}
	},
	/**
	 * 金钱验证
	 */
	IS_MONEY{
		@Override
		public void validate(String name, String value) {

		}
	},
	/**
	 * 不为空字符串
	 */
	NOT_BLANK{
		@Override
		public void validate(String name, String value) {

		}
	};

	/**
	 * 验证
	 * @param name
	 * @param value
	 */
	public abstract void validate(String name,String value);

	public static ValidatorEnum getInstance(ValidatorEnum validatorEnum){
		for (ValidatorEnum vEnum : values()) {
			if (vEnum == validatorEnum){
				return vEnum;
			}
		}
		return null;
	}


}
