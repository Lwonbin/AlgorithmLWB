select h.HOUR AS HOUR, COUNT(ANIMAL_ID) as COUNT from 

(select 0 hour UNION ALL select 1 UNION ALL select 2 UNION ALL select 3 UNION ALL select 4 UNION ALL select 5 UNION ALL select 6 UNION ALL select 7 UNION ALL select 8 UNION ALL select 9 UNION ALL select 10 UNION ALL select 11 UNION ALL select 12 UNION ALL select 13 UNION ALL select 14 UNION ALL select 15 UNION ALL select 16 UNION ALL select 17 UNION ALL select 18 UNION ALL select 19 UNION ALL select 20 UNION ALL select 21 UNION ALL select 22 UNION ALL select 23) h
left join ANIMAL_OUTS B on h.hour = HOUR(B.DATETIME)

GROUP BY HOUR

order by HOUR

; 