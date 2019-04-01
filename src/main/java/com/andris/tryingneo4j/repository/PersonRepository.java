package com.andris.tryingneo4j.repository;

import java.util.Collection;

import com.andris.tryingneo4j.domain.Person;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (p:Person) WHERE p.name CONTAINS {partialName} RETURN p")
    Collection<Person> findByPartialName(@Param("partialName") String partialName);

}