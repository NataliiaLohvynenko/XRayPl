package org.example.RestApi;

import org.example.ParamReader;
import org.example.models.JiraTestLink.JiraTestLink;
import org.example.models.JiraTestLinkResponse.TestIssues.TestIssues.JiraTestLinkResponse;
import org.apache.maven.plugin.logging.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class JiraTestLinkRequest extends JiraRequestAbstract<JiraTestLinkResponse>{
    private final JiraTestLink jiraTestLink;

    public JiraTestLinkRequest(Log log, JiraTestLink jiraTestLink){
        super(log, JiraTestLinkResponse.class);
        jiraRequestLink = ParamReader.getParameter("jiraXrayTestExecutionLink");
        this.jiraTestLink = jiraTestLink;
    }

    @Override
    protected HttpHeaders getHttpHeaders(){
        HttpHeaders headers = super.getHttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Override
    protected HttpEntity getHttpEntity(){return new HttpEntity<>(jiraTestLink, getHttpHeaders());}

}
