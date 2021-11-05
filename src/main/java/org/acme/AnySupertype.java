package org.acme;

public interface AnySupertype {

  default void hello() {
    System.out.println("Hello");
  }
}
