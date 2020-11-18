package com.company.cafemanager.entity.user;

public enum Role {
    MANAGER("manager"), WAITER("waiter");

    private final String displayName;

    Role(String type) {
        this.displayName = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Role getEnumByValue(String value) {
        if (value.equals("manager")) {
            return Role.MANAGER;
        } else if (value.equals("waiter")) {
            return Role.WAITER;
        }
        throw new IllegalArgumentException("There is no Enum with this value");
    }

    @Override
    public String toString() {
        return displayName;
    }
}
