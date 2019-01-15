package com.serverless.test;

import com.serverless.process.MutantProcess;

public class MutantTest {
	
	public static void main(String[] args) {
		String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		
		MutantProcess mutant = new MutantProcess();
		
		System.out.println(mutant.ismutant(dna));
	}
}
