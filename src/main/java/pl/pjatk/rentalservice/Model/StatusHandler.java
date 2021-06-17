package pl.pjatk.rentalservice.Model;

import java.time.Instant;

public class StatusHandler {
    private int statusInfo;
    private String errorInfo;
    private Instant errorTime;

    public StatusHandler(int statusInfo, String errorInfo, Instant errorTime) {
        this.statusInfo = statusInfo;
        this.errorInfo = errorInfo;
        this.errorTime = errorTime;
    }

    public int getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(int statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Instant getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Instant errorTime) {
        this.errorTime = errorTime;
    }
}
