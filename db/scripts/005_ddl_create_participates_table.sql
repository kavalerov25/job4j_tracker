create TABLE IF NOT EXISTS participates (
   id serial PRIMARY KEY,
   item_id int not null REFERENCES items(id),
   user_id int not null REFERENCES j_user(id)
);