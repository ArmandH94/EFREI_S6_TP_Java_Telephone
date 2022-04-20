package com.efrei;

import java.util.Date;

public abstract class PhoneCall {
    private Contact contact;
    private int idCall;
    private Date dateCall;
    private int durationCall;
    private int costCall;

    public PhoneCall(Contact contact, int idCall, Date dateCall, int durationCall, int costCall) { //Constructor
        this.contact = contact;
        this.idCall = idCall;
        this.dateCall = dateCall;
        this.durationCall = durationCall;
        this.costCall = costCall;
    }

    @Override
    public String toString() {
        return "contact=" + contact +
                ", idCall=" + idCall +
                ", dateCall=" + dateCall +
                ", durationCall=" + durationCall +
                ", costCall=" + costCall;
    }

    //Accessors
    public Contact getContact() {
        return contact;
    }

    public int getCostCall() {
        return costCall;
    }

    public Date getDateCall() {
        return dateCall;
    }

    public int getIdCall() {
        return idCall;
    }

    public void setIdCall(int idCall) {
        this.idCall = idCall;
    }
}
