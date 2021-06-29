package com.hawaiianpizza.password.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Standard {
	int passwordLength;
	boolean boolNum;
	boolean boolSign;
	boolean boolUpper;
	boolean boolLower;
}
