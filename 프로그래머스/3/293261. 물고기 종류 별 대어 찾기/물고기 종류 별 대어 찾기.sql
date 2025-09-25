-- 코드를 작성해주세요

select A.ID, B.FISH_NAME, A.LENGTH from FISH_INFO as A join FISH_NAME_INFO as B
on A.FISH_TYPE = B.FISH_TYPE

where LENGTH in (
    select MAX(LENGTH) from FISH_INFO where FISH_TYPE = A.FISH_TYPE
)

order by A.ID