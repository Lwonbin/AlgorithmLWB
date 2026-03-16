-- 코드를 입력하세요
SELECT A.Category as CATEGORY, sum(B.SALES) as TOTAL_SALES from BOOK A join BOOK_SALES B on A.BOOK_ID = B.BOOK_ID

where Year(B.sales_date) = '2022' AND MONTH(B.sales_date) = '01'

group by CATEGORY

order by CATEGORY

;