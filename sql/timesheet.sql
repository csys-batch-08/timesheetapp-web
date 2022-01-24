
CREATE TABLE USER_DETAILS
(USER_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
FIRST_NAME VARCHAR2(50) NOT NULL,
LAST_NAME VARCHAR2(50) NOT NULL,
USER_NAME VARCHAR2(100) NOT NULL,
PASSWORD VARCHAR2(50) NOT NULL,
ROLE VARCHAR2(15) DEFAULT 'TEAM MEMBER',
CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
UNIQUE(USER_NAME),
CONSTRAINT PK_USER_DETAILS PRIMARY KEY (USER_ID));

DESC USER_DETAILS;


--DROP TABLE USER_DETAILS cascade constraints;
--DROP TABLE USER_DETAILS;

INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,ROLE)VALUES('DHARSHAN','RAVI','dharshanravi@gmail.com','Dharshan03@','ADMIN');
INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,ROLE)VALUES('PRIYA','RAVI','priyaravi@gmail.com','Priya24#','ADMIN');

--DELETE USER_DETAILS WHERE user_id=2;

SELECT * FROM USER_DETAILS order by user_id;

select * from user_details;

CREATE TABLE TASK_DETAILS(
TASK_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USER_ID NUMBER NOT NULL,
CONSTRAINT FK_TASK_DETAILS_USER_DETAILS FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID),
TASK_NAME VARCHAR2(50)NOT NULL,
ASSIGNED_TO_DATE DATE  NOT NULL,
END_DATE DATE  NOT NULL,
TASK_PRIORITY VARCHAR2(18)NOT NULL,
ASSIGNED_TO VARCHAR2(50)NOT NULL,
CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
CONSTRAINT PK_TASK_DETAILS PRIMARY KEY (TASK_ID));

alter table task_details add total_working_hrs number not null; 

select first_name,last_name,user_name,role from user_details where role not in('ADMIN','IN ACTIVE');

SELECT * FROM USER_DETAILS order by user_id;
select * from task_details;
select * from timesheets;
commit;
--delete from task_details where task_name='Book order DB design 2';
--delete from timesheets where timesheet_id=84;
DESC TASK_DETAILS;
select  floor(sysdate - to_date('2021-12-31', 'yyyy-mm-dd'))as no_of_days from dual;

select floor((end_date) - to_date(sysdate))as no_of_days from task_details where task_id=43;

select total_hours from task_details where task_name='Timesheet-Ui design' and assigned_to='vishaliravi@gmail.com';

select * from timesheets;
select * from task_details order by assigned_to_date desc;
commit;
update task_details set total_hours=64 where task_name='Java Training';
update task_details set total_hours=38 where task_id=1;
commit;
create table demo(Ass_date date ,end_date date
,no_of_days number);
insert into demo (Ass_date,end_date,no_of_days) values('31-12-21','06-01-22',(select floor((end_date) - to_date(Ass_date))as no_of_days from demo ));
select floor(('06-01-22') - to_date('31-12-21'))as no_of_days from dual;
alter table task_details  add total_hours number ;
select * from demo;

select (to_date(assigned_to_date,'dd')-to_date(end_date,'dd'))as noofdays from task_details where task_id=43;

--select extract(day from sysdate - to_date('2009-10-01', 'yyyy-mm-dd')) from dual;

--DROP TABLE TASK_DETAILS;

select * from task_details;
select * from timesheets;
CREATE TABLE TIMESHEETS(
TIMESHEET_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USER_ID NUMBER NOT NULL,
CONSTRAINT FK_TIMESHEETS_USER_DETAILS FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID),
TASK_ID NUMBER NOT NULL,
CONSTRAINT FK_TIMESHEETS_TASK_DETAILS FOREIGN KEY(TASK_ID) REFERENCES TASK_DETAILS(TASK_ID),
SPEND_TIME_HRS NUMBER NOT NULL,
COMMENTS VARCHAR2(200) NOT NULL,
TIMESHEET_FOR_DATE DATE NOT NULL, 
TIMESHEET_UPDATE_DATE DATE DEFAULT SYSDATE NOT NULL,
CONSTRAINT PK_TIMESHEETS PRIMARY KEY (TIMESHEET_ID)
);

alter table timesheets add timesheet_status varchar2(15) default ('Active');

select ud.user_name,ts.comments,ts.spend_time_hrs,ts.timesheet_for_date,ts.task_id,ts.timesheet_id from timesheets ts 
inner join user_details ud on ts.user_id=ud.user_id;
--DROP TABLE TIMESHEETS;
DESC TIMESHEETS;

CREATE TABLE STATUS(
STATUS_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
USER_ID NUMBER NOT NULL,
CONSTRAINT FK_STATUS_USER_DETAILS FOREIGN KEY(USER_ID) REFERENCES USER_DETAILS(USER_ID),
TIMESHEET_ID NUMBER NOT NULL,
CONSTRAINT FK_STATUS_TIMESHEETS FOREIGN KEY(TIMESHEET_ID) REFERENCES TIMESHEETS(TIMESHEET_ID),
STATUS VARCHAR2(50) DEFAULT ('NOT APPROVED') NOT NULL,
APPROVED_BY VARCHAR2(100),
STATUS_UPDATE_DATE  DATE DEFAULT SYSDATE NOT NULL,
CONSTRAINT PK_STATUS PRIMARY KEY(STATUS_ID)
);
select * from status;
select * from status where status='rejected';
commit;
select * from timesheets;
select * from status inner join timesheets on status.timesheet_id=timesheets.timesheet_id where status='rejected';

select td.task_name,s.timesheet_id,ts.timesheet_for_date,ts.spend_time_hrs,ts.comments,s.status,s.approved_by from status s 
inner join timesheets ts on s.timesheet_id=ts.timesheet_id 
inner join task_details td on td.task_id=ts.task_id 
where status='rejected' and td.assigned_to='keerthanaguru@gmail.com';

select t.timesheet_id,t.task_id,t.timesheet_for_date,t.spend_time_hrs,t.comments,s.status
from status s inner join timesheets t
on s.timesheet_id=t.timesheet_id where status='rejected';

select * from user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id inner join status s on ts.timesheet_id=s.timesheet_id;  

select * from user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id inner join status s on ts.timesheet_id=s.timesheet_id where ts.timesheet_for_date='23-12-2021';

select u.user_name,u.role,td.task_name,ts.timesheet_id,ts.spend_time_hrs,ts.timesheet_for_date,s.status,s.approved_by,s.status_update_date 
from user_details u 
inner join task_details td on u.user_id=td.user_id 
inner join timesheets ts on td.task_id=ts.task_id 
inner join status s on ts.timesheet_id=s.timesheet_id where ts.timesheet_for_date=to_date('23-12-2021','dd-MM-yyyy') and u.user_name='keerthanaguru@gmail.com'; 

commit;
--drop table status;
--delete from timesheets where timesheet_id=83;
commit;
select * from task_details;
delete from status where status_id=5;
select * from timesheets;
select * from task_details;

DESC USER_DETAILS;
DESC task_details;
DESC TIMESHEETS;
DESC STATUS;

COMMIT; 

select distinct ud.user_name,ts.comments,ts.spend_time_hrs,ts.timesheet_for_date,ts.task_id,ts.timesheet_id,s.status from timesheets ts 
inner join user_details ud on ts.user_id=ud.user_id 
left join status s on s.user_id=ud.user_id;

select distinct ud.user_name,ts.comments,ts.spend_time_hrs,ts.timesheet_for_date,ts.task_id,ts.timesheet_id,NVL(s.status,'Not Approved')as status
from status s 
right join timesheets ts on s.timesheet_id=ts.timesheet_id 
inner join user_details ud on ud.user_id=ts.user_id;
select * from timesheets;
select * from status;

select ts.timesheet_for_date,ts.spend_time_hrs,NVL(s.status,'Not Approved')as status from status s 
right join timesheets ts on s.timesheet_id=ts.timesheet_id 
inner join user_details ud on ud.user_id=ts.user_id 
where user_name='vishaliravi@gmail.com' and timesheet_for_date between '20-12-2021' and '22-12-2021';

select sysdate from dual;
select * from timesheets;
select * from user_details;
select * from task_details;
commit;

--update task_details set total_hours =total_hours- where task_name= and user_id=;

select * from task_details where assigned_to='vishaliravi@gmail.com' and total_hours>0;

select * from user_details where role not in('ADMIN','IN ACTIVE');
