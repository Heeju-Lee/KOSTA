desc customer;
desc stock;
desc shares;

DROP TABLE customer;
DROP TABLE stock;
DROP TABLE shares;


create table customer
       (ssn varchar(50) primary key,
       cust_name varchar(50) not null,
       address varchar(100) not null ) ; 
 
create table stock
       (symbol varchar(20) primary key,
       price decimal(10,2) not null) ; 
 
create table shares
       (ssn varchar(30) not null,
       symbol varchar(20) not null,
       quantity int not null) ; 
 
insert into stock ( symbol,price) values( 'SUNW', 68.75);
insert into stock ( symbol,price) values( 'CyAs', 22.675);
insert into stock ( symbol,price) values( 'DUKE', 6.25);
insert into stock ( symbol,price) values( 'ABStk', 18.5);
insert into stock ( symbol,price) values( 'JSVco', 9.125);
insert into stock ( symbol,price) values( 'TMAs', 82.375);
insert into stock ( symbol,price) values( 'BWInc', 11.375);
insert into stock ( symbol,price) values( 'GMEnt', 44.625);
insert into stock ( symbol,price) values( 'PMLtd', 203.375);
insert into stock ( symbol,price) values( 'JDK', 33.5);

-- ---------------------------------------------
insert into customer values( '111-111', 'Yufirst1', 'Seoul');
insert into customer values( '111-112', 'Yufirst2', 'Seoul');
insert into customer values( '111-113', 'Yufirst3', 'Seoul');
insert into customer values( '111-114', 'Yufirst4', 'Seoul');
insert into customer values( '111-115', 'yufirst5', 'JeonJu');
insert into customer values( '111-116', 'Yufirst6', 'Seoul');
insert into customer values( '111-117', 'Yufirst7', 'Seoul');
insert into customer values( '111-118', 'Yufirst8', 'Seoul');
insert into customer values( '111-119', 'Yufirst9', 'Seoul');

select * from customer;
select * from stock;
select * from shares;

commit;

DELETE from shares where symbol='JDK';
DELETE from shares where symbol='DUKE';

INSERT INTO shares (ssn, symbol, quantity) VALUES ('111-111','JDK',75);
INSERT INTO shares (ssn, symbol, quantity) VALUES ('111-111','DUKE',10);

SELECT s.ssn, st.symbol, s.quantity FROM shares s JOIN custom c, stock st USING(ssn AND symbol) WHERE s.ssn = '111-111';

ALTER TABLE shares ADD CONSTRAINT fk_shares_ssn foreign key(ssn) references customer(ssn) ON DELETE CASCADE;
ALTER TABLE shares ADD CONSTRAINT fk_shares_symbol foreign key(symbol) references stock(symbol) ON DELETE CASCADE;