select P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE from MEMBER_PROFILE as P
join REST_REVIEW AS R on P.MEMBER_ID = R.MEMBER_ID

where P.MEMBER_ID in (
    select MEMBER_ID from REST_REVIEW
    group by MEMBER_ID
    having count(*) = (
        select max(cnt)
        from (select count(*) as cnt 
             from REST_REVIEW
              group by MEMBER_ID
             ) X
    )    
)

order by R.REVIEW_DATE, R.REVIEW_TEXT
