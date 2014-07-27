package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by yangjing on 14-7-27.
 */
public class Library {

    private ArrayList<Book> bookStorage = new ArrayList<Book>();
    private ArrayList<Book> lendBooks = new ArrayList<Book>();

    Library(){

    }

    Library(Library library){
        bookStorage.addAll(library.bookStorage);
        lendBooks.addAll(library.lendBooks);
    }

    public void addBookToLibrary(Book book){
        bookStorage.add(book);
    }

    public ArrayList<Book> getBooksByBookName(String bookname) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int temp=0; temp<bookStorage.size(); temp++){
            if(bookname.equals(bookStorage.get(temp).getName())){
                result.add(bookStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksByBookAuthor(String bookauthor) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int temp=0; temp<bookStorage.size(); temp++){
            if(bookauthor.equals(bookStorage.get(temp).getAuthor())){
                result.add(bookStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksByBookPress(String bookpress) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int temp=0; temp<bookStorage.size(); temp++){
            if(bookpress.equals(bookStorage.get(temp).getPress())){
                result.add(bookStorage.get(temp));
            }
        }
        return result;
    }

    public boolean lendbook(Book book1) {
        boolean result = false;
        if(isHaveGivenBookStorage(book1)){
            bookStorage.remove(book1);
            lendBooks.add(book1);
            result = true;
        }
        return result;
    }

    public int getCountsOfBooksInLibrary() {
        return bookStorage.size();
    }

    public int getCountsOfBooksOutLibrary() {
        return lendBooks.size();
    }

    public ArrayList<Book> getAllBooksFromLibrary() {
        return bookStorage;
    }

    public boolean isHaveGivenBookStorage(Book book1) {
        return bookStorage.contains(book1);
    }

    public boolean isHaveGivenBookLendBook(Book book3) {
        return lendBooks.contains(book3);
    }

    public boolean returnBook(Book book3) {
        boolean result = false;
        if(isHaveGivenBookLendBook(book3)){
            bookStorage.add(book3);
            lendBooks.remove(book3);
            result = true;
        }
        return result;
    }
}
