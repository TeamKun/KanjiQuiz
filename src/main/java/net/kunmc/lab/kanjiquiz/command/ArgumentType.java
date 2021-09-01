package net.kunmc.lab.kanjiquiz.command;

import java.util.function.Function;

public enum ArgumentType {
    INTEGER(Integer.class, x -> {
        Integer value = null;
        try {
            value = Integer.parseInt(x);
        } catch (Exception ignore) {
        }

        return value;
    }),
    INT(int.class, x -> {
        Integer value = null;
        try {
            value = Integer.parseInt(x);
        } catch (Exception ignore) {
        }

        return value;
    }),
    WRAPPERDOUBLE(Double.class, x -> {
        Double value = null;
        try {
            value = Double.parseDouble(x);
        } catch (Exception ignore) {
        }

        return value;
    }),
    DOUBLE(double.class, x -> {
        Double value = null;
        try {
            value = Double.parseDouble(x);
        } catch (Exception ignore) {
        }

        return value;
    }),
    WRAPPERBOOLEAN(Boolean.class, x -> {
        Boolean value = null;
        try {
            value = Boolean.parseBoolean(x);
        } catch (Exception ignore) {
        }

        return value;
    }),
    BOOLEAN(boolean.class, x -> {
        Boolean value = null;
        try {
            value = Boolean.parseBoolean(x);
        } catch (Exception ignore) {
        }

        return value;
    }),
    STRING(String.class, x -> {
        return x;
    });

    private final Class clazz;
    private final Function parser;

    <R> ArgumentType(Class<R> clazz, Function<String, R> parser) {
        this.clazz = clazz;
        this.parser = parser;
    }

    public Object parse(String value) {
        return parser.apply(value);
    }

    public static ArgumentType valueOf(Class clazz) {
        for (ArgumentType argumentType : values()) {
            if (argumentType.clazz.equals(clazz)) {
                return argumentType;
            }
        }

        return null;
    }
}
