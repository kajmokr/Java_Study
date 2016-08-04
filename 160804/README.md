﻿**[날짜 선택화면](../README.md)**

##SQL 연습

- 테이블 복사
create table emp as select * from EMPLOYEES;

select * from emp;

- 테이블 삭제
drop table emp;


##뷰

뷰를 사용하는 이유

1. 어떤 테이블 보여줘야하는데 어떤 컬럼은 보여주면 안됨
외부에 민감한 컬럼 데이터빼고 봐야할 컬럼만 포함해서 뷰를 만듬.

2. 여러개의 테이블을 조인해서 복잡한 쿼리로 만드는것보다 뷰를 만들어 뷰이름만 주어서 보게하는것.

CREATE OR REPLACE VIEW emp_dept_v1 AS  
SELECT a.employee_id, a.emp_name, a.department_id, 
       b.department_name  
  FROM employees a, 
       departments b
 WHERE a.department_id = b.department_id; 

기본키나 외래키 작성시 오라클은 자동으로 인덱스를 생성해준다.

##시노님(synonym)

시노님은 동의어라는 뜻이다.

public,private 부여가능.

SELECT * FROM SCOTT.DEPT;


grant create synonym to scott;

create or replace synonym emp2 for emp;

SELECT * FROM EMP2;

SELECT * FROM SCOTT.EMP2;

GRANT SELECT ON EMP2 TO HR;

PUBLIC SYNONYM

##시퀀스(sequence)

create sequence -> empno_seq 생성

insert into emp values(empno_seq.nextval,'홍길동','clerk',7782,sysdate,3000,null,10);
commit;

##머지(merge)

create table dooly(EMPLOYEE_ID number, bonus_amt number default 0);

insert into dooly(EMPLOYEE_ID) select EMPLOYEE_ID from EMPLOYEES where JOB_ID = 'SA_REP' and MANAGER_ID = 146;

commit;

select * from DOOLY;

--merge 한꺼번에 처리해야할 상황이다 하면 쓰면됨.
-- 6개 겹침 
-- 매칭되면 update, 아니면 insert

merge into dooly d 
      using(select EMPLOYEE_ID, SALARY,JOB_ID from EMPLOYEES ) e
      on (d.employee_id = e.employee_id)
    when matched then
      update set d.bonus_amt = d.bonus_amt + e.salary * 0.01
    when not matched then
      insert (d.employee_id, d.bonus_amt) values(e.employee_id, e.salary * 0.001) where e.job_id = 'SA_REP';


## 인라인뷰

select * from EMPLOYEES where rownum <= 5 order by SALARY desc;
-- 자르고 소팅함 -> 소팅하고 잘라야함.

-- sorting하고 나서 5건 가져온다.
-- from 절에 subquery가 오는것을 인라인뷰라 한다.
select * from (select * from employees order by salary desc) where rownum <= 5;

## IN, ANY

select EMPLOYEE_ID, SALARY from EMPLOYEES where SALARY IN(2000,3000,4000) order by EMPLOYEE_ID;
select EMPLOYEE_ID, SALARY from EMPLOYEES where SALARY = any(2000,3000,4000) order by EMPLOYEE_ID;

## NOT IN, <>ALL

select EMPLOYEE_ID, SALARY from EMPLOYEES where SALARY NOT IN(2000,3000,4000) order by EMPLOYEE_ID;
select EMPLOYEE_ID, SALARY from EMPLOYEES where SALARY <> all (2000,3000,4000) order by EMPLOYEE_ID;


##INNER JOIN(동등 조인(내부조인,inner join)

SELECT a.employee_id,
       a.FIRST_NAME,
       a.department_id,
       b.department_name,
       a.JOB_ID,
       j.JOB_TITLE,
       l.CITY
       
  FROM employees a,
       departments b, -- 107*27 = 2889  cartesian product 다 가져옴, 똑같은것만 가져와야한다.
       jobs j,
       LOCATIONS l
       
 WHERE a.department_id = b.department_id
   and a.JOB_ID = j.JOB_ID
   and b.LOCATION_ID = l.LOCATION_ID;
   
   select * from EMPLOYEES;
   select * from DEPARTMENTS;
   
   select * from JOBS;
  -- 사장은 번호가 없어서 못가져옴.
select count(*)
  from employees;
 
select count(*)
  from DEPARTMENTS;
 
##외부조인(outer join)

SELECT a.employee_id,
       a.FIRST_NAME,
       a.department_id,
       b.department_name,
       a.job_id,
       j.JOB_TITLE,
       l.CITY
  FROM employees a,
       departments b,
       jobs j,
       LOCATIONS l
 WHERE a.department_id = b.department_id(+)
   and a.JOB_ID = j.JOB_ID
   and b.LOCATION_ID = l.LOCATION_ID(+);
   
 select count(*)
  from employees;
 
select count(*)
  from DEPARTMENTS;