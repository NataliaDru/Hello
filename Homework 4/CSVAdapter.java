package com.company;

import java.io.*;

class CSVAdapter<T> {
    protected Class value;
    protected FileReader fileReader;
    protected FileWriter fileWriter;

    /*
    read- функция для получения автора при считывании CSV-файла(по номеру строки)
    @param line номер нужной строки
    @return author экземпляр класса Author с данными из файла
     */
    public Author read(int line) throws IOException {
        Author author = new Author(); //создаем экземпляр класса
        BufferedReader lineReader = new BufferedReader(fileReader); //оборачиваем FileReader в BufferedReader для удобства(позволяет считывать строки)

        String readLine = null;
        int i = 0;
        while ((readLine = lineReader.readLine()) != null) {
            if (i == line) {
                author.setName(readLine.split("\\,")[0]);
                author.setBirthPlace(readLine.split("\\,")[1]);
                break;
            }
            i++;
        }

        return author;
    }

    /*
    append- функция для добавления автора в файл
    @param author - данные автора для записи
    @return lines количество строк в файле
     */
    public int append(Author author) throws IOException {
        BufferedReader reader = new BufferedReader(fileReader);
        int lines = 0;
        while (reader.readLine() != null) {
            lines++;
        }

        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        buffWriter.write("\n" + author.getName() + "," + author.getBirthPlace());

        buffWriter.flush(); //применить изменения
        return ++lines;
    }
    public void close() throws IOException {
        fileWriter.close();
        fileWriter.close();
    }

}

class CSVAdapterImpl<T> extends CSVAdapter<T> {
    //создаем свой конструктор
    public CSVAdapterImpl(Class _class, FileReader _fileReader, FileWriter _fileWriter) {
        super.value = _class;
        super.fileReader = _fileReader;
        super.fileWriter = _fileWriter;
    }
}