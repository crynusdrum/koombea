insert into usr (id, username, email, password) values (1, 'username1', 'email1@test.com', 'password1');
insert into usr (id, username, email, password) values (2, 'username2', 'email2@test.com', 'password2'); 

insert into page (id, url, usr_id) values (1, 'www.test1.com', 1);
insert into page (id, url, usr_id) values (2, 'www.test2.com', 1); 
insert into page (id, url, usr_id) values (3, 'www.test3.com', 2); 

insert into link (id, url, name, page_id) values (1, 'www.test1.com', 'name1', 1);
insert into link (id, url, name, page_id) values (2, 'www.test2.com', 'name2', 2); 
