create table if not exists ROLES(
	id serial primary key,
	role varchar(10) not null unique
);

create table if not exists MANAGERS (
	id serial primary key,
	email varchar(40) not null unique,
	password varchar(40),
	name varchar(40),
	department varchar(20),
	role_id int4 references ROLES(id)
);

create table if not exists EMPLOYEES (
	id serial primary key,
	email varchar(40) not null unique,
	password varchar(40),
	name varchar(40),
	department varchar(20),
	role_id int4 references ROLES(id),
	manager_id int4 references MANAGERS(id)
);

create table if not exists EXPENSES(
	id serial primary key,
	employee_id int4 references EMPLOYEES(id),
	manager_id int4 references MANAGERS(id),
	expense_date varchar(40),
	description varchar(50),
	category varchar(20),
	cost decimal,
	status varchar(20)
);


create table if not exists REQUESTS(
	id serial primary key,
	employee_id int4 references EMPLOYEES(id),
	manager_id int4 references MANAGERS(id),
	expense_date varchar(40),
	cost decimal,
	status varchar(20)
);

INSERT INTO roles (role) VALUES ('Employee'),('Manager');
INSERT INTO managers (email, password, name, department, role_id) VALUES ('christian.h@revature.net', 'test', 'Christian Hall', 'Engineering', 2);
INSERT INTO employees (email, password, name, department, role_id, manager_id) VALUES ('christianphall@gmail.com','BestEmployee', 'Tash Sultana', 'Engineering', 1, 1);
INSERT INTO expenses (employee_id, manager_id, expense_date, description, category, cost, status) VALUES (1, 1, '7/7/2021', 'Mitchells Steakhouse', 'Business Lunch', 180.77, 'APPROVED');



drop table user_roles cascade;