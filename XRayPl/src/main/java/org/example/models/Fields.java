package org.example.models;

public class Fields {
    private String summary;
    private String customfield_16603;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCustomfield_16603() {
        return customfield_16603;
    }

    public void setCustomfield_16603(String customfield_16603) {
        this.customfield_16603 = customfield_16603;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "summary='" + summary + '\'' +
                ", customfield_16603='" + customfield_16603 + '\'' +
                '}';
    }
}
