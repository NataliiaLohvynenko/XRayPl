package org.example.models;

public class JiraStorySummaryResponse {
    private String expand;
    private String id;
    private String self;
    private String key;
    private Fields FieldsObject;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Fields getFieldsObject() {
        return FieldsObject;
    }

    public void setFieldsObject(Fields fieldsObject) {
        FieldsObject = fieldsObject;
    }

    @Override
    public String toString() {
        return "JiraStorySummaryResponse{" +
                "expand='" + expand + '\'' +
                ", id='" + id + '\'' +
                ", self='" + self + '\'' +
                ", key='" + key + '\'' +
                ", FieldsObject='" + FieldsObject + '\'' +
                '}';
    }
}
