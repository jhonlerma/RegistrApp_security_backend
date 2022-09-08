package com.group2.RegistrApp_security_backend.enums;

public enum Method {
    get("get"), post("post"),put("put"), delete("delete");
    private final String text;

    Method(String text) {
        this.text = text;
    }
}
