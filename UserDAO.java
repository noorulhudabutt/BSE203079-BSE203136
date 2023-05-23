/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

import java.util.List;

public interface UserDAO {
    void create(User user);
    User read(int id);
    void update(User user);
    void delete(int id);
    List<User> getAllUsers();
}
