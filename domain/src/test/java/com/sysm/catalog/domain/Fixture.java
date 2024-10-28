package com.sysm.catalog.domain;

import net.datafaker.Faker;

public final class Fixture {

    private static final Faker FAKER = new Faker();

    public static String name() {
        return FAKER.name().fullName();
    }

    public static Integer year() {
        return FAKER.random().nextInt(2020, 2030);
    }

    public static Double duration() {
        return FAKER.options().option(90.0, 120.0, 150.0);
    }

    public static boolean bool() {
        return FAKER.bool().bool();
    }

    public static String title() {
        return FAKER.options().option(
            "System Design in the Free Market in practice",
            "Don’t make these mistakes when working with Microservices",
            "Mutation Tests. You do not test your software correctly"
        );
    }

    public static String checksum() {
        return "03fe62de";
    }
}
