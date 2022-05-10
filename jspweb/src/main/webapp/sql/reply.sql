CREATE TABLE reply(
	rno int primary key auto_increment ,
    rcontent varchar(1000) ,
    rdate datetime default now() ,
    rindex int ,
    bno int ,
    mno int ,
    foreign key( bno ) references board( bno ) on delete cascade ,
    foreign key( mno ) references member( mno ) 
);

/* board 테이블의 bno (pk) 삭제되면 reply 테이블의 bno(fk) 레코드 같이 업데이트 · 삭제 */
/*  on delete : pk 레코드가 삭제되면 fk 레코드도 같이 삭제 설정 */
/*  on update : pk 레코드가 수정되면 fk 레코드도 같이 수정 설정 */