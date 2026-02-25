INSERT INTO member(id,pass,name) Values(
    'min','min','민경'
);

INSERT INTO board(num,content,title,id) Values(SEQ_BOARD_NUM.nextval, '첫글 내용입니다.','첫글 제목','min'
);

commit;

select * from board;

select m.name, b.*
    from member m inner join board b
on m.id = b.id
where b.num = 1;

UPDATE board
SET visitcount = 0
WHERE visitcount IS NULL;

COMMIT;