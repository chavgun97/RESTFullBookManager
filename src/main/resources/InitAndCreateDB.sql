Drop table if EXISTS BOOKS_AUTHORS;
Drop table if EXISTS AUTHORS;
Drop table if EXISTS BOOKS;
create table AUTHORS (
  ID integer not null auto_increment,
  FIRST_NAME varchar(255),
  LAST_NAME varchar(255),
  primary key (ID));

create table BOOKS (
  ID integer not null auto_increment,
  DESCRIPTION varchar(255),
  TITLE varchar(255),
  primary key (ID));

create table BOOKS_AUTHORS (
  BOOKS_id integer not null,
  AUTHORS_id integer not null,
  primary key (BOOKS_id, AUTHORS_id));
alter table BOOKS_AUTHORS add constraint FKoq3lbr4imhe2bujslc7ncwieo foreign key (AUTHORS_id) references AUTHORS (ID);
alter table BOOKS_AUTHORS add constraint FKe27iabdd6binw18gj8ry0tqug foreign key (BOOKS_id) references books (ID);

insert into books(TITLE, DESCRIPTION) value ('In Search of Lost Time', 'Swann''s Way, the first part of A la recherche de temps perdu, Marcel Proust''s seven-part cycle, was published in 1913');
insert into books(TITLE, DESCRIPTION) value ('Don Quixote', 'Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper.');
insert into books(TITLE, DESCRIPTION) value ('Ulysses', 'Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904.');
insert into books(TITLE, DESCRIPTION) value ('The Great Gatsby', 'The novel chronicles an era that Fitzgerald himself dubbed the "Jazz Age". ');
insert into books(TITLE, DESCRIPTION) value ('Moby Dick', 'First published in 1851, Melville''s masterpiece is, in Elizabeth Hardwick''s words, "the greatest novel in American literature."');
insert into books(TITLE, DESCRIPTION) value ('Hamlet', 'The Tragedy of Hamlet, Prince of Denmark, or more simply Hamlet, is a tragedy by William Shakespeare, believed to have been written between 1599 and 1601. ');
insert into books(TITLE, DESCRIPTION) value ('War and Peace', 'Epic in scale, War and Peace delineates in graphic detail events leading up to Napoleon''s invasion of Russia.');
insert into books(TITLE, DESCRIPTION) value ('TestManyToMany','test Many to Many');


INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('Marcel','Proust''s');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('Miguel',' de Cervantes');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('James','Joyce');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('F. Scott','Fitzgerald');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('Herman','Melville');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('William','Shakespeare');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('Leo','Tolstoy');
INSERT INTO AUTHORS(FIRST_NAME, LAST_NAME) VALUE ('TestMany','ToMany');


INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (1,1);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (2,2);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (3,3);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (4,4);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (5,5);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (6,6);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (7,7);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,1);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,2);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,3);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,4);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,5);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,6);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,7);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (1,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (2,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (3,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (4,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (5,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (6,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (7,8);
INSERT INTO books_authors(AUTHORS_ID, BOOKS_ID) VALUE (8,8);



