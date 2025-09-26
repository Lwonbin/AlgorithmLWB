-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE from ANIMAL_INS where NAME in (select NAME from ANIMAL_INS 
    WHERE NAME = 'Lucy' OR NAME = 'Ella' OR NAME = 'Pickle'OR NAME = 'Rogan'OR NAME = 'Sabrina'OR NAME = 'Mitty')
    
    order by ANIMAL_ID