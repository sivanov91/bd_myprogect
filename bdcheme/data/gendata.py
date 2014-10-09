#!/usr/bin/python
# -*- coding:utf8 -*-

import hashlib


#1 Mishel email@email pass 1234567 mishel Penson None 1

#INSERT INTO users(user_id, name, email, password_hash, phone, nikname, second_name, patronymic, role_id)
#    VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?);

users = [
  [1,  "admin",  "admin",  "admin"],
  [2,  "Mishel", "mishel", "Penson"],
  [3,  "Андрей", "andrei", "КАЦ"],
  [4,  "Тим",    "tim",    "Роббинс"],
  [5,  "Мрган",  "morgan", "Фриман"],
  [6,  "Боб",    "bob",    "Гантон"],
  [7,  "Уильям", "uil",    "Сэдлер"],
  [8,  "Кленси", "klen",   "Браун"],
  [9,  "Джилл",  "djil",   "Беллоуз"],
  [10, "Марк",   "mark",   "Ролсьлн"]
  ]

f = open("insert.sql", "w")

m = hashlib.md5()
m.update("pass")
password = m.hexdigest()

f.write("-" * 20 + "Users" + "-" * 20 + '\n')

f.write("DELETE FROM users;\n")
for user in users:
  f.write("INSERT INTO users(user_id, name, email, password_hash, phone, nikname, second_name, patronymic, role_id)\n VALUES (%s, '%s', 'email@email', '21232f297a57a5a743894a0e4a801fc3', '1234567', '%s', '%s', 'None', 1);\n\n" % (user[0], user[1], user[2], user[3]))
  
f.close()