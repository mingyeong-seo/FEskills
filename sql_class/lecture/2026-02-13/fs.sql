INSERT INTO caseexam values ('f','fff','f');
SELECT * FROM caseexam;

select c_id, c_name,
    DECODE(gender,'m','남성','f','여성') decode_gender,
    CASE gender when 'm' then '남성'
                when 'f' then '여성'
                else ''
            end case_gender
from caseexam;

RENAME caseexam TO caseex;
SELECT * FROM caseex;


