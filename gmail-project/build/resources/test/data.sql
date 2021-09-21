DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info AS SELECT * FROM CSVREAD('classpath:user_data.csv');