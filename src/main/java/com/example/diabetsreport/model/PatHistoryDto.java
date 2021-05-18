package com.example.diabetsreport.model;

public class PatHistoryDto {
    private Long patId;
    private String e;

    public PatHistoryDto() {
    }

    public PatHistoryDto(Long patId, String e) {
        this.patId = patId;
        this.e = e;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
