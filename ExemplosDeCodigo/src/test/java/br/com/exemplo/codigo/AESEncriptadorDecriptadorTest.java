package br.com.exemplo.codigo;

import org.junit.Assert;
import org.junit.Test;

public class AESEncriptadorDecriptadorTest {

	@Test
	public void AESEnciptadorTest(){
		String chave = "abcd1234567efghi";
		try {
			String chaveCript = AESEncriptadorDecriptador.AESEncriptar(chave.getBytes(), "senha123");
			Assert.assertTrue(chaveCript.equals("HxT_rHkZey1Kfc6PPPxzXA"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
