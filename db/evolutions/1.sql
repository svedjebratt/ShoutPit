# --- !Ups
 
CREATE TABLE shout (
    id SERIAL PRIMARY KEY,
    echo varchar(60) NOT NULL,
    created timestamp NOT NULL
);
 
# --- !Downs

DROP TABLE shout;