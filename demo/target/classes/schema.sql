create table study_group
(
    id int,
    name varchar(10)
);

create table student
(
    id int,
    surname varchar(20),
    name varchar(20),
    second_name varchar(20),
    study_group_id int,
    foreign key (study_group_id) references study_group (id)
);

create table subject
(
    id int,
    name varchar(50),
    short_name varchar(10)
);

create table exam_type
(
    id int,
    type varchar(20)
);

create table study_plan
(
    id int,
    subject_id int,
    foreign key (subject_id) references subject (id),
    exam_type_id int,
    foreign key (exam_type_id) references exam_type (id)
);

create table mark
(
    id int,
    name varchar(20),
    value varchar(10)
);

create table journal
(
    id int,
    student_id int,
    foreign key (student_id) references student (id),
    study_plan_id int,
    foreign key (study_plan_id) references study_plan (id),
    in_time bit,
    count int,
    mark_id int,
    foreign key (mark_id) references mark (id)
);

insert into SUBJECT
values
(1, 'Проектирование информационных систем', 'ПрИС'),
(2, 'Системы искусственного интеллекта', 'СИИ'),
(3, 'Программная инженерия', 'ПИ'),
(4, 'Национальная система информационной безопасности', 'НСИБ'),
(5, 'Системный анализ', 'СисАнал'),
(6, 'Распределенные базы данных', 'РБД'),
(7, 'Системное программное обеспечение', 'СПО');

insert into EXAM_TYPE
values (1, 'Экзамен'),
       (2, 'Зачет'),
       (3, 'Зачет с оценкой'),
       (4, 'Курсовая');

insert into STUDY_PLAN
values
(1, 1, 1),
(2, 1, 4),
(3, 2, 1),
(4, 3, 1),
(5, 4, 2),
(6, 5, 1),
(7, 6, 2),
(8, 7, 1);

insert into MARK
values
(1, 'Отлично', 5),
(2, 'Хорошо', 4),
(3, 'Удовлетворительно', 3),
(4, 'Неудовлетворительно', 2),
(5, 'Зачет', 'з'),
(6, 'Незачет', 'н'),
(7, 'Неявка', '');

create table student_local
(
    id int,
    surname varchar(20),
    name varchar(20),
    second_name varchar(20),
    study_group_id int,
    foreign key (study_group_id) references study_group (id)
);

insert into student_local
values
(1, Романова,Полина,Юрьевна, 1),
(2,Григорьев,Матвей,Иванович,1),
(3,Медведева,Елизавета,Андреевна,3),
(5,Смирнов,Алексей,Платонович,2),
(4,Синицына,Мия,Львовна,1),
(6,Казакова,София,Ивановна,3);