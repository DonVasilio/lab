package com.example.demo.model;

public class SubjectType {
    private String subject;
    private String type;

    public SubjectType(String subject, String type)
    {
        this.subject=subject;
        this.type=type;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
