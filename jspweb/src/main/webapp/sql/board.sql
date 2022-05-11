create table jspweb.board( /* 테이블 생성 */

	bno int primary key auto_increment , /* 게시물번호 */
    btitle varchar(50) , 				/* 게시물제목 */
    bcontent LONGTEXT ,			/* 게시물내용 */
    mno int ,							/* 작성자 = member테이블 mno 관계 */
    bfile varchar(1000) ,				/* 게시물첨부파일 */
    bview int default 0 ,				/* 게시물 조회수 */
    bdate datetime default now() ,		/* 게시물 작성일 */
    foreign key( mno ) references member(mno) 
    /* 게시물테이블의 작성자mno와 회원테이블의 회원번호mno와 FK-PK 연결 */
    
);

/* SELECT * FROM BOARD WHERE btitle = 'dfg' ; */
/* select * from 테이블명 where 필드명 = 값 ; */
SELECT * FROM BOARD WHERE btitle like '%d%';
/* = [ 같다 ]  : 모두 동일한 데이터 검색  */
/* like연산자 [ 비교연산자 ] : 데이터가 포함된[일부] 검색 */
/*	% 연산자 : 모든 문자 대응 ( 문자 길이 상관 없음 )
 * 			김% : 김으로 시작하는 데이터 	
 * 			%김 : 김으로 끝나는 데이터 
 * 			%김% : 김이 포함된 데이터
 * 
 *  _ 연산자 : 모든 문자 대응 ( _ 개수만큼 )
 * 			김_	: 김으로 시작하는 두글자 단어
 * 			_김 : 김으로 끝나는 두글자 단어 
 * 			_김_ : 2번 글자에 김이 포함된 세글자 단어 
 * 			김__ : 김으로 시작하는 세글자 단어 
 *  
 */
/* DBMS 회사 마다 문법차이!!!  [ 수업: mysql , 외부평가 : 오라클 ] 
 * 
 * 
 * 
 * 
 * 
 * 
