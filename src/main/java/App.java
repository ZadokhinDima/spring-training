import entities.Client;
import entities.Event;
import entities.EventType;
import logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

public class App {

    private Client client;

    private EventLogger eventLogger;

    private Map<EventType, EventLogger> eventLoggers;


    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> eventLoggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.eventLoggers = eventLoggers;
    }

    private void logEvent(Event msg){
        EventLogger logger = eventLoggers.get(msg.getEventType());
        if(logger == null){
            logger = eventLogger;
        }
        logger.logEvent(msg);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);

        Event first = (Event) context.getBean("event");
        first.setEventType(EventType.ERROR);
        first.setMsg("Error.");

        Event second = (Event) context.getBean("event");
        second.setEventType(EventType.INFO);
        second.setMsg("Info.");

        Event third = (Event) context.getBean("event");
        third.setMsg("No type.");

        app.logEvent(first);
        app.logEvent(second);
        app.logEvent(third);

        context.close();

    }
}
