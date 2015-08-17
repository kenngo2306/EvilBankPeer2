
CREATE TABLE Evil_Account 
(
    Account_Number VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(60),
    Starting_Balance number(20,4),
    birth_date date
);


CREATE TABLE Evil_Transactions 
(
    ID integer PRIMARY KEY,
    account_number VARCHAR(20),
    Transaction_type_ID integer,
    Transaction_date date,
    Amount number (10,2));
    
create table Evil_transaction_type (
    ID integer primary key,
    Transaction_type varchar (20)
    );
    
CREATE TABLE Evil_Customer
(
  id INTEGER PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30)
)

CREATE TABLE Evil_Account_Type
(
  id INTEGER PRIMARY KEY,
  type_name VARCHAR(30)
)

INSERT INTO Evil_Account_Type VALUES(1,'CHECKING');
INSERT INTO Evil_Account_Type VALUES(2,'SAVING');

alter table evil_account drop column name;
alter table evil_account drop column birth_date;
alter table evil_account add customer_id integer;

alter table evil_customer add phone_number varchar(20);
alter table evil_account add account_type_id integer;


CREATE SEQUENCE transaction_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE customer_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
DROP TRIGGER SEQ_TRANSACTION;


CREATE OR REPLACE TRIGGER SEQ_CUSTOMER
BEFORE INSERT ON TESTDB.EVIL_CUSTOMER
FOR EACH ROW
BEGIN
	IF :new.ID IS NULL THEN
		:new.id := customer_seq.nextval;
	END IF;
END;


CREATE OR REPLACE TRIGGER SEQ_TRANSACTION
BEFORE INSERT ON TESTDB.EVIL_TRANSACTIONS
FOR EACH ROW
BEGIN
	IF :new.ID IS NULL THEN
		:new.id := transaction_seq.nextval;
	END IF;
END;

    
    truncate table Evil_account;
    truncate table Evil_transactions;
    drop table  Evil_account;
    drop table  Evil_transactions;
    drop table  Evil_transaction_type;
    
    
    select * from  Evil_account;