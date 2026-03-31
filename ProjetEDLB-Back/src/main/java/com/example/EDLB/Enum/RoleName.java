package com.example.EDLB.Enum;

public enum RoleName {
  ROLE_ADMIN("Admin"),
  ROLE_USER("User"),
  ROLE_MERCH_MANAGER("Merch Manager"),
  ROLE_DOCS_MANAGER("Document Manager"),
  ROLE_MODERATOR("Moderator"),
  ROLE_DEV("Developer"),
  ROLE_DOG_OWNER("Dog Owner"),
  ROLE_NEW_REGISTRED("New Register"),
  ROLE_CUSTOMER("Customer");
  
  final private String dbValue;

    RoleName(String dbValue) {
      this.dbValue = dbValue;
    }

    public String getDbValue() {
      return dbValue;
    }
}
