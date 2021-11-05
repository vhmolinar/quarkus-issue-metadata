package org.acme;

import java.util.stream.Collectors;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/demo")
public class DemoResource {

  @Inject
  @Any
  Instance<AnySupertype> types;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String types() {
    return types.stream()
                .map(t -> {
                  Class<? extends AnySupertype> clazz = t.getClass();
                  AnyQualifier annotation = clazz.getAnnotation(AnyQualifier.class);
                  return String.format("%s: %s", clazz.getSimpleName(), annotation);
                })
                .collect(Collectors.joining(","));
  }
}
