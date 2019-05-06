/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Junior
 */
public class Form {
	private String subject;
	private String status;

    public Form(String subject) {
        this.subject = subject;
        this.subject = "actif";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    @Override   
    public String toString() {
        return "Form(" + "subject= " + subject + ", status= " + status + ")" ;
    }
    
}
