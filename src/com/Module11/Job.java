package com.Module11;

/**
 * This class is for the print Job object which concist of a unique Job ID, and Job Print TIme
 */
public class Job {

    private int id;
    private long printTime;

    /**
     * @param id This is the unique Job Id
     * @param printTime This is the print time for the job
     */
    public Job(int id, long printTime) {
        this.id = id;
        this.printTime = printTime;
    }

    /**
     * @return The print job id is returned
     */
    public int getId() {
        return id;
    }

    /**
     * @return The print time of the job is returned
     */
    public long getPrintTime() {
        return printTime;
    }
}
