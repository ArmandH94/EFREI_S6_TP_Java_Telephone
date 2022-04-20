package com.efrei;

import java.util.Date;

public class PhoneCallReceived extends PhoneCall {

    public PhoneCallReceived(Contact contact, int idCall, Date dateCall, int durationCall) { //Constructor
        super(contact, idCall, dateCall, durationCall, 0);
    }
}
