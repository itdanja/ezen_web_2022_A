create table category(
	cno int primary key auto_increment ,  /* 카테고리 번호 */
    cname varchar(100) /* 카테고리 이름 */
);
create table product(
	pno int primary key auto_increment , /* 제품 번호 */
    pname varchar(1000) ,  /* 제품 명 */
    pprice int ,  /* 제품 가격 */
    pdiscount float ,  /* 제품 할인율 = float = 실수 자료형*/
    pactive int default 0,  /* 제품 상태 [ 0:준비중(기본값)  1:판매중  2:재고준비중 */
	pimg varchar(1000) ,  /* 제품 이미지 */
    cno int , /* 제품 카테고리 */
    foreign key( cno ) references category(cno) on update cascade 
    /*  product의 cno필드(fk)가 category의 cno(pk) 와 참조(연결)한다 */
    /* on update cascade : pk 레코드가 수정 되면 fk 레코드 도 같이 수정된다 */
);

create table stock( 
	sno int primary key auto_increment , /* 재고 번호 */
    scolor varchar(100) ,  /* 재고 색상 */
    ssize varchar(100) ,   /* 재고 색상 */
    samount int ,   /* 재고 수량 */
    firstdate datetime default now(),   /* 재고 최초등록일 */
	updatedate datetime default now() on update now(),  /* 재고 최근수정일 */
    pno int ,  /* 제품 번호 */
    foreign key( pno ) references product(pno) on delete cascade
    /* 레코드가 변경되면 자동으로 현재날짜를 부여 */
    /* default : 값이 안들어왔을때 초기값 설정 */
    /* on update : 레코드가 변경 되었을때 값 설정 */ 
    /* on delete cascade : pk 레코드가 삭제 되면 fk 레코드 도 같이 삭제된다 */
);

/* 한 명령어( ; 기준 = 커서위치 ) 씩 실행단축키 = ctrl+엔터 */



select pno , pimg from product;
/* pno 와 pimg 표시 */

select * from product;
 /* 모든 필드 표시 */

select * from product where pprice >= 20000; 
/* 가격이 2만원이상인 레코드 검색( 모든필드 표시 ) */

select pname from product where pprice >=20000 and pprice <30000;
/* 가격이 2만원대 인 레코드 검색 ( 제품이름만 표시 )*/

select * from product order by pprice desc; 
/* 가격 내림차순 모든 필드 검색*/

select * from product order by pprice desc limit 0 , 3 ;  
/* 가격이 상위 3개 검색 */

select * from product group by cno;
/*카테고리가 동일하면 레코드 그룹 */

select * , count(*) as categorycount from product group by cno;
/* 모든필드 표시 , 그룹개수 표시  */

select * from product join stock on product.pno = stock.pno;
/* 제품 테이블과 재고 테이블 조인  */

/* DML
	select : 검색
		select 필드명1 필드명2 from 테이블 : 특정 필드를 검색
        select * from 테이블 : 모든 필드를 검색 
        select 새로운필드명 as 별칭명 from 테이블
			as : 별칭 ( 해당 필드명을 별명으로 표시 하기 )
    insert : 추가 
		insert into 테이블명 values( 값1 , 값2 , 값3 )
    update : 수정
		update 테이블명 set 필드명1 = 값1 , 필드명2 = 값2 
    delete : 삭제 
		delete from 테이블 ;
	
    조건 : where 필드명 = 값 
		and / or 
    정렬 : order by 필드명 asc / desc
    제한 : limit 시작인덱스 , 개수 
    그룹 : group by 필드명 
    조인 : 두개 이상의 테이블 합치기 [ 필수조건 : 동일한 데이터 존재 ]
			select * from 테이블명1 join 테이블명2 ;
			select * from 테이블명1 join 테이블명2 on 테이블명1.pk = 테이블명2.fk; 		
    
    SQL함수 
		// 집계 함수
		count( 필드명 ) : 해당 필드의 레코드 개수 [ NULL 제외 ]  
        count( * ) : 레코드 개수  [ NULL 포함 ] 
        sum( 필드명 ) : 합계
        avg( 필드명 ) : 평균
        max( 필드명 ) : 최댓값
        min( 필드명 ) : 최솟값 
/*	










