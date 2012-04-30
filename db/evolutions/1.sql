# --- !Ups
 
CREATE TABLE shout (
    id SERIAL,
    echo varchar(60) NOT NULL,
    created timestamp NOT NULL,
    PRIMARY KEY (id)
);
 
# --- !Downs

DROP TABLE shout;