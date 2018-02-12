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

//TODO добавить changes потом
@Component
public class EventChangeUtil {
    public List<EventDto> formatAllEvents(List<Event> events, Date from, Date to) {
        Date current;
        ArrayList<EventDto> result = new ArrayList<>();
        for (Event event : events) {
            switch (event.getRepeatCode()) {
                case DAILY:
                    current = new Date(from.after(event.getDateStart()) ? from.getTime() : event.getDateStart().getTime());
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (event.getDateEnd() == null || current.before(event.getDateEnd()) || current.getTime() == event.getDateEnd().getTime())) {
                        result.add(EventDto.of(event, current));
                        current = nextDay(current);
                    }
                    break;
                case NEVER:
                    result.add(EventDto.of(event, event.getDateStart()));
                    break;
                case WEEKLY:
                    current = event.getDateStart();
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && !(current.after(from) || current.getTime() == from.getTime())) {
                        current = nextWeek(current);
                    }
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (event.getDateEnd() == null || current.before(event.getDateEnd()) || current.getTime() == event.getDateEnd().getTime())) {
                        result.add(EventDto.of(event, current));
                        current = nextWeek(current);
                    }
                    break;
                case YEARLY:
                    current = event.getDateStart();
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (current.before(from) || current.getTime() == from.getTime())) {
                        current = nextYear(current);
                    }
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (event.getDateEnd() == null || current.before(event.getDateEnd()) || current.getTime() == event.getDateEnd().getTime())) {
                        result.add(EventDto.of(event, current));
                        current = nextYear(current);
                    }
                    break;
                case MONTHLY:
                    current = event.getDateStart();
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (current.before(from) || current.getTime() == from.getTime())) {
                        current = nextMonth(current);
                    }
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (event.getDateEnd() == null || current.before(event.getDateEnd()) || current.getTime() == event.getDateEnd().getTime())) {
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
