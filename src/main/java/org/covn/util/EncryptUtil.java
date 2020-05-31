package org.covn.util;



import org.apache.commons.lang3.tuple.Pair;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.lang.NonNull;

public class EncryptUtil {

	private static final String algorithm = "PBEWithMD5AndDES";
	private StandardPBEStringEncryptor encryptor;
	private static final String PASSWORD = "c@v!d-n3w!0rd3r";
	
	public EncryptUtil(){
		this(PASSWORD);
	}
	
	public EncryptUtil(String password){
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm(algorithm);
		config.setPassword(password);
		this.encryptor = new StandardPBEStringEncryptor();
		this.encryptor.setConfig(config);
	}
	
	
	public String encryptText(String plainText){
		return encryptor.encrypt(plainText);
	}
	
	public String decryptText(String encryptedText){
		return encryptor.decrypt(encryptedText);
	}
	
	
	private static final String del="|";
	public static String encryptUserPhoneNum(long userId, @NonNull String phoneNum) {
		String value = String.join(del, userId+"", phoneNum);
		String encrypted = encrypt(value);
		return encrypted;
	}
	
	public static Pair<Long, String> decryptUserPhoneNum(String encrypted) {
		try {
			String value = decrypt(encrypted);
			String token[] = value.split(del);
			long userId = Long.parseLong(token[0]);
			String phoneNum = token[1];
			return Pair.of(userId, phoneNum);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static String encrypt(String plainText){
		EncryptUtil util = new EncryptUtil();
		return util.encryptText(plainText);
	}
	
	
	public static String decrypt(String encryptedText){
		EncryptUtil util = new EncryptUtil();
		return util.decryptText(encryptedText);
	}
	
}