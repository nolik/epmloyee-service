package com.employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/di")
public class QuarkusDIDemo {
    @Inject
    AmazingService s1;

    @Inject
    CoolService s2;

    @GET
    public String di() {
        return s1.ping() + s2.ping();
    }
}

@Singleton        // => pseudo-scope
class AmazingService {
    String ping() {
        return "amazing";
    }
}

@ApplicationScoped        // => normal scope
class CoolService {
    String ping() {
        return "cool";
    }
}
