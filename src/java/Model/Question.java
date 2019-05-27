/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class Question {
    private int id;
    private String statement;
    private String status;
    private ArrayList<Answer> answers;
    
    public Question(){}

    public Question(int id, String statement, String status, ArrayList<Answer> answers) {
        this.id = id;
        this.statement = statement;
        this.status = status;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
    
    @Override   
    public String toString() {
        return "Question(" + "id= " + id + ", statement= " + statement + ", status= " + status + ")" ;
    }
}
