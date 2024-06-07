package com.example.apptodo;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String description;
    private String status;
    private String date;
    private String duration;

    public Task(String title, String description, String status, String date, String duration) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
        this.duration = duration;
    }

    // Getters and setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        // Return the date in the french format
        String[] dateParts = date.split("-");
        return dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0];
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
