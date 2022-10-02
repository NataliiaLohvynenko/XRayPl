package org.example.RestApi;


import org.apache.maven.plugin.logging.Log;
import org.example.models.JiraXmlResponse.JiraSendTestResultXmlResponse;
import org.example.ParamReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

public class JiraSendTestResultXmlRequest extends JiraRequestAbstract<JiraSendTestResultXmlResponse> {
    private static final String UT_XUNIT_REPORTER_PATH = ParamReader.getParameter("UT_XUNIT_REPORTER_patch");

    public JiraSendTestResultXmlRequest(Log log){
        super(log, JiraSendTestResultXmlResponse.class);
        jiraRequestLink=ParamReader.getParameter("jiraXrayProjectLink");
    }

    @Override
    protected HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = super.getHttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        return httpHeaders;
    }
    @Override
    protected HttpEntity<LinkedMultiValueMap<String, Object>> getHttpEntity() {
       LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
       map.add("file", new FileSystemResource(UT_XUNIT_REPORTER_PATH));

    return new HttpEntity<>(map, getHttpHeaders());
    }
}
