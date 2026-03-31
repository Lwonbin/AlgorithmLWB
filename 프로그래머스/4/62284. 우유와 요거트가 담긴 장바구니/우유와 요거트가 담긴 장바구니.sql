-- 코드를 입력하세요
SELECT A.CART_ID from CART_PRODUCTS A join CART_PRODUCTS B on A.CART_ID = B.CART_ID

where A.NAME = "MILK" AND B.NAME = "Yogurt"

group by A.CART_ID

order by A.CART_ID