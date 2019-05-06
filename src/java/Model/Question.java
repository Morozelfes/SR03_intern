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
public class Question {
    private int key;
    private String statement;
    private String status;

    public Question(int key, String statement, String status) {
        this.key = key;
        this.statement = statement;
        this.status = status;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
    
    @Override   
    public String toString() {
        return "Question(" + "key= " + key + ", statement= " + statement + ", status= " + status + ")" ;
    }
}
