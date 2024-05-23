--changelog Shvyrev:1
create table public.PERSONS(
    name text not null,
    surname text not null,
    age int not null,
    phone_number text not null,
    city_of_living text not null,
    primary key (name, surname, age)
);
--rollback drop table public.PERSONS


--changelog Shvyrev:2
insert into public.PERSONS(name, surname, age, phone_number, city_of_living)
values('Василий', 'Петров','23','+79193572583','MOSCOW');

insert into public.PERSONS(name, surname, age, phone_number, city_of_living)
values('Анатолий', 'Путин','49','+79196872583','PERM');

insert into public.PERSONS(name, surname, age, phone_number, city_of_living)
values('Генадий', 'Колобков','32','+79193825853','KIROVSK');

insert into public.PERSONS(name, surname, age, phone_number, city_of_living)
values('Олег', 'Тузиков','22','+79193281453','MOSCOW');