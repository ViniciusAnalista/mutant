package com.serverless.domain;

public class MutantStats {

	public int count_mutant_dna;
	public int count_human_dna;
	public Float ratio;

	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	public int getCount_human_dna() {
		return count_human_dna;
	}
	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	public Float getRatio() {
		return ratio;
	}
	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}
}
