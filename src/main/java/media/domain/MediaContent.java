package media.domain;
import lombok.Data;
import java.util.Date;


public class MediaContent {
    private String name;
    private Date dateTime;
    private String longitude;
    private String latitude;
    private String contentUrl;
    private String media;

    public void setName(String name){
        this.name = name;
    }


    public void setDateTime(Date name){
        this.dateTime = name;
    }

    public void setLongitude(String name){
        this.longitude = name;
    }

    public void setLatitude(String name){
        this.latitude = name;
    }

    public String getName() {
        return name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getMedia() {
        return media;
    }
}
