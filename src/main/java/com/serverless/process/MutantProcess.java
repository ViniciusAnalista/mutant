package com.serverless.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MutantProcess{

	public boolean ismutant(String[] dna) {
		
		int count = 0;
		int squareNumber = 0;
		
		if(isValidDNA(dna)){
			
			squareNumber = dna.length;
			
			for (int i = 0; squareNumber > i; i++) {
				for (int j = 0; dna[i].length() > j; j++) {
					
					if (j+4 < squareNumber && dna[i].charAt(j) == dna[i].charAt(j+1)) {
						StringBuilder valueHorizontal = new StringBuilder();
						valueHorizontal.append(dna[i].charAt(j));
						valueHorizontal.append(dna[i].charAt(j+1));
						valueHorizontal.append(dna[i].charAt(j+2));
						valueHorizontal.append(dna[i].charAt(j+3));
	
						String resultado = valueHorizontal.toString().replace(String.valueOf(dna[i].charAt(j)), "");
						if (resultado.length() == 0) {
							count ++;
						}
					}
	
					if (i+4 < squareNumber && dna[i].charAt(j) == dna[i+1].charAt(j)) {
						StringBuilder valueVertical = new StringBuilder();
						valueVertical.append(dna[i].charAt(j));
						valueVertical.append(dna[i+1].charAt(j));
						valueVertical.append(dna[i+2].charAt(j));
						valueVertical.append(dna[i+3].charAt(j));
						String resultado = valueVertical.toString().replace(String.valueOf(dna[i].charAt(j)), "");
	
						if (resultado.length() == 0) {
							count ++;
						}
					}
	
					if (i+4 < squareNumber && j+4 < squareNumber) {
						if (dna[i].charAt(j) == dna[i+1].charAt(j+1)) {
							StringBuilder valueDigLeft = new StringBuilder();
							valueDigLeft.append(dna[i].charAt(j));
							valueDigLeft.append(dna[i+1].charAt(j+1));
							valueDigLeft.append(dna[i+2].charAt(j+2));
							valueDigLeft.append(dna[i+3].charAt(j+3));
							String resultado = valueDigLeft.toString().replace(String.valueOf(dna[i].charAt(j)), "");
	
							if (resultado.length() == 0) {
								count ++;
							}
						}
					}
					
					if (i+4 < squareNumber && j >= 3) {
						if (dna[i].charAt(j) == dna[i+1].charAt(j-1)) {
							StringBuilder valueDigRight = new StringBuilder();
							valueDigRight.append(dna[i].charAt(j));
							valueDigRight.append(dna[i+1].charAt(j-1));
							valueDigRight.append(dna[i+2].charAt(j -2));
							valueDigRight.append(dna[i+3].charAt(j-3));
							String resultado = valueDigRight.toString().replace(String.valueOf(dna[i].charAt(j)), "");
	
							if (resultado.length() == 0) {
								count ++;
							}
						}
					}
				}
			}
		}
		return count > 1;
	}

	private boolean isValidDNA(String[] dna) {
		Pattern p = Pattern.compile("[aAcCgGtT]{"+dna[0].length()+"}");
		for (String letter : dna) {
			Matcher m = p.matcher(letter);
			if (!m.lookingAt()) {
				return false;
			}		
			if(dna.length != letter.length()){
				return false;
			}
		}
		return true;
	}
}
