/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

public class IssuedBook {
    private int id;
    private int bookId;
    private int userId;
    private int period;
    private String issueDate;
    
     public IssuedBook(int id, int bookId, int userId, int period, String issueDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.period = period;
        this.issueDate = issueDate;
    }

     IssuedBook()
     {
         
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
