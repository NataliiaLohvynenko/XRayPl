package org.example.RequestItems;

import org.example.models.JiraTestLink.Info;
import org.example.models.JiraTestLink.JiraTestLink;
import org.example.models.JiraTestLink.Test;

import java.util.Collections;
import java.util.List;

public class JiraTestLinkFactory {
    public static JiraTestLink createJiraTestLink(String testExecutionKey, List<Test> tests){
        JiraTestLink jiraTestLink = new JiraTestLink();
        Info info = new Info();
        info.setSummary("Test execution from automation");
        info.setDescription("Executed test from automation script");
        info.setProject("ORC");
        info.setTestEnvironments(Collections.singletonList("TEST"));
        jiraTestLink.setInfo(info);
        jiraTestLink.setTestExecutionKey(testExecutionKey);
        jiraTestLink.setTests(tests);
        return jiraTestLink;
    }
}
