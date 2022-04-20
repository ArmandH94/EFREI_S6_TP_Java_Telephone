package com.efrei;

public class Contact {
    private int idContact;
    private String nameContact;
    private int phoneNumber;

    public Contact(int idContact, String nameContact, int phoneNumber) { //Constructor
        this.idContact = idContact;
        this.nameContact = nameContact;
        this.phoneNumber = phoneNumber;
    }

    //Accessors
    public String getNameContact() {
        return nameContact;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "idContact=" + idContact +
                ", nameContact='" + nameContact + '\'' +
                ", phoneNumber=" + phoneNumber;
    }
}
