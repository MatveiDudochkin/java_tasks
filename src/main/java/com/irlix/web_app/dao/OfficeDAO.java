package com.irlix.web_app.dao;

import com.irlix.web_app.models.Manager;
import com.irlix.web_app.models.Worker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeDAO {
    private static int MANAGER_ID;
    private static int WORKER_ID;
    private final List<Manager> managers;
    private final List<Worker> workers;

    {
        managers = new ArrayList<>();
        managers.add(new Manager(++MANAGER_ID, "Nikolay", "Sidorov", 31, 8, new ArrayList<>()));
        managers.add(new Manager(++MANAGER_ID, "Ivan", "Kotelnikov", 40, 20, new ArrayList<>()));
    }

    {
        workers = new ArrayList<>();
        workers.add(new Worker(++WORKER_ID, "Vasya", "Ivanov", 30, 8, "java-developer", 1));
        workers.add(new Worker(++WORKER_ID, "Grisha", "Popov", 24, 5, "qe", 2));
        workers.add(new Worker(++WORKER_ID, "Ilya", "Gorshkov", 20, 2, "frontend", 2));
        workers.add(new Worker(++WORKER_ID, "Valera", "Lykianov", 36, 18, "devops", 1));
        workers.add(new Worker(++WORKER_ID, "Oleg", "Smirnov", 51, 25, "team-lead", 1));
    }

    public List<Manager> showManagerList() {
        return managers;
    }

    public List<Worker> showWorkerList() {
        return workers;
    }

    public Manager showManagerPage(int id) {
        return managers.stream().filter(manager -> manager.getId() == id).findAny().orElse(null);
    }

    public void createManager(Manager manager) {
        manager.setId(++MANAGER_ID);
        managers.add(manager);
    }
}
