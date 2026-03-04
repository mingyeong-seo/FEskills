-- CREATE TABLE test(idx INTEGER);

-- autoincrement: 오라클의 시퀸스처럼
-- 1씩 값을 증가시키는 함수임

-- CREATE TABLE test2(
--	idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--	NAME VARCHAR(20) NOT NULL
-- );

INSERT INTO test2(NAME) VALUES ('aa');

SELECT * FROM tbl_memo;


select
        m1_0.mno,
        m1_0.memo_text 
    from
        tbl_memo m1_0 
    limit
        0,100
        
select
        count(m1_0.mno) 
    from
        tbl_memo m1_0
        
COMMIT;