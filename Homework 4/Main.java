package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static junit.framework.TestCase.assertEquals;

public class Main {


    public static void main(String[] args) throws IOException {

        File file = new File("D:/Authors.csv");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file, true);

        CSVAdapter<Author> authorCsvAdapter = new CSVAdapterImpl<Author>(Author.class, fileReader, fileWriter);

        Author author = authorCsvAdapter.read(0);
        assertEquals("Лев Николаевич Толстой", author.getName());
        assertEquals("Ясная Поляна", author.getBirthPlace());

        Author authorNew = new Author();
        authorNew.setName("Некоторый Автор");
        authorNew.setBirthPlace("Некоторый Город");

        int rowIndex = authorCsvAdapter.append(authorNew);

        Author authorNewOpened = authorCsvAdapter.read(rowIndex);

        assertEquals("Некоторый Автор", authorNewOpened.getName());
        assertEquals("Некоторый Город", authorNewOpened.getBirthPlace());
        authorCsvAdapter.close();

    }
}


