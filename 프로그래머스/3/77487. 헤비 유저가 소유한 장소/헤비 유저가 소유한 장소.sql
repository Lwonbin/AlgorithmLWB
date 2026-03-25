-- 코드를 입력하세요
SELECT A.ID, A.NAME, A.HOST_ID from PLACES A join (select HOST_ID, count(*) as CNT from PLACES group by HOST_ID) B on A.HOST_ID = B.HOST_ID

where B.CNT >= 2

order by A.ID