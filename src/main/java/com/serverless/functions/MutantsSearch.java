package com.serverless.functions;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.serverless.dao.DynamoDBMutantDao;
import com.serverless.domain.ApiGatewayResponse;
import com.serverless.domain.Mutant;
import com.serverless.domain.MutantStats;

public class MutantsSearch {
	
	private static final Logger logger = LogManager.getLogger(MutantsSearch.class);

	private DynamoDBMutantDao eventDao = DynamoDBMutantDao.instance();

	public ApiGatewayResponse handleRequest() {
		
		try {
			
			List<Mutant> mutants = eventDao.list();
			int i = 0;
			
			for(Mutant m: mutants){
				if (m.getMutantDetector() == 1){
					i++;
				}
			}
			
			MutantStats stats = new MutantStats();
		    stats.setCount_human_dna(mutants.size());
			stats.setCount_mutant_dna(i);
			stats.setRatio((float) (i*100)/mutants.size());
			
	        return ApiGatewayResponse.builder()
	        	  .setStatusCode(200)
	        	  .setObjectBody(stats)
	        	  .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Serverless"))
	        	  .build();
	        
		} catch (Exception e) {
	          logger.error("Error in search mutant: " + e);
	          return ApiGatewayResponse.builder()
					.setStatusCode(500)
					.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Serverless"))
					.build();
		}
	}
}
