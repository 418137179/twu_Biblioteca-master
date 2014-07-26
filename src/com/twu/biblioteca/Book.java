package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-25.
 */
public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookPress;

    Book() {

    }
    Book(String bookname,String bookauthor,String bookpress) {
        bookName = bookname;
        bookAuthor = bookauthor;
        bookPress = bookpress;
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
                    && this.bookPress.equals(book.bookPress);
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
}
