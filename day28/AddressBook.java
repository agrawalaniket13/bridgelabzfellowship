package com.addressbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressBook {
    List<Contacts> contactsList = new ArrayList<Contacts>();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();

    public List<Contacts> getContactList() {
        return contactsList;
    }

    /**
     * method to add new contact from the console
     */

    public void addContact() {
        Contacts contacts =new Contacts();

        System.out.println("please Enter a first name");
        contacts.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please Enter a last name");
        contacts.setLastName(scannerForAddressBook.scannerProvider().nextLine());
        contacts.setLastName(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter address");
        contacts.setAddress(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter city");
        contacts.setCity(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter state");
        contacts.setState(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter email");
        contacts.setEmail(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter zip");
        contacts.setZip(scannerForAddressBook.scannerProvider().nextInt());
        System.out.println("Please enter phone number");
        contacts.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());

        //Add Contacts to the contactList
        contactsList.add(contacts);
    }

    public void editDetails(String name) {
        if(isContactExist(name) == true) {
            Contacts contact = getContact(name);
            boolean isExit = false;
            while(!isExit) {
                System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" +
                        "\n" + "3.address" + "\n" + "4.city" + "\n" +
                        "5.state" + "\n" + "6.email" + "\n" + "7.zip" +
                        "\n" + "8.phone number" + "\n" + "9.exit");

                switch (scannerForAddressBook.scannerProvider().nextInt()) {
                    case 1:
                        System.out.println("Enter new first name to change: ");
                        contact.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new last name to change: ");
                        contact.setLastName(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new address to change: ");
                        contact.setAddress(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new city to change: ");
                        contact.setCity(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new state to change: ");
                        contact.setState(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 6:
                        System.out.println("Enter new email to change: ");
                        contact.setEmail(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 7:
                        System.out.println("Enter new zip to change: ");
                        contact.setZip(scannerForAddressBook.scannerProvider().nextInt());
                        break;
                    case 8:
                        System.out.println("Enter new phone number to change: ");
                        contact.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    default:
                        System.out.println("Thank you!");
                        isExit = true;
                }
            }
        }
        else {
            System.out.println("Contact does not exists!");
        }
    }

    public void deleteContact(Contacts contact) {
        contactsList.remove(contact);
    }

    private String getName() {
        System.out.println("Enter contact name");
        return scannerForAddressBook.scannerProvider().nextLine();
    }

    private boolean isContactExist(String name) {
        boolean existance;
        existance = contactsList.stream()
                .anyMatch(personElement ->
                        personElement.getFirstName().equals(name) ||
                                personElement.getLastName().equals(name));
        return existance;
    }
    private Contacts getContact(String name) {
        Contacts foundContact = contactsList.stream()
                .filter(contact ->
                        contact.getFirstName().equals(name) ||
                                contact.getLastName().equals(name))
                .findFirst().orElse(null);
        return foundContact;
    }

    public void accessAddressBook() {
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select option: \n1.Add Contact\n2.Edit Contact\n" +
                    "3.Delete Contact\n4.Exit");
            int option = scannerForAddressBook.scannerProvider().nextInt();
            switch(option) {
                case 1:
                    if(!isContactExist(getName())) {
                        addContact();
                    }
                    else {
                        System.out.println("Contact not found");
                    }
                case 2:
                    String name = getName();
                    if (isContactExist(name)) {
                        editDetails(name);
                    } else {
                        System.out.println("Contact does not exists!");
                    }
                    break;
                case 3:
                    String name1 = getName();
                    if (isContactExist(name1)) {
                        Contacts contact = getContact(name1);
                        deleteContact(contact);
                    } else {
                        System.out.println("Contact does not exists!");
                    }
                    break;
                default:
                    //contactsFileIOService.writeToCSVFile();
                    System.out.println("Thanks!");
                    isExit = true;
            }
        }
    }
}
