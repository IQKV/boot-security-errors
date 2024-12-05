package com.iqkv.boot.security.errors;

import java.io.Serial;

@SuppressWarnings("java:S110") // Inheritance tree of classes should not be too deep
public class LoginAlreadyUsedException extends BadRequestAlertException {

  @Serial
  private static final long serialVersionUID = 1L;

  public LoginAlreadyUsedException() {
    super(SecurityErrorConstants.LOGIN_ALREADY_USED_TYPE, "Login name already used!", "userManagement", "userexists");
  }
}
