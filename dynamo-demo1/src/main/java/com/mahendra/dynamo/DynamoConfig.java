package com.mahendra.dynamo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
public class DynamoConfig {
	
	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDbEndpoint;
	
	@Value("${amazon.aws.accesskey}")
	private String amazonAccessKey;
	
	@Value("${amazon.aws.secretkey}")
	private String amazonSecretKey;
	

	@Bean /// Spring managed component
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB db = new AmazonDynamoDBClient(new BasicAWSCredentials(amazonAccessKey, amazonSecretKey));
		db.setEndpoint(amazonDynamoDbEndpoint);
		return db;
	}
}
