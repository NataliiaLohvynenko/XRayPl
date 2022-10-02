package org.example.models.JiraTestLinkResponse.TestIssues.TestIssues;

import org.example.models.JiraTestLinkResponse.TesstExecIssue;
import org.example.models.TestIssues.TestIssues;

public class JiraTestLinkResponse {
    private TesstExecIssue tesstExecIssue;
    private TestIssues testIssues;

    public TesstExecIssue getTesstExecIssue() {
        return tesstExecIssue;
    }

    public void setTesstExecIssue(TesstExecIssue tesstExecIssue) {
        this.tesstExecIssue = tesstExecIssue;
    }

    public TestIssues getTestIssues() {
        return testIssues;
    }

    public void setTestIssues(TestIssues testIssues) {
        this.testIssues = testIssues;
    }

    @Override
    public String toString() {
        return "JiraTestLinkResponse{" +
                "tesstExecIssue=" + tesstExecIssue +
                ", testIssues=" + testIssues +
                '}';
    }
}
