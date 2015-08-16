package provider.domain;

import lombok.Data;

@Data
public class UserServiceRequest {
    private double longitude;
    private double latitude;
    private int serviceId;
    private int radiusInKilometers;

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setRadiusInKilometers(int radiusInKilometers) {
        this.radiusInKilometers = radiusInKilometers;
    }
}
