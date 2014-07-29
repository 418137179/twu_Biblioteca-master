package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-25.
 */
public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookPress;
    private People bookOwner;

    Book(){
        this.bookOwner = new People("library","library","library","library","library");
    }

    Book(Book book) {
        bookName = book.bookName;
        bookAuthor = book.bookAuthor;
        bookPress = book.bookPress;
        bookOwner = book.bookOwner;
    }
    Book(String bookname,String bookauthor,String bookpress) {
        this.bookName = bookname;
        this.bookAuthor = bookauthor;
        this.bookPress = bookpress;
        this.bookOwner = new People("library","library","library","library","library");

    }
    public void setBookName(String bookname) {
        this.bookName = bookname;
    }

    public void setBookAuthor(String bookauthor) {
        this.bookAuthor = bookauthor;
    }

    public void setBookPress(String bookpress) {
        this.bookPress = bookpress;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.bookName.equals(book.bookName)
                    && this.bookAuthor.equals(book.bookAuthor)
                    && this.bookPress.equals(book.bookPress)
                    && this.bookOwner.equals(book.bookOwner);
        }
        return super.equals(obj);
    }


    public String getName() {
        return bookName;
    }

    public String getAuthor() {
        return bookAuthor;
    }

    public String getPress() {
        return bookPress;
    }

    public void setBookOwner(People people) {
        this.bookOwner = people;
    }

    public People getOwner() {
        People result = new People(bookOwner);
        result.setPassword("");
        return result;
    }
}
