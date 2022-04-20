package com.efrei;

import java.util.Date;

public class PhoneCallEmitted extends PhoneCall {

    public PhoneCallEmitted(Contact contact, int idCall, Date dateCall, int durationCall) { //Constructor
        super(contact, idCall, dateCall, durationCall, durationCall * 2);
    }
}
