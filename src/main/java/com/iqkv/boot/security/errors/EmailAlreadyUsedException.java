package com.iqkv.boot.security.errors;

import java.io.Serial;

@SuppressWarnings("java:S110") // Inheritance tree of classes should not be too deep
public class EmailAlreadyUsedException extends BadRequestAlertException {

  @Serial
  private static final long serialVersionUID = 1L;

  public EmailAlreadyUsedException() {
    super(SecurityErrorConstants.EMAIL_ALREADY_USED_TYPE, "Email is already in use!", "userManagement", "emailexists");
  }
}
