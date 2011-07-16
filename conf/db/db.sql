DROP DATABASE IF EXISTS svedjebratt;
CREATE DATABASE svedjebratt DEFAULT CHARSET=utf8;
GRANT USAGE ON *.* TO svedjebratt@'localhost';
DROP USER svedjebratt@'localhost';
GRANT ALL ON svedjebratt.* TO svedjebratt@'localhost' IDENTIFIED BY 'morbidbulle';

