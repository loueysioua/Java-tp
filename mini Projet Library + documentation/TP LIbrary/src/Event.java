import java.util.Date;

public class Event {
    private Date eventDate;
    private String name;
    private String topic;
    private String features;
    static private long numEvents=0;
    private long eventID;
    private String description;
    private String status;

    public Event(String name, String topic, String features,  String status, Date eventDate ,String description ) {
        this.eventDate=eventDate;
        numEvents++;
        this.eventID=numEvents;
        this.status = status;
        this.name = name;
        this.topic = topic;
        this.features = features;
        this.description = description;
    }

    public Event() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public long getEventID() {
        return eventID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
