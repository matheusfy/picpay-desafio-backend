delete from users;

delete from accounts;

delete from transactions;

insert into
  accounts (id, balance)
values
  (1, 200);

insert into
  accounts (id, balance)
values
  (2, 200);

insert into
  users (
    id,
    name,
    document,
    password,
    email,
    profile,
    account_id
  )
values
  (
    1,
    "matheus",
    "12345678998",
    "123456",
    "matheus@gmail.com",
    1,
    1
  );

insert into
  users (
    id,
    name,
    document,
    password,
    email,
    profile,
    account_id
  )
values
  (
    2,
    "Loja",
    "1234564789712",
    "123456",
    "loja@gmail.com",
    2,
    2
  );