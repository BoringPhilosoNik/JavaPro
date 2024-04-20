package org.example.Task2;

import java.util.List;

public class Organization {
    private List<Worker> worker;
    private int id;

    public Organization(List<Worker> worker, int id) {
        this.worker = worker;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }
}


