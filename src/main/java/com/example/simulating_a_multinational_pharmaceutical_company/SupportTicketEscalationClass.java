package com.example.simulating_a_multinational_pharmaceutical_company;

import java.io.Serializable;

public class SupportTicketEscalationClass  implements Serializable {

    private String status;

    public SupportTicketEscalationClass(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SupportTicketEscalationClass{" +
                "status='" + status + '\'' +
                '}';
    }
}


