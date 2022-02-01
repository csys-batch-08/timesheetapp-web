package com.timesheet.util;

public class EncryptAndDecrypt {
	private  String pass;
	private  char[] passwordChars;
	private char[] let;
	private String encryptedPassword;
	
	EncryptAndDecrypt() {
		pass="oracle";
		passwordChars=pass.toCharArray();
		let=new char[passwordChars.length];
		
		int i=0;
		for(char c : passwordChars) {
			c+=5;
			let[i]=c;
			i++;
		}
		encryptedPassword=String.valueOf(let);
	
	}
	public  String decryt() {
		
		passwordChars=encryptedPassword.toCharArray();
		let=new char[passwordChars.length];
		int i=0;
		for(char c : passwordChars) {
			c-=5;
			let[i]=c;
			i++;
		}
		return String.valueOf(let);
	}

}

