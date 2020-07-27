package com.example.card.domain.model;

public class VerifyResultVO {
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public VerifyResultVO(String result) {
        this.result = result;
    }
}
