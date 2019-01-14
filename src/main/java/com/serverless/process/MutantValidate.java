package com.serverless.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MutantValidate {

	public boolean ismutant(String[] dna) {
		
		int result = 0;
		
		if(isValidDNA(dna)){
			for (int i = 0; dna.length > i; i++) {
				for (int j = 0; dna[i].length() > j; j++) {
	
					if (j <= 2 && dna[i].charAt(j) == dna[i].charAt(j+1)) {
						StringBuilder valueVertical = new StringBuilder();
						valueVertical.append(dna[i].charAt(j));
						valueVertical.append(dna[i].charAt(j+1));
						valueVertical.append(dna[i].charAt(j+2));
						valueVertical.append(dna[i].charAt(j+3));
	
						String resultado = valueVertical.toString().replace(String.valueOf(dna[i].charAt(j)), "");
						if (resultado.length() == 0) {
							result ++;
						}
					}
	
					if (i <= 2 && dna[i].charAt(j) == dna[i+1].charAt(j)) {
						StringBuilder valueHorizontal = new StringBuilder();
						valueHorizontal.append(dna[i].charAt(j));
						valueHorizontal.append(dna[i+1].charAt(j));
						valueHorizontal.append(dna[i+2].charAt(j));
						valueHorizontal.append(dna[i+3].charAt(j));
						String resultado = valueHorizontal.toString().replace(String.valueOf(dna[i].charAt(j)), "");
	
						if (resultado.length() == 0) {
							result ++;
						}
					}
	
					if (i <= 2 && j <= 2) {
						if (dna[i].charAt(j) == dna[i+1].charAt(j+1)) {
							StringBuilder valueDigLeft = new StringBuilder();
							valueDigLeft.append(dna[i].charAt(j));
							valueDigLeft.append(dna[i+1].charAt(j+1));
							valueDigLeft.append(dna[i+2].charAt(j+2));
							valueDigLeft.append(dna[i+3].charAt(j+3));
							String resultado = valueDigLeft.toString().replace(String.valueOf(dna[i].charAt(j)), "");
	
							if (resultado.length() == 0) {
								result ++;
							}
						}
					}
					
					if (i <= 2 && j >= 3) {
						if (dna[i].charAt(j) == dna[i+1].charAt(j-1)) {
							StringBuilder valueDigRight = new StringBuilder();
							valueDigRight.append(dna[i].charAt(j));
							valueDigRight.append(dna[i+1].charAt(j-1));
							valueDigRight.append(dna[i+2].charAt(j -2));
							valueDigRight.append(dna[i+3].charAt(j-3));
							String resultado = valueDigRight.toString().replace(String.valueOf(dna[i].charAt(j)), "");
	
							if (resultado.length() == 0) {
								result ++;
							}
						}
					}
				}
			}
		}
		
		return result > 1;
	}

	private boolean isValidDNA(String[] dna) {

		if (dna.length == 6) {
			 Pattern p = Pattern.compile("[aAcCgGtT]{6}");
			for (String letter : dna) {
				Matcher m = p.matcher(letter);
				if (!m.lookingAt()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
