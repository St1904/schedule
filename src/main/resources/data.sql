#  INSERT INTO tutor (name, address) VALUE ("Мария Ивановна", "Санкт-Петербург, пл.Мужества, д...");

#  INSERT INTO student (id_tutor, first_name, last_name, address) VALUE (1, 'Аня', 'Смолина', 'наб. Черной речки, д. 3, кв. NN');
#  INSERT INTO student (id_tutor, first_name, last_name, address) VALUE (1, 'Лиза', 'Вахрамеева', 'ул. Красного курсанта, д. 18');

#  INSERT INTO contact_name (name) VALUES ("мобильный телефон"), ("вконтакте"), ("вотсап");

#  INSERT INTO contact (value, id_contact_name, id_student) VALUE ('89007654321', 1, 1);
#  INSERT INTO contact (value, id_contact_name, id_student) VALUE ('vk.ru/id12345', 2, 1);
#  INSERT INTO contact (value, id_contact_name, id_student) VALUE ('+79530003377', 1, 2);
#  INSERT INTO contact (value, id_contact_name, id_student) VALUE ('см. телефон', 3, 2);

#  INSERT INTO subject (id_tutor, name) VALUE (1, 'Математика');
#  INSERT INTO subject (id_tutor, name) VALUE (1, 'Биология');

#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Математика", null, null);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "темы ЕГЭ", null, 1);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Простейшие текстовые задачи", "самые простые задачи", 2);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "вычисления", null, 3);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "округление с недостатком", null, 3);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "округление с избытком", null, 3);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Начала теории вероятностей", null, 2);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Классическое определение вероятности", null, 7);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Теоремы о вероятностных событиях", null, 7);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Стереометрия", null, 2);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Куб", null, 10);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Призма", null, 10);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Конус", null, 10);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Пирамида", null, 10);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "по учебнику", null, 1);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "9 класс", null, 15);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Степень с рациональным показателем", null, 16);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Степень с целым показателем", null, 17);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Арифметический корень натуральной степени", null, 17);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Свойства арифметического корня", null, 17);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Прогрессии", null, 16);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Числовая последовательность", null, 21);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Арифметическая прогрессия", null, 21);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (1, "Сумма арифметической прогрессии", null, 21);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Биология", null, null);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "ЕГЭ", null, 25);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Первая часть", null, 26);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Клетка как биологическая система", null, 27);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Жизненный цикл клетки", null, 28);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Строение клетки", null, 28);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Генетические закономерности", null, 27);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Воспроизведение организмов", null, 31);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Закономерности наследственности и изменчивости", null, 31);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Онтогенез", null, 31);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Вторая часть (С)", null, 26);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "С1 Применение знаний в практических ситуациях", null, 35);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Бактерии и грибы", null, 36);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Животные", null, 36);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Основы генетики", null, 36);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "С2 Анализ текстовой и графической информации", null, 35);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Животные", null, 40);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Общая биология", null, 40);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Растения", null, 40);
#  INSERT INTO theme (id_subject, name, comment, id_parent_theme) VALUE (2, "Человек", null, 40);

#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "Завтрак", "DAILY", "2017-06-07", "2017-06-12", "11:00:00", "12:00:00", "ежедневное событие 1");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "бесконечный завтрак", "DAILY", "2017-06-07", null, "11:00:00", "12:00:00", "ежедневное событие 1");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "День рождения М", "YEARLY", "2017-07-05", null, null, null, "День рождения Маши");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "День рождения И", "YEARLY", "2017-07-30", null, null, null, "День рождения Ивана");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "Занятие с Аней", "WEEKLY", "2017-06-01", null, "16:00:00", "17:30:00", "Аня М. математика");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "Занятие с Аней", "WEEKLY", "2017-06-04", null, "16:00:00", "17:30:00", "Аня М. математика");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "Занятие с Лизой", "WEEKLY", "2017-06-02", null, "17:00:00", "18:30:00", "Лиза А. математика");
#  INSERT INTO event(id_tutor, name, code, date_start, date_end, time_start, time_end, comment) VALUE (1, "Занятие с Лизой", "WEEKLY", "2017-06-05", null, "17:15:00", "18:45:00", "Лиза А. математика");

#  INSERT INTO lesson(id_event, price, id_subject, id_student) VALUE (5, 600, 1, 1);
#  INSERT INTO lesson(id_event, price, id_subject, id_student) VALUE (6, 600, 1, 1);
#  INSERT INTO lesson(id_event, price, id_subject, id_student) VALUE (7, 800, 1, 2);
#  INSERT INTO lesson(id_event, price, id_subject, id_student) VALUE (8, 800, 1, 2);