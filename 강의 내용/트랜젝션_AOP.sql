create table user_info(
user_num number(5)
);


create table system_info(
system_num number(5),
constraint test_name check(system_num<=5)
);

select * from user_info;

select * from system_info;