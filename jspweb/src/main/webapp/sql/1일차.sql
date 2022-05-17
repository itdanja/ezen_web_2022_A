-- DB : 데이터베이스 -> 데이터(자료) 베이스(집합/모임) -> 자료 모임
-- DBMS : 데이버베이스 관리 시스템
	-- MYSQL -- Oracle -- MongoDB -- MariaDB
    -- SQL 문법 
		-- DDL[ Data Definition L
			-- create 	스키마 혹은 테이블 생성
				/*
					create table 테이블( 
						필드명 자료형 속성명 , 
                        필드명2 자료형 속성명 
					);
                */
            -- alter	스키마 혹은 테이블 수정 
            -- drop		스키마 혹은 테이블 삭제
            -- rename	스키마 혹은 테이블 이름 변경 
            -- truncate	데이터가 모두 지우기 
		-- DML
			-- select 	레코드 검색 
            -- insert 	레코드 추가 
            -- update  	레코드 수정 
            -- delete  	레코드 삭제 
        -- DCL
			-- grant : 계정 권한 부여 
            -- revoke : 계정에 권한 해제 
		-- TCL 
			-- commit : 작성된 명령어 실행 / 저장 
            -- rollback : 실행된 명령어 취소 
            -- savepoint : 명렁어 이름 저장 
	-- 연산자 
		-- 산술연산자 		+더하기 -빼기 *곱하기 /나누기 
        -- 비교연산자 		>=이상 <=이하 >초과 <미만 ==같다 	!=,<> : 같지않다 
        -- 논리연산자 		and or  not
		-- like 연산자 	: 일치하는 문자 패턴 검색 
        -- null연산자 	: null 검색 
        -- in연산자 		: 리스트에 포함된 데이터 검색 
        -- between and 연산자 : 데이터 사이 값 검색 

-- DBA : 데이터베이스 관리자 

-- 용어
	-- 필드 : 세로단위 = 속성 = 열 [ COLUMN ] 
	-- 레코드 : 가로단위 = 튜플 = 행 [ ROW ] 
-- 단축키 
	-- ctrl+엔터 : 명령어( 커서위치기준 ) 한줄씩 실행 
    -- ctrl+ (+/-) : 화면 확대/축소
-- SQL 작성시 
	-- 문자처리 ' ' 
    -- 날짜처리 '연도/월/일'
    -- 숫자처리
-- 한줄석
/* 여러줄 주석 */

CREATE TABLE EMP( -- 직원테이블 
-- CREATE  : 생성한다.-- TABLE : 테이블 -- EMP : EMP [ 테이블 이름 = 임의의 값 ] 
    EMPNO INT NOT NULL , -- 번호 -- 필드명 자료형 속성
	ENAME VARCHAR(10) ,  -- 이름
	JOB	VARCHAR(9) ,	-- 직업 
	MGR INT  , 			-- 직업코드 
	HIREDATE DATE ,		-- 등록일 
	SAL INT  ,			-- 월급 
	COMM INT  ,			-- 보너스 
	DEPTNO INT 			-- 부서코드 
);

INSERT INTO EMP VALUES(7839,'KING','PRESIDENT',NULL,'81-11-17',5000,NULL,10);
INSERT INTO EMP VALUES(7698,'BLAKE','MANAGER',7839,'81-05-01',2850,NULL,30);
INSERT INTO EMP VALUES(7782,'CLARK','MANAGER',7839,'81-05-09',2450,NULL,10);
INSERT INTO EMP VALUES(7566,'JONES','MANAGER',7839,'81-04-01',2975,NULL,20);
INSERT INTO EMP VALUES(7654,'MARTIN','SALESMAN',7698,'81-09-10',1250,1400,30);
INSERT INTO EMP VALUES(7499,'ALLEN','SALESMAN',7698,'81-02-11',1600,300,30);
INSERT INTO EMP VALUES(7844,'TURNER','SALESMAN',7698,'81-08-21',1500,0,30);
INSERT INTO EMP VALUES(7900,'JAMES','CLERK',7698,'81-12-11',950,NULL,30);
INSERT INTO EMP VALUES(7521,'WARD','SALESMAN',7698,'81-02-23',1250,500,30);
INSERT INTO EMP VALUES(7902,'FORD','ANALYST',7566,'81-12-11',3000,NULL,20);
INSERT INTO EMP VALUES(7369,'SMITH','CLERK',7902,'80-12-11',800,NULL,20);
INSERT INTO EMP VALUES(7788,'SCOTT','ANALYST',7566,'82-12-22',3000,NULL,20);
INSERT INTO EMP VALUES(7876,'ADAMS','CLERK',7788,'83-01-15',1100,NULL,20);
INSERT INTO EMP VALUES(7934,'MILLER','CLERK',7782,'82-01-11',1300,NULL,10);

-- SELECT --
-- 예1) 필드 검색 
-- SELECT 필드명1,필드명2,필드명 FROM 테이블명 
SELECT empno , ename , sal FROM EMP;
-- *(와일드 = 모든 필드 )
SELECT * FROM EMP; 
SELECT empno , ename , job , mgr , hiredate , sal , comm , deptno from emp;

-- 예2) as : 필드 별칭[별명] as 화면에 표시되는 이름
select empno as 사원번호 from emp;

-- 예3) distinct : 필드의 데이터 중복제거 
select distinct job as 직업 from emp;

-- 예4) order by : 정렬 [ order by 필드명 asc/desc , 필드명 asc/desc ] 
	-- 하위 정렬은 상위 정렬이 동일한 경우가 있을경우 적용
select ename , sal from emp order by sal asc; 
	-- 월급 기준으로 오름차순 하고 이름과 월급 검색 
select deptno ,  ename , sal from emp order by deptno asc , sal desc;
	-- 부서코드 기준으로 오름차순 정렬하되 
    -- 동일한 부서코드가 있을경우 동일한 부서코드내에서 월급을 내림차순 정렬후 검색 
select empno , sal from emp order by empno asc , sal desc;

-- 예5) where : 조건 
	-- where 필드명 연산자 [ O ] 
    -- where 별칭 [ x ]
select ename , sal from emp where sal >=3000;
select ename as 이름 , sal as 월급 from emp where 월급 >= 3000; -- 오류[ 별칭으로 조건 X ]
	-- 연산 조건 [ O ]
select ename , sal * 12 as 연봉  from emp where sal*12 >= 36000;
	-- 날짜 비교연산자 [ O ]
select ename , hiredate from emp where hiredate = '81/11/17';
select ename , hiredate from emp where hiredate >= '81/11/17';

select * from emp where sal between 1000 and 3000;  /* 월급이 1000~3000 인 */
select * from emp where sal >=1000 and sal <=3000;
	-- between and  vs and 
select * from emp where sal not between 1000 and 3000; /* 월급이 1000~3000 제외한 */
select * from emp where sal <1000 or sal >3000;
	-- between and  vs and 
select * from emp where hiredate between '1982/01/01' and '1982/12/31';
select * from emp where hiredate >= '1982/01/01' and hiredate <='1982/12/31';
	-- in vs or 
select * from emp where job in('SALESMAN' , 'ANALYST' , 'MANAGER' );
select * from emp where job ='SALESMAN' or job = 'ANALYST' or job = 'MANAGER' ;

select * from emp where job not in('SALESMAN' , 'ANALYST' , 'MANAGER' );
select * from emp where job !='SALESMAN' and job != 'ANALYST' and job != 'MANAGER' ;

-- like : 문자 패턴 찾기 
	-- % : 모든 문자 대응 
	-- _ : _ 개수만큼 문자 대응 
select * from emp where ename = 'SCOTT';	-- SCOTT 이름 검색 
select * from emp where ename like 'SCOTT';	-- SCOTT 이름 검색 
select * from emp where ename like 'S%';	-- S로 시작하는 이름 검색
select * from emp where ename like 'S_';	-- S로 시작하는 이름 두글자 검색 
select * from emp where ename like '%S';	-- S로 끝나는 이름 검색 
select * from emp where ename like '%S%';	-- S가 포함된 이름 검색 
select * from emp where ename like '_S%';	-- 두번째 글자가 S 인 이름 검색 
-- NULL
select * from emp where comm = NULL; -- [ null 비교연산자 불가능 ]
select * from emp where comm is null;	-- null 찾기 
select * from emp where comm is not null; -- null 아닌 찾기 
-- 문자열 함수[ sql 내장 함수 = 기본적으로 제공해는 미리 만들어진 함수 ]
	-- upper( 필드명 ) : 해당 필드의 데이터 대문자로 변환 
    -- lower( 필드명 ) : 해당 필드의 데이터 소문자로 변환 
    -- substr( '문자열' , 시작인덱스 , 개수 ) : 문자열 자르기 
    -- length( '문자열') : 문자열 길이 [ 한글:3바이트 / 영문:1바이트 ]
    -- instr( '문자열' , '찾을문자' ) : 해당 문자열내 찾을문자의 인덱스순서 번호 
select upper(ename) , lower(ename) from emp;
select * from emp where ename = 'scott';	-- mysql 대소문자 X   vs  oracle 대소문자 O
-- dual : 임시 테이블 -> 연산 결과만 임시로 확인할수 있는 테이블 [ 영구저장 x ]
select substr('대한민국' , 1, 3) from dual ;
-- length()
select length('대한민국') from dual;	-- 결과 : 12 [ 한글 3바이트 ] 
select length('smith') from dual;	-- 결괴 : 5  [ 영문 1바이트 ]
-- instr( '문자열' , '찾을문자' ) : 해당 문자열내 찾을문자의 인덱스순서 번호 
select instr('대한민국' , '대') from dual; -- 결과 : 1 
select instr('smith' , 'i') from dual;	-- 결과 : 3 
-- trim('문자열') : 해당 문자열의 앞뒤 공백 제거  
-- rtrim('문자열') : 해당 문자열 오른쪽 공백 제거 
-- ltrim('문자열') : 해당 문자열 왼쪽 공백 제거 
select trim('        대       한       민     국      ') from dual;
select rtrim('       대       한       민     국      ') from dual;
select ltrim('       대       한       민     국      ') from dual;

select substr('asdasd@naver.com' , instr('asdasd@naver.com','@')  ) from dual;
			-- substr( '이메일' , @위치[instr('이메일','@') 
-- replace('문자열','기존문자','새로운문자') : 치환 [ 데이터 교체 ]
select ename , replace( sal , 0 , '*' ) from emp;

