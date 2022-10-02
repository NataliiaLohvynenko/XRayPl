package org.example.models.JiraXmlResponse;

import org.example.models.TestIssues.TestExecIssue;
import org.example.models.TestIssues.TestIssues;

import java.util.ArrayList;
import java.util.List;

public class JiraSendTestResultXmlResponse {
    private TestExecIssue testExecIssueObject;

    private TestIssues TestIssuesObject;

    List<String> infoMessages = new ArrayList<>();

    public TestExecIssue getTestExecIssue() {
        return testExecIssueObject;
    }

    public void setTestExecIssueObject(TestExecIssue testExecIssueObject) {
        this.testExecIssueObject = testExecIssueObject;
    }

    public TestIssues getTestIssues() {
        return TestIssuesObject;
    }

    public void setTestIssuesObject(TestIssues testIssuesObject) {
        TestIssuesObject = testIssuesObject;
    }

    public List<String> getInfoMessages() {
        return infoMessages;
    }

    public void setInfoMessages(List<String> infoMessages) {
        this.infoMessages = infoMessages;
    }

    @Override
    public String toString() {
        return "JiraSendTestResultXmlResponse{" +
                "TestExecIssuePbject=" + testExecIssueObject +
                ", TestIssuesObject=" + TestIssuesObject +
                ", infoMessages=" + infoMessages +
                '}';
    }


}
