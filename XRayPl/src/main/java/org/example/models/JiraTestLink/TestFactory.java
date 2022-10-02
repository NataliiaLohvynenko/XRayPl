package org.example.models.JiraTestLink;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

public class TestFactory {
    private static final Calendar calendar = Calendar.getInstance();

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static Test createTest(String testKey, String definition, String summary, Set<String> jiraStories){
        final  TestInfo testInfo = new TestInfo(

                summary
                ,"This test was created automatically"
                "Generic"
                ,definition
                ,"ORC"
                ,jiraStories
        );
        return  new Test("Executed tests"
        ,"PASS"
        ,formatter.format(calendar.getTime())
        ,formatter.format(calendar.getTime())
                ,testInfo
                ,testKey
        );
    }
}
