package com.example.cp24.bucketdrops.beans;

/**
 * Created by cp24 on 2017-06-11.
 */

public class Drop {
    private String what;
    private long added;
    private long when;
    private boolean completed;

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}