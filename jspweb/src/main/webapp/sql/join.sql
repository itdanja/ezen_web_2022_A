/* 개인별 장바구니내 제품별 정보 */
-- 1. 개인별 장바구니 [ 장바구니번호 , 수량 , 가격 , 재고번호 , 회원번호 ] 
select * from cart where mno = 2; -- 회원번호 2번의 장바구니 
-- 2. 장바구니번호 별 제품 정보( 색상 , 사이즈 ) 
select * from stock where sno = 33; -- 재고번호 33번의 정보( 색상 , 사이즈 )
-- 3. table 합치기(  cart테이블 stock테이블 -> join  )
select * from cart join stock;
-- 4. 동일한 데이터의 table 합치기 
select * from cart join stock on sno = sno ; -- on 필드명이 동일한경우 오류
select * from cart A join stock B on A.sno = B.sno ; -- 테이블명 별칭 
-- 5. 특정 회원의 장바구니 테이블과 재고 테이블의 join 결과  
select * from cart A join stock B on A.sno = B.sno where mno = 2 ;
-- 6. 특정 필드 표시 [ 장바구니 view 에서 사용할 필드만 빼오기 ] 
select 
	A.cartno as 장바구니번호 , 		/* A  : cart테이블 */
    A.samount as 구매수량 , 
    A.totalprice as 총가격 , 
    B.scolor as 색상 , 				/* B  : stock테이블 */
    B.ssize as 사이즈 ,
    B.pno as 제품번호 
from cart A 
join stock B
on A.sno = B.sno 
where mno = 2;

-- 7. 2개 테이블 조인 
select * from cart A join stock B on A.sno = B.sno;
-- 8. 3개 테이블 조인
select * from cart join stock join product;
-- 9. 3개 테이블 조인내 동일한 재고번호 이면서 동일한 제품번호 이면
select * from cart A join stock B on A.sno = B.sno join product C on B.pno = C.pno ;
-- 10. 제품명과 제품이미지도 추가로 가져오기
select 
	A.cartno as 장바구니번호 , 		
    A.samount as 구매수량 , 
    A.totalprice as 총가격 , 
    B.scolor as 색상 , 			
    B.ssize as 사이즈 ,
    B.pno as 제품번호 ,				
    C.pname as 제품명 , 
    C.pimg as 제품이미지
from cart A 
join stock B 
on A.sno = B.sno 
join product C 
on B.pno = C.pno
where A.mno = 2;







