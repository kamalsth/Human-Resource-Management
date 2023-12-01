package com.grpc.hrm.adapter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner {

    private final TableCreation tableCreation;

    public AppStartupRunner(TableCreation tableCreation) {
        this.tableCreation = tableCreation;
    }


    @Override
    public void run(String... args) throws Exception {
        tableCreation.createTableIfNotExist();
    }
}