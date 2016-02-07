package br.com.exemplo.codigo;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.Base64;

public class AESEncriptadorDecriptador {
	

	public static String AESEncriptar(byte[] key, String value) throws Throwable {
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			String chaveRetorno = Base64.encodeBase64URLSafeString(encrypted);
			return chaveRetorno;
		} catch (Exception e) {
			throw new Throwable("Erro ao criptografar informações " + e.getMessage());
		}
	}
	
	public static String AESDecriptar(byte[] key, String encrypted) throws Throwable {
		byte[] decrypted = null;
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			byte[] decoded = new Base64().decode(encrypted);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			decrypted = cipher.doFinal(decoded);
		} catch (Exception e) {
			throw new Throwable("Erro ao descriptografar"+ e.getMessage());
		}
		return new String(decrypted);
	}
	

}
