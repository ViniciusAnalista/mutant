package com.serverless.domain;

public class DnaReceived {

	String [] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	public String dnaString(){
		StringBuilder dnaBuilder = new StringBuilder();
		for(String col : this.getDna()){
			dnaBuilder.append(col);
		}
		return dnaBuilder.toString();
	}
}
