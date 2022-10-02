package org.example.RestApi;

import org.springframework.http.HttpEntity;
import org.apache.maven.plugin.logging.Log;
import org.example.ParamReader;
import org.example.models.JiraStorySummaryResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpServerErrorException;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


public class JiraSummaryRequest extends JiraRequestAbstract<JiraStorySummaryResponse>{
    public JiraSummaryRequest(Log log){
        super(log, JiraStorySummaryResponse.class);
        jiraRequestLink = ParamReader.getParameter("jiraItemGetSummaryLink");

    }

    public JiraSummaryRequest(){
        super(JiraStorySummaryResponse.class);
        jiraRequestLink = ParamReader.getParameter("jiraItemGetSummaryLink");

    }

    @Override
    protected org.springframework.http.HttpEntity<LinkedMultiValueMap<String, Object>> getHttpEntity(){return new HttpEntity<>(getHttpHeaders());
    }

    private String getJiraItemGetSummaryLink(String jiraTestItemKey){
        return jiraRequestLink.replace("$$jiraTestItemKey$$", jiraTestItemKey);
    }

    public JiraStorySummaryResponse getJiraStorySummaryResponse(String jiraTestItemKey){
        String jiraItemGetSummaryLink = getJiraItemGetSummaryLink(jiraTestItemKey);
        log.info(String.format("Sending message to %s", jiraItemGetSummaryLink));
        try{

            ResponseEntity<JiraStorySummaryResponse> jiraStorySummaryResponseEntity=buildRestTemplate().exchange(jiraItemGetSummaryLink, HttpMethod.GET, getHttpEntity(), JiraStorySummaryResponse.class);
            log.info(String.format(" Response: %s", jiraStorySummaryResponseEntity.toString()));
            return  jiraStorySummaryResponseEntity.getBody();
        }catch (HttpServerErrorException e){
            log.error("Incorrect request"+e.getResponseBodyAsString());
            e.printStackTrace();
        }catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e){
            e.printStackTrace();
        }
        return null;

    }

}
