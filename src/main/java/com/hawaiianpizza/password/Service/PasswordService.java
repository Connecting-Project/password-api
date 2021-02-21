package com.hawaiianpizza.password.Service;

import org.springframework.stereotype.Service;

import com.hawaiianpizza.password.Model.Standard;

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
			ret.append(total.charAt((int) (Math.random() * total.length())));
		}
		return ret.toString();
	};

}