package api;

import lombok.Data;

@Data
public class Register {
    public String email;
    public String password;

    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Register() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
