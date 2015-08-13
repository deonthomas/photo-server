package media.data;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MediaMetaData")
public class MediaContent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    private String longitude;
    private String latitude;
    private String contentUrl;
    private Date   dateTime;

    public MediaContent(){}
    public MediaContent(String name, Date dateTime, String longitude, String latitude, String contentUrl) {

        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.contentUrl = contentUrl;
        this.dateTime = dateTime;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
