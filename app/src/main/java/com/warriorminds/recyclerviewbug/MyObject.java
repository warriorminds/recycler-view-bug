package com.warriorminds.recyclerviewbug;

/**
 * Created by rodrigo.guerrero on 7/1/2016.
 */
public class MyObject {
    private String title;
    private String description;

    public MyObject(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
