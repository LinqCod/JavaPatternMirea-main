package com.example.demo22.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SchedulerService {
    void backupFromDatabase() throws IOException;
}
