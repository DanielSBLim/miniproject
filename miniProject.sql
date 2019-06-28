
CREATE TABLE Member (
ID varchar2(10) UNIQUE NOT NULL,
PW varchar2(10) NOT NULL,
NICK varchar2(10) UNIQUE NOT NULL,
base_Problem_Check NUMBER(1) CHECK(base_Problem_Check=0 or base_Problem_Check=1),
Middel_Problem_Check NUMBER(1) CHECK(Middel_Problem_Check=0 or Middel_Problem_Check=1),
Complete_Problem_Check NUMBER(1)  CHECK(Complete_Problem_Check=0 or Complete_Problem_Check=1)
);