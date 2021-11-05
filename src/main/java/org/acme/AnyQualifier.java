package org.acme;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, ElementType.TYPE})
@Qualifier
public @interface AnyQualifier {

  String value();
}
