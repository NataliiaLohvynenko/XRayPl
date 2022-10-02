package org.example.models.TestIssues;

import java.util.List;

public class TestIssues {
    private List<Success> success;

    public List<Success> getSuccess() {
        return success;
    }

    public void setSuccess(List<Success> success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "TestIssues{" +
                "success=" + success +
                '}';
    }
}
