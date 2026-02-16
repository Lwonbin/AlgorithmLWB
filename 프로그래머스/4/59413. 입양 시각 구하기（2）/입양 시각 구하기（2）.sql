select h.hour as HOUR, count(b.DATETIME) as COUNT from(

select 0 hour union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9 union all select 10 union all select 11 union all select 12 union all select 13 union all select 14 union all select 15 union all select 16 union all select 17 union all select 18 union all select 19 union all select 20 union all select 21 union all select 22 union all select 23) h left join ANIMAL_OUTS B on h.hour = HOUR(b.DATETIME)


group by HOUR
order by HOUR;