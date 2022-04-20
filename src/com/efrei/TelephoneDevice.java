package com.efrei;

import java.util.ArrayList;
import java.util.Date;

public class TelephoneDevice implements Device {
    private ArrayList<Contact> contactList;
    private ArrayList<PhoneCall> phoneCallList;

    public TelephoneDevice() { //Constructor
        this.contactList = new ArrayList<Contact>();
        this.phoneCallList = new ArrayList<PhoneCall>();
    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }

    public void addPhoneCall(PhoneCall phoneCall) {
        this.phoneCallList.add(phoneCall);
    }

    @Override
    public String toString() {
        return "contactList=" + contactList +
                ",\nphoneCallList=" + phoneCallList;
    }

    /*
     * Takes a phone number as a parameter and returns true if the list contains the phone number
     */
    /*
    public boolean isFoundPhoneNumber(int phoneNumber) {
        for (Contact contact : contactList) {
            if(contact.getPhoneNumber() == phoneNumber){
                return true;
            }
        }
        return false;
    }
    */

    public PhoneCall getCallFromIdCall(int idCall){
        for (PhoneCall phoneCall : phoneCallList) {
            if (phoneCall.getIdCall() == idCall) {
                return phoneCall;
            }
        }
        return null;
    }

    /*
     * Takes key word as a parameter and returns an ArrayList of contacts with a name starting with the key word
     */
    public ArrayList<Contact> searchContactWithKeyWord(String keyWord) {
        ArrayList<Contact> resultSearch = new ArrayList<Contact>();

        for (Contact contact : contactList) {
            if (contact.getNameContact().startsWith(keyWord)) {
                resultSearch.add(contact);
            }
        }
        return resultSearch;
    }

    /*
     * Takes a phone number as a parameter and returns a contact with the corresponding phone number
     * Returns null if no contact is found
     */
    public Contact searchContactWithPhoneNumber(int phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber() == phoneNumber) {
                return contact;
            }
        }
        return null;
    }

    /*
     * Calculates the total cost from all the phone calls
     */
    public int totalCallCost() {
        int totalCost = 0;
        for (PhoneCall phoneCall : phoneCallList) {
            totalCost += phoneCall.getCostCall();
        }
        return totalCost;
    }

    /*
     * Takes two dates as a parameter and returns the total cost from all the phone calls
     * that happened between the two dates
     */
    public int costBetweenDates(Date date1, Date date2) {
        int totalCost = 0;

        for (PhoneCall phoneCall : phoneCallList) {
            if ((phoneCall.getDateCall().compareTo(date1) >= 0
                    && phoneCall.getDateCall().compareTo(date2) <= 0)) { //date1<=dateCall AND date2>=dateCall
                totalCost += phoneCall.getCostCall();
            }
        }
        return totalCost;
    }

    /*
     * Takes the name of a contact as a parameter and returns the total cost for all of his phone calls
     */
    public int getTotalCostForContact(String nameContact) {
        int totalCost = 0;

        for (PhoneCall phoneCall : phoneCallList) {
            if (nameContact.equals(phoneCall.getContact().getNameContact())) {
                totalCost += phoneCall.getCostCall();
            }
        }
        return totalCost;
    }

    //Interface implementation
    @Override
    public void turnDeviceOn() {
        System.out.println("L'appareil vient de s'allumer");
    }

    @Override
    public void turnDeviceOff() {
        System.out.println("L'appareil vient de s'eteindre");
    }

    @Override
    public void turnAlarmOn() {
        System.out.println("Dring Dring Dring");
    }
}



