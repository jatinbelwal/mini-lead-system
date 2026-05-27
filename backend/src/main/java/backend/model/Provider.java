package backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "providers")
public class Provider {

    @Id
    private String id;

    private String name;
    private int monthlyQuota;
    private int usedQuota;

    public Provider() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthlyQuota() {
        return monthlyQuota;
    }

    public void setMonthlyQuota(int monthlyQuota) {
        this.monthlyQuota = monthlyQuota;
    }

    public int getUsedQuota() {
        return usedQuota;
    }

    public void setUsedQuota(int usedQuota) {
        this.usedQuota = usedQuota;
    }
}