package com.example.szilsan.globerest.dto;

/**
 * Created by szilsan on 06/07/2017.
 */

public class Greeting {

    private String id;
    private String content;

    public Greeting() {

    }

    public Greeting(String id, String content) {
        this.id= id;
        this.content = content;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}