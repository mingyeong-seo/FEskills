-- 조건 함수 DECODE:DECODE(표현식, search1, result1, search2, result2.... 35개까지 나열, default_result)
SELECT sysdate from dual;

SELECT employee_id, first_name || ' ' || last_name 이름,
DECODE(round((sysdate - hire_date)/365),
        10,'10년 근속함',
        15,'15년 근속함',
        20, '20년 근속함',
    round((sysdate - hire_date)/365)) 근속년수
from employees;

-- CASE: 함수보다는 표현식에 가까움,, DECODE보다 좀 더 확장된 형태의 조건을 나열할 수 있음
-- case 대상값 when 비교값 then 처리1,
--             when 비교값 then 처리2,
--                else 디폴트 처리
-- END

-- distinct : 중복 제거 키워드,, 컬럼의 중복 데이터를 제거해서 하나의 데이터만 표현해준다., 
-- null은 제외된다 
-- select distinct 컬럼명 from 테이블명
select distinct employee_id from employees;
select distinct department_id from employees;
select all department_id from employees;

-- 집계함수인 count
-- count({distinct, all}) :  갯수를 집계해서 리턴하는 함수
-- 전체 사원의 명수를 구해보자
select count(*) from employees;
select count(distinct employee_id), count(distinct first_name) from employees; 
select count(department_id), count(distinct department_id) from employees;

-- sum({distinct});
-- 모든 사원의 총 월급 합계를 구해보자
SELECT SUM(SALARY) FROM employees;
-- 같은 급여를 받는 사람을 제외한 SUM을 구해보세요.
SELECT SUM(DISTINCT(SALARY)), sum(salary) FROM employees;

-- min max
SELECT MAX(SALARY), MIN(SALARY) FROM EMPLOYEES;

-- 최대 급여를 받는 사람과 최소 급여를 받는 사람의 ID, 이름을 조회해라
SELECT EMPLOYEE_ID, first_name, job_id, salary from employees
where salary in(24000,2100);
-- where절에는 그룹함수가 올 수 없다.

-- avg({distinct}): 평균
select round(avg(salary)) from employees;

-- GROUP BY 절: ROW를 같은 값을 가진 그룹으로 묶은 후 조회에 사용하는 쿼리이다.
-- 이때 같이 사용하는 게 집게 함수들이다. 
-- Group by절은 from 절 다음에 위치한다. 
SELECT department_id 
from employees
GROUP BY department_id;

-- 부서별로 급여 총액을 알고 싶다.
SELECT department_id,SUM(SALARY)
FROM employees
GROUP BY department_id;

-- 부서별 사원수, 평균 급여를 구해라 
SELECT department_id, COUNT(department_id), AVG(SALARY)
FROM employees
GROUP BY department_id;

-- SELECT 절에서 GROUP BY 절을 사용시에는, SELECT 리스트에 있는 항목 중 집계 함수를 제외하고는 
-- 모든 항목이 GROUP BY 절에 명시되어야 한다. 꼭 기억해라


-- 위 쿼리를 기준으로 부서별 직급별(job_id), 월급 내역을 조회해라.
SELECT department_id, sum(salary), count(salary), avg(salary), job_id
FROM employees
GROUP BY department_id, job_id;

-- group by where: 그룹을 묶은 후에 조건을 나열 할 수 있다
-- SELECT
--     FROM
-- WHERE
-- ORDER BY

-- 월 급여가 가장 높은 부서의 총 급여액, 평균값을 구해라
-- 부서별 최대 급여 구하기
-- 최고 월급 구하기
SELECT MAX(SALARY)
FROM EMPLOYEES;

-- 그 최고 월급을 가진 직원의 부서 찾기, 총 급여액, 평균 구하기
SELECT department_id, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEES
WHERE department_id = (
    SELECT department_id
    FROM EMPLOYEES
    WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES)
)
GROUP BY department_id;

-- 수업 코드
SELECT department_id, MAX(salary) from employees group by department_id;

select job_id, sum(salary), avg(salary) from employees where department_id = 90
group by job_id
order by job_id;

-- 현재 어느 부서에 몇 명의 사원들이 속해서 근무하고 있는지를 조회해라
-- 부서를 기준으로 정렬시키세요.
SELECT department_id, count(*)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY department_id;

-- 위 쿼리를 기준으로 부서에 소속된 사원 수가 5명 미만인 부서만 조회하기 
SELECT department_id, count(*)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
-- 그룹으로 묶인 데이터에 그룹 조건을 사용시에는 반드시 HAVING을 사용해야 한다
HAVING count(*) < 5
ORDER BY department_id;

-- sub Query: 쿼리에 쿼리를 넣는것.. 국제 표준이므로 잘 알고 있어야한다
-- 전체 사원들 중 평균 급여보다 낮은 급여를 받는 사람들의 명단을 받고 싶다
SELECT round(AVG(SALARY))
FROM employees;

SELECT employee_id, salary, first_name
FROM employees
WHERE SALARY < (SELECT ROUND(AVG(SALARY)) FROM employees);

select * from locations;

-- 주(state)가 없는 도시에 위치한 부서의 모든 정보를 조회하라

select location_id 
from locations
where state_province IS NULL;

SELECT * FROM departments where location_id in (select location_id from locations
where state_province IS NULL);

-- 서브 쿼리의 결과가 단일 로우, 단일 컬림인 경우
-- 대부분 집계 함수가 포함된 경우가 많음,, 이러한 경우는 보통 where절에 조건의 비교값으로
-- 사용되는 경우가 대부분이다. 같이 사용되는 연산자도 <,>,=... 등 일반 연산자를 많이 사용한다.

-- 월급을 가장 많이 받는 사원의 정보를 조회 해보세요
SELECT *
FROM employees
WHERE salary = (
    SELECT MAX(salary)
    FROM employees
);

SELECT first_name, job_title from employees e, jobs job
WHERE e.salary = (SELECT MAX(salary) FROM employees)
AND e.job_id = job.job_id;

-- 미국 내에서 근무하는 사원들에 대한 평균 급여보다 많은 급여를 받는 사원들을 조회하라
SELECT *
FROM LOCATIONS
WHERE country_id = 'US';

SELECT  e.first_name 
FROM employees e
JOIN departments d 
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
JOIN jobs j
ON e.job_id = j.job_id
WHERE e.salary > (select AVG(salary) FROM employees)
AND l.country_id = 'US';

SELECT AVG(emp.salary)
FROM employees emp, departments dept, locations loc
WHERE emp.department_id = dept.department_id
AND dept.location_id = loc.location_id
AND loc.country_id = 'US';

-- 이처럼 단일 컬럼, 단일 로우를 리턴하는 서브 쿼리는 아래의 절에도 올 수 있다.
-- FROM 절, SELECT, ORDER BY 절, HAVING 절

-- 다중 로우, 단일 컬럼을 리턴하는 서브쿼리에 대해서 알아보자. 
-- 부서가 30번인 사원들의 월급을 조회해라 
-- 위 결과를 기준으로 이 사원들 보다 급여를 많이 받는 사람들의 정보를 조회하라고 했을땐?
SELECT salary
FROM employees
WHERE department_id = 30;

SELECT salary, first_name
FROM employees
WHERE salary > ALL (SELECT salary FROM employees WHERE department_id = 30);

-- ALL(모든값보다큼)은 최대값 기준, ANY(하나라도 큼)는 최소값 기준 

-- 평균 급여보다 높고 최대 급여보다 낮은 월급을 받는 사원 리스트를 작성하라
SELECT salary, first_name
FROM employees e
WHERE e.salary > (
    SELECT AVG(salary)
    FROM employees)
AND e.salary < (
    SELECT MAX(salary)
    FROM employees)
ORDER BY e.salary desc;

SELECT a.employee_id, a.first_name, a.salary
FROM employees a, 
(SELECT AVG(salary) avgs, MAX(salary) maxs FROM employees) b
WHERE a.salary BETWEEN b.avgs AND b.maxs
ORDER BY a.salary desc;

-- 월급을 가장 많이 받는 사람을 상위 10명만 리스트업 해보자 
SELECT * 
FROM (
SELECT first_name,salary
FROM employees
ORDER BY salary desc
)
WHERE ROWNUM < 11;
