package com.serverless.test;

import com.serverless.process.MutantProcess;

public class MutantTest {
	
	public static void main(String[] args) {
		String[] dna = {"ATGCGATC", 
						"AGTGGATC", 
						"TTGTTCAT", 
						"AGAAGAGA", 
						"CCGTTGTG", 
						"TCACTACA",
						"TCACAACA",
						"TCACTACA"};
		
		MutantProcess mutant = new MutantProcess();
		
		System.out.println(mutant.ismutant(dna));
	}
}
