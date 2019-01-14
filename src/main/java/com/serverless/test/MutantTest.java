package com.serverless.test;

import com.serverless.process.MutantValidate;

public class MutantTest {
	
	public static void main(String[] args) {
		String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		
		MutantValidate mutant = new MutantValidate();
		
		System.out.println(mutant.ismutant(dna));
	}
}
