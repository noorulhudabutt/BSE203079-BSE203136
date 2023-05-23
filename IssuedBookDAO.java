/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

import java.util.List;

public interface IssuedBookDAO {
    void create(IssuedBook issuedBook);
    IssuedBook read(int id);
    void update(IssuedBook issuedBook);
    void delete(int id);
    List<IssuedBook> getAllIssuedBooks();
}
