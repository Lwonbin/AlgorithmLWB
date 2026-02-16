-- 코드를 입력하세요
SELECT HOUR(DATETIME) as HOUR, count(*) as COUNT from ANIMAL_OUTS

where HOUR(DATETIME) >= '09' AND HOUR(DATETIME) < '20' 

group by HOUR
order by HOUR
;