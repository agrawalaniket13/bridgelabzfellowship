package com.addressbook;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


public class CSVFileHandler {
    private static final String FILE_NAME = "Contacts.csv";

    public void csvWriter(List<Contacts> contactsList) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        Writer writer = Files.newBufferedWriter(Paths.get(FILE_NAME));
        StatefulBeanToCsv<Contacts> statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(',')
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build();
        System.out.println("in CSVHandler: "+contactsList);
        statefulBeanToCsv.write(contactsList);
        writer.close();
    }
}
