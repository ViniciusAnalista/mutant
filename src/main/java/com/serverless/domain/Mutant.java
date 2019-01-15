package com.serverless.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "DNA_MUTANTS")
public class Mutant{

	private String id;
	private int mutantDetector;

	@DynamoDBHashKey(attributeName = "id")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "mutantDetector")
	public int getMutantDetector() {
		return this.mutantDetector;
	}

	public void setMutantDetector(int mutantDetector) {
		this.mutantDetector = mutantDetector;
	}
}
