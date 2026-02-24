INSERT INTO member(id,pass,name) Values(
    'min','min','민경'
);

INSERT INTO board(num,content,title,id) Values(SEQ_BOARD_NUM.nextval, '첫글 내용입니다.','첫글 제목','min'
);

commit;

select * from board;

select m.*, b.*
    from member m innner join board b
on m.id = b.id
where b.num = 1;