package org.example.models.JiraTestLink;

import java.util.List;

public class Info {
    private String summary;
    private String description;
    private String project;

    private List<String> testEnvironments;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<String> getTestEnvironments() {
        return testEnvironments;
    }

    public void setTestEnvironments(List<String> testEnvironments) {
        this.testEnvironments = testEnvironments;
    }

    @Override
    public String toString() {
        return "Info{" +
                "summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", project='" + project + '\'' +
                ", testEnvironments=" + testEnvironments +
                '}';
    }
}
