create table orders (
    id serial primary key,
    user_id integer not null,
    status integer not null default 0,
    uuid text not null unique,
    order_sum numeric
);