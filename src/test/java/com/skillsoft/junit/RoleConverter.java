package com.skillsoft.junit;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> target) {
        assertEquals(String.class, target);
        return String.valueOf(source).toUpperCase(Locale.ROOT);
    }
}
