create table
  if not exists accounts (id bigint primary key, balance double default 0);

create table
  if not exists users (
    id bigint primary key,
    name varchar(64) not null,
    document varchar(20) not null,
    password varchar(255) not null,
    email varchar(32) not null,
    account_id bigint,
    profile int not null,
    foreign key (account_id) references accounts (id)
  );

create table
  if not exists transactions (
    id serial primary key,
    value double,
    sender_id bigint,
    receiver_id bigint,
    create_date timestamp
  );