CREATE (Keanu:Person {name:'Keanu Reeves', born:1964})
CREATE (Carrie:Person {name:'Carrie-Anne Moss', born:1967})
CREATE (Laurence:Person {name:'Laurence Fishburne', born:1961})
CREATE (Hugo:Person {name:'Hugo Weaving', born:1960})
CREATE (LillyW:Person {name:'Lilly Wachowski', born:1967})
CREATE (LanaW:Person {name:'Lana Wachowski', born:1965})
CREATE (JoelS:Person {name:'Joel Silver', born:1952})

CREATE
  (Keanu)-[:HATES]->(Hugo),
  (Keanu)-[:LOVES]->(Carrie),
  (Laurence)-[:LOVES]->(Keanu),
  (Hugo)-[:HATES]->(Keanu),
  (Hugo)-[:HATES]->(Carrie),
  (Hugo)-[:HATES]->(Laurence)

CREATE (Icecream:Food {name: 'Icecream', taste:'sweet'})
CREATE (Steak:Food {name: 'Steak',taste:'salty'})
CREATE (Vegetables:Food {name: 'Vegetables',taste:'neutral'})
CREATE (Ropi:Food {name: 'Ropi' ,taste:'salty'})

CREATE
  (Keanu)-[:EATS]->(Steak),
  (Laurence)-[:EATS]->(Ropi),
  (Carrie)-[:EATS]->(Vegetables),
  (Carrie)-[:EATS]->(Icecream)


