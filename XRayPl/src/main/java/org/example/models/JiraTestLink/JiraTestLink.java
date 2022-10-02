package org.example.models.JiraTestLink;

import java.util.List;

public class JiraTestLink {
    private Info info;
    private String testExecutionKey;
    private List<Test> tests;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getTestExecutionKey() {
        return testExecutionKey;
    }

    public void setTestExecutionKey(String testExecutionKey) {
        this.testExecutionKey = testExecutionKey;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "JiraTestLink{" +
                "info=" + info +
                ", testExecutionKey='" + testExecutionKey + '\'' +
                ", tests=" + tests +
                '}';
    }
}
