package com.example.micro_project_esd;

import com.example.micro_project_esd.util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;
//import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig
{
    public HelloApplication(){
        register(CORSFilter.class);
        packages("com.example.micro_project_esd");
    }
}