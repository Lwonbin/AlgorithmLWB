-- 코드를 작성해주세요

select C.ITEM_ID, C.ITEM_NAME, C.RARITY from
ITEM_INFO as A join ITEM_TREE as B on B.PARENT_ITEM_ID = A.ITEM_ID

join ITEM_INFO as C ON C.ITEM_ID = B.ITEM_ID

where A.RARITY = 'RARE'

order by B.ITEM_ID DESC;