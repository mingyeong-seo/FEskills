--'김민수' 데이터 삽입
INSERT INTO practice_users (USER_ID,NAME,EMAIL) 
VALUES (USER_SEQ.NEXTVAL, '김민수','minsuu@naver.com');

-- '박지연' 데이터 삽입
INSERT INTO practice_users (USER_ID,NAME,EMAIL,ROLE)
VALUES (user_seq.nextval,'박지연','jiyun@gmail.com','ADMIN');

-- TEMP_USERS 테이블에 있는 데이터 중 EMAIL이 NULL이 아닌 데이터만 PRACTICE로 옮겨라
INSERT INTO practice_users (USER_ID, NAME, EMAIL, JOIN_DATE, ROLE)
SELECT USER_SEQ.NEXTVAL,NAME, EMAIL,SYSDATE,'MIGRATED'
FROM temp_users
WHERE EMAIL IS NOT NULL;

-- 이름만 넣고 INSERT 하라
INSERT INTO practice_users (USER_ID,NAME)
VALUES (user_seq.nextval,'테스트');

-- 이미 존재하는 EMAIL이 있을 때 중복 에러 안 나게 INSERT 하는 방법은?
INSERT INTO practice_users (USER_ID, NAME, EMAIL)
SELECT user_seq.NEXTVAL, '홍길동', 'test@gmail.com'
FROM dual
WHERE NOT EXISTS (
    SELECT 1
    FROM practice_users
    WHERE email = 'test@gmail.com'
);