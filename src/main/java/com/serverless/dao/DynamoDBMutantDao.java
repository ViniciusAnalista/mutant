package com.serverless.dao;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.serverless.domain.Mutant;
import com.serverless.manager.DynamoDBManager;

public class DynamoDBMutantDao implements MutantDao {

	private static final Logger logger = LogManager.getLogger(DynamoDBMutantDao.class);

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

	private static volatile DynamoDBMutantDao instance;

	private DynamoDBMutantDao() {}

	public static DynamoDBMutantDao instance() {

		if (instance == null) {
			synchronized (DynamoDBMutantDao.class) {
				if (instance == null)
					instance = new DynamoDBMutantDao();
			}
		}
		return instance;
	}

	public void save(Mutant mutant) throws IOException {
		logger.info("Mutant - save(): " + mutant.toString());
		mapper.save(mutant);
	}

	public List<Mutant> list() throws IOException {
		DynamoDBScanExpression scanExp = new DynamoDBScanExpression();
		List<Mutant> results = mapper.scan(Mutant.class, scanExp);
		for (Mutant m : results) {
			logger.info("Mutant - list(): " + m.toString());
		}
		return results;
	}
}
