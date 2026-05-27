package backend.dto;

public class LeadRequest {

    private String name;
    private String phone;
    private String city;
    private String serviceType;
    private String description;

    // Default constructor for LeadRequest DTO
    // Required for DTO deserialization
    public LeadRequest() {
        // Empty constructor used by frameworks for object instantiation
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}