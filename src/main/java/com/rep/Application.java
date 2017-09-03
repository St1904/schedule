package com.rep;

import com.rep.db.repository.ContactNameRepository;
import com.rep.db.repository.ContactRepository;
import com.rep.db.repository.TutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

/*        SubjectThemeService subjectThemeService = applicationContext.getBean(SubjectThemeService.class);

        List<Theme> themes = subjectThemeService.findThemesByIdSubject(2L);
        System.out.println(themes);*/

/*
        EventChangeService eventChangeService = applicationContext.getBean(EventChangeService.class);
        EventService eventService = applicationContext.getBean(EventService.class);

        Date from = toDate("2017-06-05");
        Date to = toDate("2017-06-20");

        System.out.println(from);
        System.out.println(to);

        List<Event> events = eventService.findBetweenDates(1L, "2017-06-05", "2017-06-10");

        System.out.println(events);

        ArrayList<EventDto> result = new ArrayList<>();

        Date current = new Date(from.getTime());
        System.out.println(current);
        for (Event event : events) {
            while ((current.before(to) || current.getTime() == to.getTime())
                    && (event.getDateEnd() == null || current.before(event.getDateEnd()) || current.getTime() == event.getDateEnd().getTime())) {
                result.add(EventDto.of(event, current));
                current = nextDay(current);
            }
        }
*/

//        System.out.println(DateTranslator.toDate("17-06-2017"));



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


//        ContactService contactService = applicationContext.getBean(ContactService.class);

//        List<ContactName> list = contactService.findAll();
//        for (ContactName contactName : list) {
//            System.out.println(contactName);
//        }

    }
}
