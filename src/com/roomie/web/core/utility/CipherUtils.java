package com.roomie.web.core.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CipherUtils {
	
	protected final static Log logger = LogFactory.getLog(CipherUtils.class);
	
	public static String encrypt(String strToEncrypt,String cipherKey){
		logger.debug("Start--encrypt() for:"+strToEncrypt);
		try{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        final SecretKeySpec secretKey = new SecretKeySpec(cipherKey.getBytes(), "AES");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        final String encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
	        logger.debug("End--encrypt() for:"+strToEncrypt);
	        return encryptedString;
		}catch (Exception e){
			logger.error("Error occured in encrypting the string"+e.getStackTrace());
		}
	    return null;
	}
	
	 public static String decrypt(String strToDecrypt,String cipherKey){
		 logger.debug("Start--decrypt() for:"+strToDecrypt);
		 try{
			 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			 final SecretKeySpec secretKey = new SecretKeySpec(cipherKey.getBytes(), "AES");
			 cipher.init(Cipher.DECRYPT_MODE, secretKey);
			 final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
			 logger.debug("Start--decrypt() for:"+strToDecrypt);
			 return decryptedString;
		 }catch (Exception e){
			 logger.error("Error occured in decrypting the string"+e.getStackTrace());
		 }
		 return null;
	 }
	 
	 public static void main(String[] args){
		 final String secret = "==nw63uwergh78l2"; // secret key length must be 16
		 String name = "Vaibhav";
		 System.out.println("Original string ="+name);
		 String encryptedName = CipherUtils.encrypt(name, secret);
		 String decryptedName = CipherUtils.decrypt(encryptedName, secret);
		 System.out.println("Encrypted string ="+encryptedName);
		 System.out.println("Decrypted string ="+decryptedName);
	 }
}
