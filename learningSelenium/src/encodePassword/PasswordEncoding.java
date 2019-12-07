package encodePassword;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncoding {

	public static void main(String[] args) 
	{
		String password="india123";
		
		byte[] encodePassword=Base64.encodeBase64(password.getBytes());
		System.out.println("Encoded password is:"+new String(encodePassword));
		
		byte[] decodePassword=Base64.decodeBase64("aW5kaWExMjM=".getBytes());
		System.out.println("DEcode password is:"+new String(decodePassword));
		
	}

}
