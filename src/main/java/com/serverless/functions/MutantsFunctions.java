package com.serverless.functions;

import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.serverless.dao.DynamoDBMutantDao;
import com.serverless.domain.ApiGatewayResponse;
import com.serverless.domain.DnaReceived;
import com.serverless.domain.Mutant;
import com.serverless.process.MutantValidate;

public class MutantsFunctions{

	private static final Logger logger = LogManager.getLogger(MutantsFunctions.class);

	private  DynamoDBMutantDao eventDao = DynamoDBMutantDao.instance();


	public ApiGatewayResponse handleRequest(DnaReceived dna) {

      try {
    	  MutantValidate validate = new MutantValidate();
    	  Mutant mutant = new Mutant();
    	  int statusCode = 0;
    	  mutant.setId(dna.dnaString());
    	     	  
          if (validate.ismutant(dna.getDna())){
        	  mutant.setMutantDetector(1);
        	  statusCode = 200;
          } else {
        	  mutant.setMutantDetector(0);
        	  statusCode = 403;
	      }
          
          eventDao.save(mutant);

          return ApiGatewayResponse.builder()
        		  .setStatusCode(statusCode)
        		  .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Serverless"))
        		  .build();
      		
      } catch (Exception ex) {
          logger.error("Error in saving mutant: " + ex);
          return ApiGatewayResponse.builder()
					.setStatusCode(500)
					.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Serverless"))
					.build();
      }
	}
}
