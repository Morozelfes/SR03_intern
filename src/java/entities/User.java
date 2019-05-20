/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Junior
 */
public class User {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String gender="male";
    private String pwd;
    private String tel;
    private String date_creat;
    private String status="inactif";
    private boolean is_admin=false; 
    private String company;
    
    public User() {
        User.this.id = 0;
        User.this.company = "default";
        User.this.firstName = "default";
        User.this.lastName = "default";
        User.this.tel = "default";
        User.this.email = "default";
        User.this.pwd = "default";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.date_creat = dateFormat.format(date);
    }
    
    public User(int id, String lastName, String firstName, String email, String pwd, String tel, String company, String date_creat) {
        User.this.id = id;
        User.this.lastName = lastName;
        User.this.firstName = firstName;
        User.this.email = email;
        User.this.pwd = pwd;
        User.this.tel = pwd;
        User.this.company = company;
        User.this.date_creat = date_creat;
    }
    
    public User(String lastName, String firstName, String email, String pwd, String tel, String company, String date_creat, boolean is_admin, String status, String gender) {
        User.this.lastName = lastName;
        User.this.firstName = firstName;
        User.this.email = email;
        User.this.pwd = pwd;
        User.this.tel = tel;
        User.this.company = company;
        User.this.date_creat = date_creat;
        User.this.is_admin = is_admin;
        User.this.status = status;
        User.this.gender = gender;
    }

    public User(String lastName, String firstName, String email, String gender, String pwd, String tel, boolean is_admin, String company) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.gender = gender;
        this.pwd = pwd;
        this.is_admin = is_admin;
        this.date_creat = dateFormat.format(date);
        this.tel = tel;
        this.status = "actif";
        this.company = company;
    }

    public User(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDate_creat() {
        return date_creat;
    }

    public void setDate_creat(String date_creat) {
        this.date_creat = date_creat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setAdmin(boolean is_admin) {
        this.is_admin = is_admin;
    }
       
    @Override
    public String toString() {
        return "User{" + "lastname=" + lastName + ", firstName=" + firstName + ", email=" + email +  ", gender=" + gender + ", pwd=" + pwd + ", tel=" + tel + ", status=" + status + ", date de création=" + date_creat + ", admin=" + is_admin + ", company=" + company + ')';
    }
}
