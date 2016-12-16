variable rr refcursor

declare 
  bb varchar2(4000);
  cc varchar2( 30000 );
begin 
    WITH PIVOT_DATA AS (
         SELECT *
         FROM
         (
             SELECT STEP_NAME, START_TIME
             FROM FCT_RESULT U LEFT OUTER JOIN DIM_TEST_RUN R
             ON U.FKN_TESTRUN = R.RUN_ID
          )
    )
    select ''''|| listagg( START_TIME, ''',''' ) 
            within group( order by START_TIME ) || '''' as x 
    into bb
    from (
      select distinct START_TIME from pivot_data
    )
    ;

    cc := q'[
    WITH PIVOT_DATA AS (
         SELECT *
         FROM
         (
            SELECT STEP_NAME, START_TIME
             FROM FCT_RESULT U LEFT OUTER JOIN DIM_TEST_RUN R
             ON U.FKN_TESTRUN = R.RUN_ID
          )
    )
    SELECT *
    FROM PIVOT_DATA
    PIVOT
    (
        COUNT(START_TIME)
        FOR START_TIME
        IN(]'  || bb || q'[) -- Just an example
    )
    ORDER BY STEP_NAME ASC]';

    open :rr for cc;
end;
/

SET PAGESIZE 200
SET LINESIZE 16000
print :rr