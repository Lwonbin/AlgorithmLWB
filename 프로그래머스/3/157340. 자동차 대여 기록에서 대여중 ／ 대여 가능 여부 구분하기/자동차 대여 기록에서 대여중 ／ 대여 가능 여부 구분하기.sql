-- 코드를 입력하세

select CAR_ID, CASE
    WHEN CAR_ID in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY where
                  '2022-10-16' between START_DATE AND END_DATE)
    THEN '대여중'
    ELSE '대여 가능' 
    END AS AVAILABILITY
    
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    GROUP BY CAR_ID
order by CAR_ID DESC;
