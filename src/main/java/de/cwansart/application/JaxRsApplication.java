package de.cwansart.application;

import javax.enterprise.context.Dependent;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Dependent
@ApplicationPath("api")
public class JaxRsApplication extends Application {
}
