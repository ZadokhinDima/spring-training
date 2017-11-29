package entities;

import org.springframework.stereotype.Component;



public class Client {
    private String id;
    private String fullname;
    private String greeting;

    public Client(String id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
