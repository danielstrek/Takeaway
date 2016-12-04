drop table if exists role;
create table role(
role_id int auto_increment  primary key,
role_name varchar(20)

);

drop table IF EXISTS user_role;
create table user_role(
user_role_id int auto_increment  primary key,
role_id int,

foreign key (role_id) references role(role_id)


);


drop table IF EXISTS  user;
create table user (
	user_id int auto_increment primary key,
    user_role_id int ,
    user_name varchar(30),
    user_lastname varchar(30),
    user_email varchar(30),
    user_pass varchar(30),
    
    foreign key (user_role_id) references user_role(user_role_id)
    

);

drop table IF EXISTS  restaurant;
create table restaurant(
res_id int auto_increment primary key,
res_name varchar(80),
res_menu_link varchar(120),
res_info varchar(250)

);


drop table IF EXISTS  order_;
create table order_(
order_id int auto_increment primary key,
order_res_id int,
order_session varchar(30),
order_deadline date,
order_fullcost int,
order_user_id int,

foreign key (order_user_id) references user (user_id),
foreign key(order_res_id) references restaurant(res_id)
);

drop table if exists dish;
create table dish(
dish_id int auto_increment primary key,
dish_name varchar(100),
dish_cost float(4,2),
dish_paid varchar (1),
dish_paid_money float (5,2),
dish_user_id int,
dish_order_id int,

foreign key (dish_order_id)references order_(order_id),
foreign key (dish_user_id) references user(user_id)

)




