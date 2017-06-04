package com.rep;

import com.rep.core.Dto.EventDto;
import com.rep.core.services.ContactService;
import com.rep.core.services.EventService;
import com.rep.db.domain.Event;
import com.rep.db.domain.Repeats;
import com.rep.db.repository.*;
import com.rep.db.domain.ContactName;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by St on 31.01.2017.
 */

//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@Controller
@EnableJpaRepositories
public class Application {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);





        //testing ContactNameRepository
        ContactNameRepository contactNameRepository = applicationContext.getBean(ContactNameRepository.class);
//
//        ContactName contactName = new ContactName();
//        contactName.setName("Hi!");
//
//        contactNameRepository.saveAndFlush(contactName);
//        ContactName contactName = contactNameRepository.findByName("мобильный телефон");
//        System.out.println(contactName);
//        System.out.println(contactName.getId());



        //testing ContactRepository
        ContactRepository contactRepository = applicationContext.getBean(ContactRepository.class);
//        Contact contact = new Contact();
//        contact.setContactName(contactName);
//        contact.setValue("89001234567");
//
//        Contact savedContact = contactRepository.saveAndFlush(contact);
//
//        System.out.println(savedContact + " id: " + savedContact.getId());
//
//        Contact fromDB = contactRepository.findOne(1L);
//        System.out.println(fromDB);
//        System.out.println(contactRepository.findByValue("89001234567"));



        //testing TutorRepository
        TutorRepository tutorRepository = applicationContext.getBean(TutorRepository.class);
//        Tutor tutor = new Tutor();
//        tutor.setName("Мария Ивановна");
//        tutor.setAddress("Санкт-Петербург, пл.Мужества, д...");
//
//        tutorRepository.saveAndFlush(tutor);
//        System.out.println(tutorRepository.findOne(1L));


//        System.out.println("Hi!");
//
//        DataSource dataSource = applicationContext.getBean(DataSource.class);
//
//        System.out.println(dataSource);


        ContactService contactService = applicationContext.getBean(ContactService.class);

//        List<ContactName> list = contactService.findAll();
//        for (ContactName contactName : list) {
//            System.out.println(contactName);
//        }

        EventService eventService = applicationContext.getBean(EventService.class);
/*
        List<Event> list = eventService.listEventsWithJoin();
        for (Event event : list) {
            System.out.println(event);
        }*/

        EventRepository eventRepository = applicationContext.getBean(EventRepository.class);
/*        List<Event> list = eventRepository.findAllByTutor(1L);
        for (Event event : list) {
            System.out.println(event);
        }*/

        RepeatsRepository repeatsRepository = applicationContext.getBean(RepeatsRepository.class);
/*
        Repeats repeats = repeatsRepository.findByEventId(3L);
        System.out.println(repeats);*/
        List<EventDto> list = eventService.listEventsForWeekFromDate(new Date(117, 1, 14));
        for (EventDto eventDto : list) {
            System.out.println(eventDto);
        }

    }
}
