package api;

public class UnSuccessReg {
    public String error;

    public UnSuccessReg(String error) {
        this.error = error;
    }

    public UnSuccessReg() {
    }

    public String getError() {
        return error;
    }
}
