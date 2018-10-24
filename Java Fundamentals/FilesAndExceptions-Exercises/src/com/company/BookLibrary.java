package com.company;
// Problem 09 and Problem 10
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookLibrary {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Book> booksList = new ArrayList<>();
        List<Library> libraryList = new ArrayList<>();
        int booksCount = Integer.parseInt(reader.readLine());
        String bufferDate = "";
        for (int i = 0; i <= booksCount; i++) {
            String[] input = reader.readLine().split(" ");

            if (i == booksCount) {
                bufferDate += input[0];
                break;
            }

            AddLibbraryList(libraryList, input, booksList);

        }

        HashMap<String, Double> authorMoney = new HashMap<>();
        AddLibbraryListInHashMap(authorMoney, libraryList);

        CreatNewTxtFileWithResultP09(authorMoney);
        BookLibraryModificationP10(booksList, bufferDate);

    }

    private static void BookLibraryModificationP10(List<Book> booksList, String bufferDate) throws ParseException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        TreeMap<String, Date> titleDate = new TreeMap<>();

        for (Book book : booksList) {
            Date date = df.parse(book.getReleaseData());

            if (!titleDate.containsKey(book.getTitle())) {
                titleDate.put(book.getTitle(), date);
            }
        }

        Date checkDate = df.parse(bufferDate);
        LinkedHashMap<String, Date> result = new LinkedHashMap<>();
        titleDate.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).filter(b -> b.getValue().after(checkDate)).forEach(d -> {
            result.put(d.getKey(), d.getValue());
//                System.out.println(String.format(d.getKey() + " -> " + df.format(d.getValue())));
        });

        Writer writerOtput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP10.txt"), "utf-8"));
        {
            for (String book : result.keySet()) {
                writerOtput.write(String.format("%s -> " + df.format(result.get(book)) + "%n", book));
            }
        }
        writerOtput.close();
    }

    private static void CreatNewTxtFileWithResultP09(HashMap<String, Double> authorMoney) throws IOException {
        Writer writerResult = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP09.txt"), "utf-8"));
            {
                for (String author : authorMoney.keySet()) {
                    writerResult.write(String.format("%s -> %.2f%n", author, authorMoney.get(author)));
                }
            }
            writerResult.close();
    }

    private static void AddLibbraryListInHashMap(HashMap<String, Double> authorMoney, List<Library> libraryList)
    {
        for (Library library : libraryList) {
            if (!authorMoney.containsKey(library.getName())) {
                authorMoney.put(library.getName(), library.getPrice());
            } else {
                double money = authorMoney.get(library.getName());
                money += library.getPrice();
                authorMoney.replace(library.getName(), money);
            }
        }
    }

    private static void AddLibbraryList(List<Library> libraryList, String[] input, List<Book> booksList)
    {
        Book book = new Book();
        Library library = new Library();

        library.setName(input[1]);
        library.setPrice(Double.parseDouble(input[input.length - 1]));

        book.setTitle(input[0]);
        book.setAuthor(input[1]);
        book.setPublisher(input[2]);
        book.setReleaseData(input[3]);
        book.setiSBN(input[4]);
        book.setPrice(Double.parseDouble(input[5]));

        booksList.add(book);
        libraryList.add(library);

    }
}
class Library {
    private String name;
    private Double price;

//    public Library(String name, List<Book> books) {
//        this.name = name;
//        this.books = books;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
class Book {
    private String title;
    private String author;
    private String publisher;
    private String releaseData;
    private String iSBN;
    private Double price;

//    public Book(String title, String author, String publisher, String releaseData, String iSBN, Double price) {
//        this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//        this.releaseData = releaseData;
//        this.iSBN = iSBN;
//        this.price = price;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}