SELECT USER FROM DUAL;

CREATE TABLE PRACTICE_USERS (
    USER_ID NUMBER NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    EMAIL VARCHAR2(50) UNIQUE,
    JOIN_DATE DATE DEFAULT SYSDATE,
    ROLE VARCHAR2(20) DEFAULT 'USER',
    CONSTRAINT practice_users_pk PRIMARY KEY (USER_ID)
);

CREATE TABLE TEMP_USERS(
    NAME VARCHAR2(20) NOT NULL,
    EMAIL VARCHAR2(50)
);

CREATE SEQUENCE USER_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE;

COMMIT;

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '김하늘', 'sky@gmail.com', 'USER');

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '이수진', NULL, 'USER');

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '박준호', 'junho@gmail.com', 'ADMIN');

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '최민아', NULL, 'ADMIN');

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '정우성', 'woo@gmail.com', 'USER');

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '한지민', 'han@gmail.com', 'MIGRATED');

INSERT INTO practice_users (USER_ID, NAME, EMAIL, ROLE)
VALUES (user_seq.NEXTVAL, '오지훈', NULL, 'USER');

COMMIT;


SELECT user_id, name, email, role
FROM practice_users
ORDER BY user_id;

-- 테스트 데이터 10개 추가 (JOIN_DATE, ROLE은 기본값 사용)
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '김민수', 'minsu01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '박지연', 'jiyun01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '이서준', 'seojun01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '최유나', 'yuna01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '정우성', 'woosung01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '한지민', 'jimin01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '오세훈', 'sehun01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '윤하늘', 'haneul01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '강수지', 'suji01@gmail.com');
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '임도현', 'dohyun01@gmail.com');

-- 이메일 NULL 2개 (IS NULL / DELETE 연습용)
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '테스트NULL1', NULL);
INSERT INTO practice_users (user_id, name, email) VALUES (user_seq.nextval, '테스트NULL2', NULL);

SELECT COUNT(*) AS cnt FROM practice_users;

SELECT *
FROM practice_users
ORDER BY user_id;

COMMIT;

-- 2개 테이블 생성: ROLES, PRACTICE_ORDERS
-- ROLES (ROLE 코드/설명 테이블)
CREATE TABLE ROLES (
    ROLE_CODE   VARCHAR2(20) NOT NULL,
    ROLE_NAME   VARCHAR2(30) NOT NULL,
    CONSTRAINT ROLES_PK PRIMARY KEY (ROLE_CODE)
);
-- PRACTICE_ORDERS (유저가 여러 주문을 갖는 1:N 테이블)
CREATE TABLE PRACTICE_ORDERS (
    ORDER_ID     NUMBER NOT NULL,
    USER_ID      NUMBER NOT NULL,
    PRODUCT_NAME VARCHAR2(50) NOT NULL,
    AMOUNT       NUMBER(10,0) NOT NULL,
    ORDER_DATE   DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT PRACTICE_ORDERS_PK PRIMARY KEY (ORDER_ID),
    CONSTRAINT PRACTICE_ORDERS_FK_USER FOREIGN KEY (USER_ID)
        REFERENCES PRACTICE_USERS (USER_ID)
);
-- ORDER_ID용 시퀀스
CREATE SEQUENCE ORDER_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE;

-- 데이터 넣기
INSERT INTO ROLES (ROLE_CODE, ROLE_NAME) VALUES ('USER', '일반 사용자');
INSERT INTO ROLES (ROLE_CODE, ROLE_NAME) VALUES ('ADMIN', '관리자');
INSERT INTO ROLES (ROLE_CODE, ROLE_NAME) VALUES ('GUEST', '게스트');
INSERT INTO ROLES (ROLE_CODE, ROLE_NAME) VALUES ('MIGRATED', '이관 사용자');

UPDATE PRACTICE_USERS SET ROLE = 'ADMIN'    WHERE USER_ID IN (10, 11);
UPDATE PRACTICE_USERS SET ROLE = 'MIGRATED' WHERE USER_ID IN (20, 21);
UPDATE PRACTICE_USERS SET ROLE = 'GUEST'    WHERE USER_ID = 18;

-- USER_ID 7: 주문 2개
INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 7, '아메리카노', 4500);

INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 7, '샌드위치', 6500);

-- USER_ID 10(ADMIN): 주문 1개
INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 10, '노트북 파우치', 12000);

-- USER_ID 11(ADMIN): 주문 3개
INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 11, '키보드', 39000);

INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 11, '마우스', 25000);

INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 11, '마우스패드', 9000);

-- USER_ID 20(MIGRATED): 주문 1개
INSERT INTO PRACTICE_ORDERS (ORDER_ID, USER_ID, PRODUCT_NAME, AMOUNT) 
VALUES (ORDER_SEQ.NEXTVAL, 20, '데이터베이스 책', 28000);

COMMIT;

