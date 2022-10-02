package org.example.models.JiraTestLink;

import java.util.Set;

public class TestInfo {
    private String summary;
    private String description;
    private String testType;
    private String definition;
    private String projectKey;
    private Set<String> requirementKeys;

    public TestInfo(String summary, String description, String testType, String definition, String projectKey, Set<String> requirementKeys) {
        this.summary = summary;
        this.description = description;
        this.testType = testType;
        this.definition = definition;
        this.projectKey = projectKey;
        this.requirementKeys = requirementKeys;
    }

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

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public Set<String> getRequirementKeys() {
        return requirementKeys;
    }

    public void setRequirementKeys(Set<String> requirementKeys) {
        this.requirementKeys = requirementKeys;
    }

    @Override
    public String toString() {
        return "TestInfo{" +
                "summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", testType='" + testType + '\'' +
                ", definition='" + definition + '\'' +
                ", projectKey='" + projectKey + '\'' +
                ", requirementKeys=" + requirementKeys +
                '}';
    }
}
