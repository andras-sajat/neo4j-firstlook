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
public class Person {
    
    @Id @GeneratedValue
    Long id;

    private String name;
    private int born;

    @Relationship(type = "HATES")
    private List<Person> hatedPersons;

    @Relationship(type = "LOVES")
    private List<Person> lovedPersons;

}