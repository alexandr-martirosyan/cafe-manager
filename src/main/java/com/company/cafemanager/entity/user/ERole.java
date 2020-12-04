package com.company.cafemanager.entity.user;

public enum ERole {
    MANAGER("manager"), WAITER("waiter");

    private final String displayName;

    ERole(String type) {
        this.displayName = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ERole getEnumByValue(String value) {
        if (value.equals("manager")) {
            return ERole.MANAGER;
        } else if (value.equals("waiter")) {
            return ERole.WAITER;
        }
        throw new IllegalArgumentException("There is no Enum with this value");
    }

    @Override
    public String toString() {
        return displayName;
    }
}
