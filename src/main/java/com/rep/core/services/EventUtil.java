package com.rep.core.services;

import com.rep.core.dto.EventDto;
import com.rep.db.domain.Event;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static com.rep.core.common.DateUtil.*;

/**
 * Created by St on 10.06.2017.
 */

public class EventUtil {
    public static List<EventDto> formatAllEvents(List<Event> events, Date from, Date to) {

        //Начальная дата события, попадающая в промежуток from-to, либо первая дата повторяющегося события, позже from
        Date current;

        //Старт серии событий
        Date dateStart;

        //Окончание серии событий
        Date dateEnd;

        //Результирующий список со всеми событиями, попадающими в промежуток from-to
        ArrayList<EventDto> result = new ArrayList<>();

        for (Event event : events) {

            dateStart = event.getDateStart();
            dateEnd = event.getDateEnd();

            switch (event.getRepeatCode()) {
                case NEVER:
                    //Для неповторяющихся событий достаточно проверить, что его дата попадает в нужный промежуток
                    if (afterOrEqual(dateStart, from) && beforeOrEqual(dateStart, to)) {
                        result.add(EventDto.of(event, dateStart));
                    }
                    break;

                case DAILY:
                    //Начальной датой становится начало промежутка, если оно позже, чем начало серии событий
                    current = new Date(afterOrEqual(from, dateStart) ? from.getTime() : dateStart.getTime());

                    //Пока текущая дата <= конца промежутка и <= даты окончания серии событий (либо событие "бесконечное"),
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {

                        //формируем события каждый день
                        result.add(EventDto.of(event, current));
                        current = nextDay(current);
                    }
                    break;

                case WEEKLY:
                    //Если событие начинается раньше, чем начало промежутка,
                    if (dateStart.before(from)) {
                        //вычисляем количество недель для сдвига, чтобы дата начала стала >= даты начала промежутка
                        long days = (from.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24) - 1;
                        long weeks = days / 7 + 1;
                        //сдвигаем дату начала на нужное количество недель
                        current = new Date(dateStart.getTime() + weeks * 7 * 24 * 60 * 60 * 1000);
                    } else { //Иначе дата начала подходит, т.к. попадает в промежуток
                        current = new Date(dateStart.getTime());
                    }

                    //Заполняем промежуток еженедельными событиями
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {
                        result.add(EventDto.of(event, current));
                        current = nextWeek(current);
                    }
                    break;

                case MONTHLY:
                    //Начинаем с даты начала серии событий
                    current = new Date(dateStart.getTime());

                    //Назначаем год и месяц промежутка для начальной даты
                    if (current.before(from)) {
                        current.setYear(from.getYear());
                        current.setMonth(from.getMonth());
                    }
                    //Если начальная дата все еще меньше начала промежутка, сдвигаем еще на месяц
                    if (current.before(from)) {
                        current = nextMonth(current);
                    }

                    //Добавляем в результирующий список ежемесячные события
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {
                        result.add(EventDto.of(event, current));
                        current = nextMonth(current);
                    }
                    break;

                case YEARLY:
                    //Начинаем с даты начала серии событий
                    current = new Date(dateStart.getTime());

                    //Меняем год на тот, с которого начинается промежуток
                    if (current.before(from))
                        current.setYear(from.getYear());

                    //Если начальная дата все еще меньше начала промежутка, сдвигаем еще на год
                    if (current.before(from))
                        current = nextYear(current);


                    //Добавляем в список ежегодные события
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {
                        result.add(EventDto.of(event, current));
                        current = nextYear(current);
                    }
                    break;
            }
        }

        result.sort(Comparator.comparing(EventDto::getCurrentDate));
        return result;
    }
}