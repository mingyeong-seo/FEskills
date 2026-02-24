CREATE TABLE MEMBER(

    ID VARCHAR2(50),
    PASS VARCHAR2(50),
    NAME VARCHAR2(20),
    REG_DATE DATE
);

SELECT * FROM MEMBER;

Select id,pass,name,reg_date from member where id = 'fs' and pass = 'hello';

