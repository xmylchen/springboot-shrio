package cn.ylchen.util;

import cn.ylchen.codec.Base64;
import cn.ylchen.codec.Hex;
import cn.ylchen.codec.Utf8;

import java.security.SecureRandom;
import java.util.UUID;

/*
 * 加密帮助类，暂时需要shiro-core支持
 */
public class HashHelper {

	// true表示使用十六进制编码，false表示使用base64编码
	private static final boolean IS_HEX_ENCODED = true;

	private static final int DEFAULT_SALT_LENGTH = 16;


	public static String generateRandomStr() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[DEFAULT_SALT_LENGTH];
		random.nextBytes(bytes);

		String str = null;

		if (IS_HEX_ENCODED)
			str = new String(Hex.encode(bytes));
		else
			str = Utf8.decode(Base64.encode(bytes));
		
		return str;
	}
	
	public static String generateGuid(){
		return UUID.randomUUID().toString();
	}
	
	public static String generateId(){
		return generateGuid().replaceAll("-", "");
	}
}
