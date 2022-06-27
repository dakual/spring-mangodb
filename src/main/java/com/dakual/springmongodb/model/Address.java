package com.dakual.springmongodb.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class Address {
	private String country;
	private String city;
	private String address;
}
