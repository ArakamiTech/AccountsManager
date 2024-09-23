package com.arakamitech.accountsmanager.logic.enums;

/**
 *
 * @author cristhian
 */
public enum GroupType {
    REDESSOCIALES("RedesSociales"),
    LAUNCHERS("Launchers"),
    OTROS("Otros");

    private final String displayName;

    GroupType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
