package com.rep.core.services;

import com.rep.core.Dto.EventDto;
import com.rep.db.domain.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static com.rep.core.special.DateUtil.nextDay;

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
                    current = new Date(from.getTime());
                    while ((current.before(to) || current.getTime() == to.getTime())
                            && (event.getDateEnd() == null || current.before(event.getDateEnd()) || current.getTime() == event.getDateEnd().getTime())) {
                        result.add(EventDto.of(event, current));
                        current = nextDay(current);
                    }
                    break;
                case NEVER:
                    break;
                case WEEKLY:
                    break;
                case YEARLY:
                    break;
                case MONTHLY:
                    break;
            }
        }
        result.sort(Comparator.comparing(EventDto::getCurrentDate));
        return result;
    }
}
