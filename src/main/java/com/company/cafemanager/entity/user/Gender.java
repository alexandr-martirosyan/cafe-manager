package com.company.cafemanager.entity.user;

public enum Gender {
    MALE("male"), FEMALE("female");

    private final String displayName;

    Gender(String type) {
        this.displayName = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Gender getEnumByValue(String value) {
        if (value.equals("male")) {
            return Gender.MALE;
        } else if (value.equals("female")) {
            return Gender.FEMALE;
        }
        throw new IllegalArgumentException("There is no Enum with this value");
    }

    @Override
    public String toString() {
        return displayName;
    }
}