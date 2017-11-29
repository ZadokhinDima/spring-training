package entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@Component("event")
@Scope("prototype")
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;
    private EventType eventType;


    public Event(Date date, DateFormat dtf) {
        Random rnd = new Random();
        id = rnd.nextInt();
        this.date = date;
        this.dateFormat = dtf;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType type){
        this.eventType = type;
    }

    public static boolean isDay(){
        Date date = new Date();
        return date.getHours() >= 8 && date.getHours() <= 17;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
