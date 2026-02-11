-- ROLE이 'USER'인 사람만 조회해라
SELECT *
FROM practice_users
WHERE role = 'USER';

-- EMAIL이 NULL인 사람만 조회해라
SELECT *
FROM practice_users
WHERE email IS NULL;

-- USER_ID가 5 이상인 데이터 조회 후 ID 내림차순 정렬하라
SELECT *
FROM practice_users
WHERE user_id >= 5
ORDER BY user_id DESC;

-- NAME과 ROLE만 조회하고 ROLE이 'ADMIN' 또는 'MIGRATED'인 사람만 조회해라
SELECT name,role
FROM practice_users
WHERE role = 'ADMIN'
OR role = 'MIGRATED';

SELECT name,role
FROM practice_users
WHERE role IN ('ADMIN', 'MIGRATED');