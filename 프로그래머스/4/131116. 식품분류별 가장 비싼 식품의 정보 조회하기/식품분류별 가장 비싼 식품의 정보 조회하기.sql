select A.CATEGORY, A.PRICE as MAX_PRICE, A.PRODUCT_NAME from FOOD_PRODUCT A join (select CATEGORY, MAX(PRICE) as PRICE from FOOD_PRODUCT group by CATEGORY) B on A.CATEGORY = B.CATEGORY

where A.PRICE = B.PRICE AND A.CATEGORY in ("과자", "국", "김치", "식용유")

order by MAX_PRICE desc