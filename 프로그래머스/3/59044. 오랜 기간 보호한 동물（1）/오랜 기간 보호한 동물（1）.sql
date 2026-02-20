
select A.NAME as ANIMAL_NAME, A.DATETIME as DATETIME from ANIMAL_INS A left join ANIMAL_OUTS B 

on A.ANIMAL_ID = B.ANIMAL_ID

where B.ANIMAL_ID is null 

order by A.DATETIME

limit 3


;