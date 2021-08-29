package com.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class ContactsFileIoServices {
    public static String ADDRESS_BOOK_FILE_NAME = "Contacts.txt";

    /**
     * writes to a CSV file
     * @param contactsList
     */
    public void writeToCSVFile(List<Contacts> contactsList) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        csvFileHandler.csvWriter(contactsList);
    }

    /**
     * writes to a text file
     * @param contactsList
     */
    public void writeToFile(List<Contacts> contactsList) {
        StringBuffer contactBuffer = new StringBuffer();
        contactsList.forEach(contacts -> {
            String contact = contacts.toString().concat("\n");
            contactBuffer.append(contact);
        });
        try {
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
