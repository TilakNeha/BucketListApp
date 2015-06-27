package com.example.nehatila.studentlist;
/**
 * Created by nehatila on 6/26/2015.
 */
public class BucketTask {
    private String taskName;
    private String taskLocation;
    private String taskType;

    public BucketTask(String taskName, String taskLocation, String taskType) {
        this.taskName = taskName;
        this.taskLocation = taskLocation;
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskLocation() {
        return taskLocation;
    }

    public void setTaskLocation(String taskLocation) {
        this.taskLocation = taskLocation;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
