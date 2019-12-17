package com.example.finalproject1.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "User")
public class User extends Model {
    @Column(name = "name")
    public String name;

    @Column(name = "pass")
    public String pass;

    public User(){
        super();
    }

    public User(String name, String pass){
        super();
        this.name = name;
        this.pass = pass;
    }

    /*private static boolean findUser(String name, String pass){
        return new Select().from(User.class).where("name = ?", name).where("pass = ?", pass).exists();
    }*/

}
