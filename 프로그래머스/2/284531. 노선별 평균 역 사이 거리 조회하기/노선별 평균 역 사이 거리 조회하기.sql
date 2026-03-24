-- 코드를 작성해주세요

select ROUTE, concat(round(sum(D_BETWEEN_DIST),1),"km") AS TOTAL_DISTANCE, concat(ROUND(avg(D_BETWEEN_DIST), 2), "km") as AVERAGE_DISTANCE from SUBWAY_DISTANCE

group by ROUTE

order by round(sum(D_BETWEEN_DIST),1) DESC