package org.example.models.JiraTestLink;

public class Test {

    private String comment;
    private String status;
    private String start;
    private String finish;
    private TestInfo testInfo;
    private String testKey;

    public Test(String comment, String status, String start, String finish, TestInfo testInfo, String testKey) {
        this.comment = comment;
        this.status = status;
        this.start = start;
        this.finish = finish;
        this.testInfo = testInfo;
        this.testKey = testKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public TestInfo getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    public String getTestKey() {
        return testKey;
    }

    public void setTestKey(String testKey) {
        this.testKey = testKey;
    }

    @Override
    public String toString() {
        return "Test{" +
                "comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", testInfo=" + testInfo +
                ", testKey='" + testKey + '\'' +
                '}';
    }
}
