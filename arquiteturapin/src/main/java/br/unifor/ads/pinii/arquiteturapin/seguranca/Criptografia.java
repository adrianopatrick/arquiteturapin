/**
 * 
 */
package br.unifor.ads.pinii.arquiteturapin.seguranca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de out de 2015
 */
public class Criptografia {
	
	public static String encripta (String original) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
			byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));
			 
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			String senha = hexString.toString();
			return senha;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException ns) {
			ns.printStackTrace();
			return null;
		}
	}

}
