prompt Importing table AREA_DEFINE...
set feedback off
set define off
delete from AREA_DEFINE where area_code = '130111';
insert into AREA_DEFINE (AREA_CODE, CITY_CODE, PROVINCE_CODE, COUNTRY_CODE, AREA_NAME, CREATED_USER, CREATED_DATE, UPDATED_USER, UPDATED_DATE, IS_VALID)
values ('130111', '130100', '130000', '156', '栾城区', 'shuping', to_date('01-04-2019 00:09:24', 'dd-mm-yyyy hh24:mi:ss'), 'shuping', to_date('01-04-2019 00:09:24', 'dd-mm-yyyy hh24:mi:ss'), 'Y');

prompt Done.
