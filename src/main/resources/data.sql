# INSERT INTO tutor (name, address) VALUE ("Мария Ивановна", "Санкт-Петербург, пл.Мужества, д...");

# INSERT INTO contact_name (name) VALUES ("мобильный телефон"), ("вконтакте");

# INSERT INTO contact (value, id_contact_name) VALUE ('89007654321', (SELECT id AS contact_name_id FROM contact_name WHERE name='мобильный телефон'));
# INSERT INTO contact (value, id_contact_name) VALUE ('89001234567', (SELECT id AS contact_name_id FROM contact_name WHERE name='мобильный телефон'));

# INSERT INTO subject (name) VALUES ('Математика'), ("Физика"), ("Литература");









# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) VALUE (1, "Занятие 1", "2017-02-13", "11:00:00", "12:00:00", "первое занятие");
# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) VALUE (1, "Занятие 2", "2017-02-13", "13:00:00", "14:00:00", "второе занятие");
# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) VALUE (1, "Занятие с Иваном", "2017-02-14", "10:00:00", "11:30:00", "математика по вторникам");
# INSERT INTO repeats(id_event, code) VALUE (3, "WEEKLY");
# INSERT INTO repeat_day(id_repeats, day) VALUE (1, 2);
# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) value (1, "Занятие по вт и чт", "2017-02-7", "08:00:00", "08:30:00", "ojef");
# INSERT INTO repeats(id_event, code) value (4, "WEEKLY");
# INSERT INTO repeat_day(id_repeats, day) VALUE (2, 2);
# INSERT INTO repeat_day(id_repeats, day) VALUE (2, 4);
# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) value (1, "Завтрак", "2017-02-1", "07:00:00", "07:30:00", "daily event forever");
# INSERT INTO repeats(id_event, code) value (5, "DAILY");
# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) value (1, "Второй завтрак", "2017-02-1", "07:30:00", "08:00:00", "daily event up to 18.02.2017");
# INSERT INTO repeats(id_event, code, date_final) value (6, "DAILY", "2017-02-18");
# INSERT INTO event(id_tutor, name, date_start, time_start, time_end, comment) value (1, "Обед", "2017-02-14", "12:00:00", "12:30:00", "только 3 дня с 14.02.2017");
# INSERT INTO repeats(id_event, code, amount) value (7, "DAILY", 3);