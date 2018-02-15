package com.rep.core.services;

import com.rep.core.dto.EventDto;
import com.rep.db.domain.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static com.rep.core.common.DateUtil.*;

/**
 * Created by St on 10.06.2017.
 */

@Component
public class EventChangeUtil {
    public List<EventDto> formatAllEvents(List<Event> events, Date from, Date to) {

        //Начальная дата события, попадающая в промежуток from-to
        Date current;

        //Старт серии событий
        Date dateStart;

        //Окончание серии событий
        Date dateEnd;
        ArrayList<EventDto> result = new ArrayList<>();

        for (Event event : events) {

            dateStart = event.getDateStart();
            dateEnd = event.getDateEnd();

            switch (event.getRepeatCode()) {
                case DAILY:
                    //Начальной датой становится начало промежутка, если оно позже, чем начало серии событий
                    current = new Date(afterOrEqual(from, dateStart) ? from.getTime() : dateStart.getTime());

                    //Пока текущая дата <= конца промежутка и <= даты окончания серии событий (либо событие "бесконечное")
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {

                        //формируем события каждый день
                        result.add(EventDto.of(event, current));
                        current = nextDay(current);
                    }
                    break;

                case NEVER:
                    //Для неповторяющихся событий достаточно проверить, что его дата попадает в нужный промежуток
                    if (afterOrEqual(dateStart, from) && beforeOrEqual(dateStart, to)) {
                        result.add(EventDto.of(event, dateStart));
                    }
                    break;

                case WEEKLY:
                    current = dateStart;

                    while (beforeOrEqual(current, to)
                            && current.before(from)) {
                        current = nextWeek(current);
                    }
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {
                        result.add(EventDto.of(event, current));
                        current = nextWeek(current);
                    }
                    break;

                case YEARLY:
                    current = dateStart;

                    while (beforeOrEqual(current, to)
                            && current.before(from)) {
                        current = nextYear(current);
                    }
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {
                        result.add(EventDto.of(event, current));
                        current = nextYear(current);
                    }
                    break;

                case MONTHLY:
                    current = dateStart;

                    while (beforeOrEqual(current, to)
                            && current.before(from)) {
                        current = nextMonth(current);
                    }
                    while (beforeOrEqual(current, to)
                            && (dateEnd == null || beforeOrEqual(current, dateEnd))) {
                        result.add(EventDto.of(event, current));
                        current = nextMonth(current);
                    }
                    break;
            }
        }

        result.sort(Comparator.comparing(EventDto::getCurrentDate));
        return result;
    }
}