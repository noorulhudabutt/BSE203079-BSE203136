/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

import java.util.List;

public interface BookDAO {
    void create(Book book);
    Book read(int id);
    void update(Book book);
    void delete(int id);
    List<Book> getAllBooks();
    
    
}
