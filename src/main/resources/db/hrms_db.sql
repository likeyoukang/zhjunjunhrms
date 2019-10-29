create table admin_tb(
	admin_id int(11) not null auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
	role_name varchar(20) not null default 'normaladmin',
	primary key(admin_id)
);
insert into admin_tb(username,password,role_name) values('superadmin','123456','superadmin'),('admin1','123456','normaladmin');


create table post_tb(
	post_id int(11) not null auto_increment,
	title varchar(50) not null,
	content text not null,
	admin_id int(11) not null,
	create_date date not null,
	primary key(post_id),
	foreign key(admin_id) references admin_tb(admin_id)
);
insert into post_tb(title,content,admin_id,create_date) values('Leave notice','Please pay attention to holiday safety!',1,'2017-4-30');


create table dept_tb(
	dept_id int(11) not null auto_increment,
	dept_name varchar(50) not null,
	dept_description varchar(200) not null,
	primary key(dept_id)
);
insert into dept_tb(dept_name,dept_description) values('course','make courses'),('development','Software development');


create table position_tb(
	pos_id int(11) not null auto_increment,
	pos_name varchar(50) not null,
	pos_description varchar(200) not null,
	primary key(pos_id)
);
insert into position_tb(pos_name,pos_description) values('Java course staff','make Java courses'),('front-end engineers','responsible for front-end development');


create table employee_tb(
	emp_id varchar(20) not null,
	emp_name varchar(50) not null,
	sex varchar(10) not null,
	phone varchar(20) not null,
	email varchar(50) not null,
	address varchar(100) not null,
	education varchar(50) not null,
	birthday date not null,
	dept_id int(11) not null,
	pos_id int(11) not null,
	primary key(emp_id),
	foreign key(dept_id) references dept_tb(dept_id),
	foreign key(pos_id) references position_tb(pos_id)
);
insert into employee_tb values('10001','Tom','male','18211234567','524123456@qq.com','chengdu','Bachelor','1990-4-30',1,1),('10002','Jack','male','18211234568','524123457@qq.com','chongqing','Master','1986-9-2',1,1),('10011','Rose','female','18211234580','524198757@qq.com','chengdu','Bachelor','1991-11-21',2,2),('10012','Anny','female','18211237580','594168757@qq.com','chengdu','Master','1987-5-11',2,2);

