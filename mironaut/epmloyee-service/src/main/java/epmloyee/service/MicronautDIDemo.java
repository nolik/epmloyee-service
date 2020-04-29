package epmloyee.service;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import javax.inject.Singleton;

@Controller("/di")
public class MicronautDIDemo {
    @Inject
    private Vehicle vehicle;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return vehicle.start();
    }
}

interface Engine {
    int getCylinders();

    String start();
}

@Singleton
class V8Engine implements Engine {
    public String start() {
        return "Starting V8";
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    private int cylinders = 8;
}

@Singleton
class Vehicle {
    private final Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public String start() {
        return engine.start();
    }
}
