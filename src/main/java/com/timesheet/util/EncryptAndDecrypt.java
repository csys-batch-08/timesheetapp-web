package com.timesheet.util;

public class EncryptAndDecrypt {
	private  String pass;
	private  char[] passChars;
	private char[] let;
	private String encryptedPassword;
	
	EncryptAndDecrypt() {
		pass="oracle";
		passChars=pass.toCharArray();
		let=new char[passChars.length];
		
		int i=0;
		for(char c : passChars) {
			c+=5;
			let[i]=c;
			i++;
		}
		encryptedPassword=String.valueOf(let);
	
	}
	public  String decryt() {
		
		passChars=encryptedPassword.toCharArray();
		let=new char[passChars.length];
		int i=0;
		for(char c : passChars) {
			c-=5;
			let[i]=c;
			i++;
		}
		return String.valueOf(let);
	}

}

