package org.gml.main;

public enum SupportedBaseType {
    FLOAT(float.class, Float.class),
    DOUBLE(double.class, Double.class),
    BYTE(byte.class, Byte.class),
    INT(int.class, Integer.class),
    SHORT(short.class, Short.class),
    LONG(long.class, Long.class),
    CHAR(char.class, Character.class),
    ;

    SupportedBaseType(Class<?> cls, Class<?> wrap) {
        ofClass = cls;
        ofWrapClass = wrap;
    }

    public final Class<?> ofClass;
    public final Class<?> ofWrapClass;

    public static SupportedBaseType enumOf(Number sample) {
        Class<?> cls = sample.getClass();
        if (cls == Float.class) {
            return FLOAT;
        } else if (cls == Double.class) {
            return DOUBLE;
        } else if (cls == Byte.class) {
            return BYTE;
        } else if (cls == Short.class) {
            return SHORT;
        } else if (cls == Integer.class) {
            return INT;
        } else if (cls == Long.class) {
            return LONG;
        }
        return null;
    }
}
