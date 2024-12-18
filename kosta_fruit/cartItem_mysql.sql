ORACLE

create table item(
	     item_id number(5),
	     item_name varchar2(30),
	     price number(7),
	     description varchar2(800),
	     picture_url varchar2(30),
	     count number(5),
	     primary key(item_id));

insert into item values(
1111,'딸기',4500,
'면역력을 강화시켜 질병에 효과적이다.',
'img/berry.jpg',0
);

insert into item values(
2222,'포도',5000,
'철분이 많고 조혈 작용을 해 임산부, 여성에게 일어나기 쉬운 빈혈을 예방한다',
'img/grape.jpg',0
);

insert into item values(
3333,'귤',4000,
'눈 건강 살리고 피로 회복, 혈압 안정시키는 비타민 A 가많다',
'img/gual.jpg',0
);

insert into item values(
4444,'키위',8000,
'키위 1개에 함유된 비타민 C는 오렌지의 2배. 비타민 E는 사과의 6배나 된다',
'img/kiui.jpg',0
);

insert into item values(
5555,'레몬',3000,
'구연산 비타민C가 풍부하여 피로회복에 도움이 된다.',
'img/lemon.jpg',0
);

commit;

------------------------------------------------------------------------
MYSQL

CREATE TABLE item (
  item_id INT NOT NULL,
  item_name VARCHAR(45) NOT NULL,
  price INT NOT NULL,
  descriptio VARCHAR(100) NOT NULL,
  picture_url VARCHAR(45) NOT NULL,
  count INT NULL,
  PRIMARY KEY (item_id));

  insert into item values(
1111,'딸기',4500,
'면역력을 강화시켜 질병에 효과적이다.',
'img/berry.jpg',0
);

insert into item values(
2222,'포도',5000,
'철분이 많고 조혈 작용을 해 임산부, 여성에게 일어나기 쉬운 빈혈을 예방한다',
'img/grape.jpg',0
);

insert into item values(
3333,'귤',4000,
'눈 건강 살리고 피로 회복, 혈압 안정시키는 비타민 A 가많다',
'img/gual.jpg',0
);

insert into item values(
4444,'키위',8000,
'키위 1개에 함유된 비타민 C는 오렌지의 2배. 비타민 E는 사과의 6배나 된다',
'img/kiui.jpg',0
);

insert into item values(
5555,'레몬',3000,
'구연산 비타민C가 풍부하여 피로회복에 도움이 된다.',
'img/lemon.jpg',0
);

commit;