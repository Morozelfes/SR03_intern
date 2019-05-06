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
public class Answer {
    private int key;
    private String statement;
    private String status;
    private int rank;
    private boolean is_right;
    private int question_id;

    public Answer(int key, String statement, String status, int rank, boolean is_right, int question_id) {
        this.key = key;
        this.statement = statement;
        this.status = status;
        this.rank = rank;
        this.is_right = is_right;
        this.question_id = question_id;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isIs_right() {
        return is_right;
    }

    public void setIs_right(boolean is_right) {
        this.is_right = is_right;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
    
    @Override   
    public String toString() {
        return "Answer(" + "key= " + key + ", statement= " + statement + ", status= " + status + ", rank=" + rank + "right= " + is_right + "question_id= " + question_id + ")" ;
    }
}
