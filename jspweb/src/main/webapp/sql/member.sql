/* 데이터 베이스 생성  */
create database jspweb; 

/* 테이블 생성 */
create table jspweb.member(
	mno 		int primary key auto_increment ,	/* 회원식별 필드( 식별키=pk / 자동번호부여=ai) */
	mid 		varchar(15), /* 아이디 필드 */
	mpassword	varchar(15), /* 패스워드 필드 */
	mname		varchar(10)	, /* 이름 필드 */
	mphone		varchar(15), /*  연락처 필드 */
	memail		varchar(50), /*  이메일 필드 */
	maddress	varchar(1000), /*  주소 필드 */
	mpoint		int			default 0, /* 포인트(초기값 0 ) 필드 */
	mdate		datetime	default now() /* 가입날짜( 초기값 : 현재날짜/시간 ) 필드 */
);