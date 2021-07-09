package org.openjfx.farmacia.controller;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    List<String> logs;

    public Logs() {
        this.logs = new ArrayList<>();
    }

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }
}
