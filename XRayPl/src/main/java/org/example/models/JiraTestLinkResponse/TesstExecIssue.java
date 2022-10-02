package org.example.models.JiraTestLinkResponse;

public class TesstExecIssue {
    private String id;
    private String Key;
    private String self;

    public TesstExecIssue(){}

    public TesstExecIssue(String id, String key, String self) {
        this.id = id;
        Key = key;
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "TesstExecIssue{" +
                "id='" + id + '\'' +
                ", Key='" + Key + '\'' +
                ", self='" + self + '\'' +
                '}';
    }
}
