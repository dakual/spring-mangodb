package com.dakual.springmongodb.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseEntity implements Serializable {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date createdAt;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String createdBy;
}
