import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullname());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean(App.class);

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
    }
}
