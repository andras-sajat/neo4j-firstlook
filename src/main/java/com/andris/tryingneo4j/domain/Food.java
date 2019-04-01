package com.andris.tryingneo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NodeEntity
@Data
@NoArgsConstructor
public class Food {
    
    @Id @GeneratedValue
    Long id;

    private String taste;

    @Relationship(type = "EATS")
    private List<Food> foods;

}