-- EMAIL이 NULL인 사람들을 삭제하라
SELECT * 
FROM practice_users
WHERE email IS NULL;

DELETE FROM practice_users
WHERE email IS NULL;

SELECT *
FROM practice_users
WHERE email IS NULL;

-- ROLE이 'GUEST'인 사람들을 삭제하라.
SELECT *
FROM practice_users
WHERE role = 'GUEST';

DELETE FROM practice_users
WHERE role = 'GUEST';

SELECT *
FROM practice_users
WHERE role = 'GUEST';

-- USER_ID가 3 이하인 사람들을 삭제하라.
SELECT *
FROM practice_users
WHERE user_id <= 3;

DELETE FROM practice_users
WHERE user_id <= 3;

SELECT *
FROM practice_users
WHERE user_id <= 3;

-- ROLE이 'ADMIN' 또는 'SUPER_ADMIN'인 사람들을 삭제하라.
SELECT *
FROM practice_users
WHERE role in ('ADMIN','SUPER_ADMIN');

DELETE FROM practice_users
WHERE role in ('ADMIN','SUPER_ADMIN');

SELECT *
FROM practice_users
WHERE role in ('ADMIN','SUPER_ADMIN');

-- USER_ID가 가장 큰 사람 1명만 삭제하라 
DELETE FROM practice_users
WHERE user_id = (
    SELECT MAX(user_id)
    FROM practice_users
);

COMMIT;
