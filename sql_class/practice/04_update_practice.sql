-- practice 테이블에서 EMAIL이 NULL인 사람들의 ROLE을 'GUEST'로 변경하라
SELECT *
FROM practice_users
WHERE email IS NULL;

UPDATE practice_users
SET role = 'GUEST'
WHERE email IS NULL;

-- ROLE이 'USER'이고 USER_ID가 5 이상인 사람들의 ROLE을 'POWER_USER'로 변경하라
SELECT *
FROM practice_users
WHERE role = 'USER'
AND user_id >= 5;

UPDATE practice_users
SET role = 'POWER_USER'
WHERE role = 'USER'
AND user_id >= 5;

-- USER_ID가 3인 사람의 ROLE을 'ADMIN' JOIN_DATE를 오늘 날짜로 변경하라
SELECT *
FROM practice_users
WHERE user_id = 3;

UPDATE practice_users
SET role = 'ADMIN', join_date = SYSDATE
WHERE user_id = 3;

-- USER_ID가 2 ~ 4 사이인 사람들의 EMAIL을 NULL로 변경하라
SELECT *
FROM practice_users
WHERE user_id BETWEEN 2 AND 4;

UPDATE practice_users
SET email = NULL
WHERE user_id BETWEEN 2 AND 4;

-- ROLE이 'ADMIN'인 사람을 'SUPER_ADMIN'으로 바꾸려고 한다.
SELECT * 
FROM practice_users
WHERE role = 'ADMIN';

UPDATE practice_users
SET role = 'SUPER_ADMIN'
WHERE role = 'ADMIN';

COMMIT;
