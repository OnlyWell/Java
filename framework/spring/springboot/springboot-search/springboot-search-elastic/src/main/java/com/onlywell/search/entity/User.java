package com.onlywell.search.entity;

import java.io.Serializable;

import org.springframework.context.annotation.FilterType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

/**
 * @author harry
 */
@Data
@Document(indexName = "company", type = "users", shards = 1, replicas = 0, refreshInterval = "-1")
public class User implements Serializable {

	private static final long serialVersionUID = -636671624289974623L;

	@Id
	private Long id;

	@Field(type = FieldType.Text)
	private String name;

	@Field(type = FieldType.Text)
	private String about;

	@Field(type = FieldType.Text)
	private String phone;

	@Field(type=FieldType.Integer)
	private Integer age = 0;
}
