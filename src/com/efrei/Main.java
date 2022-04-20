package com.efrei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * TP_Note_Java_L3_RI
 * 18/05/2021
 * Armand HURAULT
 */

public class Main {

    public static void main(String[] args) throws ParseException {

        //Preparing the date format day-month-year
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

/////////////////////////////////BEGIN CREATION + FILLING THE LISTS////////////////////////////////////////////////////
        //Creating the telephone device
        TelephoneDevice telDev1 = new TelephoneDevice();

        //Creating the contacts
        Contact contact1 = new Contact(1, "Armand", 555);
        Contact contact2 = new Contact(2, "Rick", 666);
        Contact contact3 = new Contact(3, "Chad", 777);

        //Adding the contacts to the telephone device
        telDev1.addContact(contact1);
        telDev1.addContact(contact2);
        telDev1.addContact(contact3);

        //Creating the calls emitted
        //Time in hour
        PhoneCallEmitted callEmitted1 = new PhoneCallEmitted(contact1, 27,
                format.parse("25-02-2020"), 7);
        PhoneCallEmitted callEmitted2 = new PhoneCallEmitted(contact2, 28,
                format.parse("30-10-2020"), 10);
        PhoneCallEmitted callEmitted3 = new PhoneCallEmitted(contact3, 30,
                format.parse("30-10-2021"), 6);

        //Creating the calls received
        PhoneCallReceived callReceived1 = new PhoneCallReceived(contact1, 25,
                format.parse("30-02-2020"), 2);
        PhoneCallReceived callReceived2 = new PhoneCallReceived(contact2, 29,
                format.parse("31-05-2021"), 3);

        //Adding the calls
        telDev1.addPhoneCall(callEmitted1);
        telDev1.addPhoneCall(callEmitted2);
        telDev1.addPhoneCall(callReceived1);
        telDev1.addPhoneCall(callReceived2);

        //Test prints
        //  System.out.println("Infos du contact : " + contact1.toString());
        //  System.out.println("Infos de l'appel emit : " + callEmitted1.toString());
        //    System.out.println("Infos de l'appel recu : " + callReceived1.toString());
        // System.out.println("Infos du telephone : " + telDev1.toString());
/////////////////////////////////END CREATION + FILLING THE LISTS///////////////////////////////////////////////////////

        int choice; //switch variable

        Scanner sc = new Scanner(System.in); //Creating the input scanner

        do {
            System.out.println("///////////////////////////////////////////////");
            System.out.println("Veuillez selectionner une action :");
            System.out.println("1 - Enregistrer un nouveau contact");
            System.out.println("2 - Enregistrer un nouvel appel sachant le numero de telephone. (non fonctionnel)"); //TODO ??
            System.out.println("3 - Consulter un contact sachant son numero de telephone.");
            System.out.println("4 - Consulter les contacts dont le nom commence par un mot cle.");
            System.out.println("5 - Consulter le cout total des appels.");
            System.out.println("6 - Consulter le cout des appels entre deux dates.");
            System.out.println("7 - Consulter le cout des appels concernant un contact.");
            System.out.println("8 - Consulter toutes les infos du telephone (debug)");
            System.out.println("9 - Quitter.");

            //Local variables
            int idContact;
            String nameContact;
            int phoneNumber;
            int idCall;
            Contact contact;
            PhoneCall phoneCall;
            String keyWord;
            Date date1, date2;
            String dateStr;

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> { //Add a new contact
                    System.out.println("Id du contact : ");
                    idContact = sc.nextInt();
                    System.out.println("Nom du contact : ");
                    sc.nextLine(); //Empties the buffer
                    nameContact = sc.nextLine();
                    System.out.println("Numero de telephone du contact : ");
                    phoneNumber = sc.nextInt();

                    telDev1.addContact(new Contact(idContact, nameContact, phoneNumber));
                    System.out.println("Contact ajoute avec succes !");
                }

                case 2 -> { //TODO Add new call from number
                    /*
                    System.out.println("Indiquez num tel :");
                    phoneNumber = sc.nextInt();

                    if (telDev1.isFoundPhoneNumber(phoneNumber)) {
                    }
                    */
                    System.out.println("Indiquez id de l'appel:");
                    idCall = sc.nextInt();
                    //TODO test with call id 30

                    phoneCall = telDev1.getCallFromIdCall(idCall);

                    if(phoneCall == null){ //if no phone call is found
                        System.out.println("Erreur : appel non trouve... ");
                    }
                    else {
                        telDev1.addPhoneCall(phoneCall);
                        System.out.println("Appel ajoute avec succes !");
                    }
                    //System.out.println("Implementation non finie ... :");
                }

                case 3 -> { //Consult a contact with his phone number
                    System.out.println("Indiquez numero de telephone du contact a consulter:");
                    phoneNumber = sc.nextInt();
                    contact = telDev1.searchContactWithPhoneNumber(phoneNumber);

                    if (contact == null) {
                        System.out.println("Erreur : contact non trouvé");
                    } else {
                        System.out.println(contact.toString());
                    }
                }

                case 4 -> { //Consult contacts with a name starting with a keyword
                    System.out.println("Indiquez un mot cle : ");
                    sc.nextLine();
                    keyWord = sc.nextLine();
                    System.out.println("Resultat de la recherche par mot cle : "
                            + telDev1.searchContactWithKeyWord(keyWord).toString());
                }

                //Consult the total cost for phone calls
                case 5 -> System.out.println("Cout total des appels : " + telDev1.totalCallCost());

                case 6 -> { //Consult the total cost for phone calls between 2 dates
                    System.out.println("Indiquez date 1 (dd-MM-yyyy) : ");
                    sc.nextLine(); //Empties the buffer
                    dateStr = sc.nextLine();
                    date1 = format.parse(dateStr);    //  Converts string to date.

                    System.out.println("Indiquez date 2 (dd-MM-yyyy) : ");
                    dateStr = sc.nextLine();
                    date2 = format.parse(dateStr);

                    System.out.println("Cout total pour les appels entre le "
                            + format.format(date1) //converts date to string
                            + " et le "
                            + format.format(date2)
                            + " : " + telDev1.costBetweenDates(date1, date2) + " euros ");
                    ;
                }

                case 7 -> { //Consult the total phone call cost for a contact
                    System.out.println("Indiquez le nom du contact : ");
                    sc.nextLine(); //Empties the buffer
                    nameContact = sc.nextLine();
                    System.out.println("Cout total pour le contact "
                            + nameContact
                            + " : "
                            + telDev1.getTotalCostForContact(nameContact)
                            + " euros");
                }

                //Consult contactList + phoneCallList
                case 8 -> System.out.println("Infos du telephone : " + telDev1.toString());
                case 9 -> System.out.println("Au revoir !");
                default -> System.out.println("Erreur de saisie, reessayez");
            }
        } while (choice != 9);
    }
}

