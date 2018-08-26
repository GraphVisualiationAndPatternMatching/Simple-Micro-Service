package com.jadavey.graph.vizualization.pattern.matching.simple.acceptance.util;

import java.util.Optional;

/**
 * contains code to read in the environment of the host
 * under test
 * as well as any other useful setup code that
 * could be shared across tests
 */
public final class SetupHelpers {

    private static final String HOST_VARIABLE_NAME = "SERVICE_URL";
    public static Optional<String> getServiceUrl() {
        var environment = System.getenv();
        if(environment.containsKey(HOST_VARIABLE_NAME)) {
            return Optional.of(environment.get(HOST_VARIABLE_NAME));
        }
        return Optional.empty();
    }

}
