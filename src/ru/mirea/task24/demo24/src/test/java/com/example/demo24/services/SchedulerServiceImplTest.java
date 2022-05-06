package com.example.demo24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class SchedulerServiceImplTest {
    private final String BACKUP_DIR = "src/ru/mirea/task24/demo24/backups/";
    private SchedulerService underTest;

    @Mock
    private GroupService groupService;
    @Mock
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        underTest = new SchedulerServiceImpl(studentService, groupService);
    }

    @Test
    @Disabled
    void backupFromDatabase() throws IOException {



    }
}