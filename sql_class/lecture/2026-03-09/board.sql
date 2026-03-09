select * FROM reply ORDER BY board_bno;

-- 글 번호 100번에 해당하는 게시글의 모든 내용과 댓글들을 출력해 보자 (Join 사용)
SELECT board.bno, board.title, board.content, rno, text
FROM board LEFT JOIN reply 
ON reply.board_bno = board.bno
WHERE board.bno = 100;