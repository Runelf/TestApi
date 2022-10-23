package api;

public class UserTimeResponse extends UserTime{
    public String updatedAt;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public UserTimeResponse() {
    }

    public UserTimeResponse(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

}
