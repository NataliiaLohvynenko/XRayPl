package org.example;

import org.apache.maven.plugin.logging.Log;
import org.example.RequestItems.JiraTestLinkFactory;
import org.example.RestApi.JiraSummaryRequest;
import org.example.RestApi.JiraTestLinkRequest;
import org.example.WorkItems.JiraWorkItems;
import org.example.models.JiraStorySummaryResponse;
import org.example.models.JiraTestLink.JiraTestLink;
import org.example.models.JiraTestLink.Test;
import org.example.models.JiraTestLink.TestFactory;
import org.example.models.JiraTestLinkResponse.TestIssues.TestIssues.JiraTestLinkResponse;
import org.example.models.JiraXmlResponse.JiraSendTestResultXmlResponse;
import org.example.RestApi.JiraSendTestResultXmlRequest;
import org.example.models.TestIssues.Success;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.rmi.server.RemoteServer.getLog;


public class TestApp {
    public static void main(String[] args) {

final String SCRIPT_DIRECTORY = ParamReader.getParameter("scriptDirectory"); //private static final


        final Set<String> workItemFromRelease = getWorkItemsFromRelease();
       // getLog().info(String.format("extracted stories %s", String.join("," ,workItemFromRelease)));



        //Sending UT_XUNIT_REPORTER
       // getLog().info("Sending UT_XUNIT_REPORTER ...");
        final JiraSendTestResultXmlRequest jiraSendTestResultXmlRequest = new JiraSendTestResultXmlRequest((Log) getLog()); //new JiraSendTestResultXmlRequest(getLog());
        final JiraSendTestResultXmlResponse jiraSendTestResultXmlResponse = jiraSendTestResultXmlRequest.getResponsePost();

        final String testExecIssueKey = jiraSendTestResultXmlResponse.getTestExecIssue().getKey();

        //Taking Jira Test keys from response
        final List<String> jiraTestItemKeys = jiraSendTestResultXmlResponse.getTestIssues().getSuccess().stream().map(Success::getKey).collect(Collectors.toList());
        //getLog().info(String.format("Created jira test items: %s",jiraTestItemKeys));

        //building jiraTestLink between test execution and created tests

        final JiraSummaryRequest jiraSummaryRequest = new JiraSummaryRequest(); //(getLog());
        final List<Test> tests = new ArrayList<>();

        for (String jiraTestItemKey : jiraTestItemKeys){
            final JiraStorySummaryResponse jiraStorySummaryResponse = jiraSummaryRequest.getJiraStorySummaryResponse(jiraTestItemKey);

            tests.add(TestFactory.createTest(jiraTestItemKey, jiraStorySummaryResponse.getFieldsObject().getCustomfield_16603(),jiraStorySummaryResponse.getFieldsObject().getSummary(), workItemFromRelease));
        }
        final JiraTestLink jiraTestLink = JiraTestLinkFactory.createJiraTestLink(testExecIssueKey, tests);

        final JiraTestLinkRequest jiraTestLinkRequest = new JiraTestLinkRequest((Log) getLog(), jiraTestLink);//new JiraTestLinkRequest(getLog(), jiraTestLink);
        final JiraTestLinkResponse jiraTestLinkResponse = jiraTestLinkRequest.getResponsePost();
        ((Log) getLog()).info("SUCCESS" + jiraTestLinkResponse);


    }

    private static Set<String> getWorkItemsFromRelease() {
        final Set<String> workItems = getWorkItemsFromReleaseFile("file_release_ddl");
        workItems.addAll(getWorkItemsFromReleaseFile("file_release_dml"));

        return workItems;
    }

    private static Set<String> getWorkItemsFromReleaseFile(String parameterFileName) {
        final String SCRIPT_DIRECTORY = ParamReader.getParameter("scriptDirectory");
        final String releaseFileName = ParamReader.getParameter(parameterFileName);
        final Path releaseFilePath = Paths.get(".",SCRIPT_DIRECTORY, releaseFileName);
        // getLog().info(String.format("Reading file %s", releaseFilePath));
        if(Files.exists(releaseFilePath)&&!Files.isDirectory(releaseFilePath)){
            final Set<String> workItemsFromRelease = JiraWorkItems.getWorkItemsFromRelease(releaseFilePath);
            //getLog().debug(String.format(("Extracted stories, file %s, items: %s", releaseFileName,workItemsFromRelease)));
            return workItemsFromRelease;

        }else
        {
            //  getLog().warn(String.format("Release file %s not exists", releaseFileName));
            return Collections.emptySet();
        }
    }



    }

