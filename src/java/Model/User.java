/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Junior
 */
        
public class User {
    private String lastName;
    private String firstName;
    private String email;
    private String gender;
    private String pwd;
    private String tel;
    private String date_creat;
    private String status;
    private boolean is_admin; 
    private String company;
    
    public User() {
        
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
