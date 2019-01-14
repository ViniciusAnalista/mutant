package com.serverless.manager;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


public class DynamoDBManager {
	private static volatile DynamoDBManager instance;

    private DynamoDBMapper mapper;
    private AmazonDynamoDB client;

    private DynamoDBManager() {

        client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
        mapper = new DynamoDBMapper(client);
    }

    public static DynamoDBManager instance() {

        if (instance == null) {
            synchronized(DynamoDBManager.class) {
                if (instance == null)
                    instance = new DynamoDBManager();
            }
        }

        return instance;
    }

    public static DynamoDBMapper mapper() {
        DynamoDBManager manager = instance();
        return manager.mapper;
    }
}
