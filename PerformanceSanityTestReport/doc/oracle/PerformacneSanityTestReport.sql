select aa.step_name, BB.START_TIME, avg(aa.response_time) ART from FCT_RESULT aa inner join DIM_TEST_RUN bb
on aa.fkn_testrun = BB.RUN_ID
group by (BB.START_TIME), aa.step_name
order by  BB.START_TIME, aa.step_name;

--Oracle 行转列
select * from (select step_name, response_time, FKN_TESTRUN from FCT_RESULT)
pivot (avg(response_time) avg_responseTime for (FKN_TESTRUN) in (1,2,3,4,5,6,7,8 ))


--Oracle 查询结果转成字符串
select wmsys.wm_concat(run_id) from DIM_TEST_RUN
select listagg(run_id,',') within group (order by rownum) from  DIM_TEST_RUN

-- Oracle中把逗号分割的字符串转换为可放入in的条件语句的字符数列 
select regexp_substr('1,2,3,4','[^,]+', 1, level) from dual connect by regexp_substr('1,2,3,4', '[^,]+', 1, level) is not null  

select regexp_substr((select listagg(run_id,',') within group (order by rownum) from  DIM_TEST_RUN),'[^,]+', 1, level) from dual  
connect by regexp_substr((select listagg(run_id,',') within group (order by rownum) from  DIM_TEST_RUN), '[^,]+', 1, level) is not null  

--将表的列转化成字符串，然后转换为可放入in的条件语句的字符数列 
select * from FCT_RESULT where FKN_TESTRUN in (select regexp_substr('1,2,3,4','[^,]+', 1, level) from dual connect by regexp_substr('1,2,3,4', '[^,]+', 1, level) is not null  )


             SELECT STEP_NAME, START_TIME
             FROM FCT_RESULT U LEFT OUTER JOIN DIM_TEST_RUN R
             ON U.FKN_TESTRUN = R.RUN_ID
             
             
 --COLSANITYTEST 求transaction的平均时间
 select aa.start_date, aa.transaction_name, avg(aa.time) average_response from (
 select * from COLSANITYTEST
 where started is NULL) aa
 group by aa.transaction_name, aa.start_date
 order by START_date
 

