/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import java.util.ArrayList;

public class User {

    private String name;
    private String password;
    private String email;

    List<Sudoku> sudokus = new ArrayList<>();

    public void setSudokus(Sudoku sudokus) {
        this.sudokus.add(sudokus);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public List<Sudoku> getSudokus() {
        return sudokus;
    }
}
