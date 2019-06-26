package com.lanswon.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lanswon.auth.bean.pojo.User;
import com.lanswon.util.json.JsonUtil;
import lombok.ToString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * token生成&验证
 *
 * @author Jasmine
 */
public class Jwtoken extends JWT {

	/**
	 * 加密秘钥
	 */
	private static final String SECRET = "TOKEN_SECRET";
	/**
	 * 使用的加密算法
	 */
	private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

	/**
	 * 生成token
	 * @return token token字符串
	 */
	public static String createToken(Claim claim) throws Exception{
		String token ;
		Map<String, Object> map = new HashMap<>(16);
		map.put("alg", "HS256");
		map.put("typ", "JWT");
		token = JWT.create()
				.withHeader(map)
				.withIssuer(claim.getIssUser())
				.withSubject(claim.getSubject())
				.withAudience(claim.getAudience())
				.withExpiresAt(claim.getExpirationTime())
				.withNotBefore(claim.getNotBeforeTime())
				.withIssuedAt(claim.getIssuedTime())
				.withJWTId(claim.getJId())
				.sign(ALGORITHM);
		return token;
	}

	/**
	 * 获得token中的信息
	 * @param token token字符串
	 * @return token信息
	 */
	public static User getTokenInfo(String token) throws IOException {
		JWTVerifier verifier = JWT.require(ALGORITHM).build();
		DecodedJWT jwt = verifier.verify(token);
		return JsonUtil.string2Obj(jwt.getClaims().get("sub").asString(), User.class);
	}

	/**
	 * 验证token
	 * @param token token字符串
	 * @return 验证结果
	 */
	public static TokenStatus verifyToken(String token){
		DecodedJWT jwt;
		JWTVerifier verifier = JWT.require(ALGORITHM).build();
		jwt = verifier.verify(token);
		if (jwt.getExpiresAt() != null && jwt.getExpiresAt().getTime() < System.currentTimeMillis()) {
			/* Token过期 */
			return TokenStatus.TOKEN_EXPIRED;
		} else {
			/* Token正常 */
			return TokenStatus.TOKEN_OK;
		}
	}

	@ToString
	enum TokenStatus{
		/**
		 * token正常
		 */
		TOKEN_OK(200,"token正常"),
		/**
		 * token已过期
		 */
		TOKEN_EXPIRED(400,"token已过期");


		private int code;
		private String msg;

		TokenStatus(int code,String msg){
			this.code = code;
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}
		public int getCode(){
			return code;
		}
	}

	public static void main(String[] args) throws Exception {
		Claim claim = new Claim<User>();

		User user = new User();
		user.setUsername("jaswine");
		user.setPassword("jaswine");

		claim.setIssUser("jasmine");
		claim.setAudience("jasmine");
		claim.setSubject(user);
		claim.setJId("jjlkjl");

		String token = Jwtoken.createToken(claim);
		System.out.println(token);
		System.out.println(Jwtoken.getTokenInfo(token).getUsername());
	}
}
