/*
 * Copyright 2024 IQKV Team, and the original author or authors from the JHipster project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iqkv.boot.security.errors;

import java.io.Serial;
import java.net.URI;

import com.iqkv.boot.security.errors.ProblemDetailWithCause.ProblemDetailWithCauseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

@SuppressWarnings("java:S110") // Inheritance tree of classes should not be too deep
public class BadRequestAlertException extends ErrorResponseException {

  @Serial
  private static final long serialVersionUID = 1L;

  private final String entityName;

  private final String errorKey;

  public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
    this(SecurityErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
  }

  public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
    super(
        HttpStatus.BAD_REQUEST,
        ProblemDetailWithCauseBuilder.instance()
            .withStatus(HttpStatus.BAD_REQUEST.value())
            .withType(type)
            .withTitle(defaultMessage)
            .withProperty("message", "error." + errorKey)
            .withProperty("params", entityName)
            .build(),
        null
    );
    this.entityName = entityName;
    this.errorKey = errorKey;
  }

  public String getEntityName() {
    return entityName;
  }

  public String getErrorKey() {
    return errorKey;
  }

  public ProblemDetailWithCause getProblemDetailWithCause() {
    return (ProblemDetailWithCause) this.getBody();
  }
}
