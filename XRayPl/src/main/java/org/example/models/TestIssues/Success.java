package org.example.models.TestIssues;

public class Success {
    String id;
    String key;
    String self;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "Success{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", self='" + self + '\'' +
                '}';
    }
}
