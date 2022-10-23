package api;

import lombok.Data;

@Data
public class UserTime {
    public String name;
    public String job;

    public UserTime() {
    }

    public UserTime(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
