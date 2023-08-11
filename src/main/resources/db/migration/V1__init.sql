create table products (
    id bigserial primary key,
    title varchar(255),
    price int,
    internal_secret_data varchar(255)
);

insert into products (title, price, internal_secret_data) values
('Milk', 80, 'ABC'),
('Cheese', 400, 'ABC'),
('Bread', 30, 'ABC'),
('Bananas', 90, 'ABC');