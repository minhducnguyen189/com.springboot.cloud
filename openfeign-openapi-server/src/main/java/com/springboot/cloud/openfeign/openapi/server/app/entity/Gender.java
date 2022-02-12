package com.springboot.cloud.openfeign.openapi.server.app.entity;

public enum Gender {

    M, F;

    public static Gender toGender(String genderStr) {
        return Gender.valueOf(genderStr);
    }

}
