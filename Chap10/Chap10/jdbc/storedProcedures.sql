use test;

# ------------------------------------------
DROP PROCEDURE IF EXISTS getJob;

# Given empno, get the job
CREATE PROCEDURE getJob (IN param1 INT, OUT param2 VARCHAR(20))
SELECT job into param2 from emp where empno = param1; 

CALL getJob(7369, @job);
select @job;
