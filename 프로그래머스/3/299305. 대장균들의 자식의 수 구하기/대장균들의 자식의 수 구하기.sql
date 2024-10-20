-- 코드를 작성해주세요
select A.ID, count(B.PARENT_ID) AS CHILD_COUNT from ECOLI_DATA A left join ECOLI_DATA B on A.ID = B.PARENT_ID group by 1 order by A.ID;