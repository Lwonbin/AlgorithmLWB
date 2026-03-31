-- 코드를 입력하세요
SELECT DISTINCT(A.CART_ID) from CART_PRODUCTS A join (Select CART_ID, Name from CART_PRODUCTS) B on A.CART_ID = B.CART_ID

where A.NAME = "MILK" AND B.NAME = "Yogurt"
