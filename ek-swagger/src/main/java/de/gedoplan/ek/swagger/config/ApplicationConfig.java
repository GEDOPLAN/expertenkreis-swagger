package de.gedoplan.ek.swagger.config;

import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Dominik Mathmann, GEDOPLAN
 */
@ApplicationPath("/webresources")
public class ApplicationConfig extends Application {

  public ApplicationConfig() {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[] { "http" });
    beanConfig.setTitle("Expertenkreis Demo");
    beanConfig.setHost("localhost:8080");
    beanConfig.setBasePath("/ek-swagger-1.0-SNAPSHOT/webresources");
    beanConfig.setResourcePackage("de.gedoplan.ek.swagger.resource");
    beanConfig.setScan(true);
  }
}
