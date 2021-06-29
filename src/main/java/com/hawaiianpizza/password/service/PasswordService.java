package com.hawaiianpizza.password.service;

import org.springframework.stereotype.Service;

import com.hawaiianpizza.password.model.Standard;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class PasswordService {

	public String generator(Standard stan) { 
		String num = "0123456789";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String sign = "`~!@#$%^&*()-_=+[{]};:',<.>/?\"";
		String total = "";
		StringBuilder ret = new StringBuilder();
		if(stan.isBoolLower()) {
			total+=lower;
		}
		if(stan.isBoolNum()){
			total+=num;
		}
		if(stan.isBoolSign())
			total+=sign;
		if(stan.isBoolUpper())
			total+=upper;
		for(int i = 0;i<stan.getPasswordLength();i++) {
			try {
				SecureRandom ran = SecureRandom.getInstance("SHA1PRNG");
				ret.append(total.charAt(ran.nextInt(total.length())));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return ret.toString();
	}

}