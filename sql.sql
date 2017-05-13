use test;
create table news_inf
(
 id int auto_increment primary key,
 data varchar(255),
fullContent varchar(255)
);
DELIMITER |
create trigger t_full_content_gen BEFORE INSERT ON news_inf
	FOR EACH ROW BEGIN
		set new.fullContent=new.data;
	END;
|
DELIMITER ; ;