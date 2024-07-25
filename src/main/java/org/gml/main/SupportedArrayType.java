package org.gml.main;

import org.jetbrains.annotations.Nullable;

public enum SupportedArrayType {
    FLOAT_ARRAY(Float[].class, true),
    DOUBLE_ARRAY(Double[].class, true),
    BYTE_ARRAY(Byte[].class, true),
    INT_ARRAY(Integer[].class, true),
    SHORT_ARRAY(Short[].class, true),
    LONG_ARRAY(Long[].class, true),
    WRAP_FLOAT_ARRAY(float[].class, false),
    WRAP_DOUBLE_ARRAY(double[].class, false),
    WRAP_BYTE_ARRAY(byte[].class, false),
    WRAP_INT_ARRAY(int[].class, false),
    WRAP_SHORT_ARRAY(short[].class, false),
    WRAP_LONG_ARRAY(long[].class, false),
    ;

    SupportedArrayType(Class<?> cls, boolean p) {
        ofClass = cls;
        isPrimitive = p;
    }

    public final Class<?> ofClass;
    public final boolean isPrimitive;

    @Nullable
    public static SupportedArrayType toEnum(Number[] sample) {
        if (!sample.getClass().isArray()) return null;
        return toEnum(sample, sample.getClass());
    }

    private static SupportedArrayType toEnum(Number[] s, Class<?> c) {
        if (c == Float[].class) {
            return WRAP_FLOAT_ARRAY;
        } else if (c == Double[].class) {
            return WRAP_DOUBLE_ARRAY;
        } else if (c == Byte[].class) {
            return WRAP_BYTE_ARRAY;
        } else if (c == Short[].class) {
            return WRAP_SHORT_ARRAY;
        } else if (c == Integer[].class) {
            return WRAP_INT_ARRAY;
        } else if (c == Long[].class) {
            return WRAP_LONG_ARRAY;
        }
        return null;
    }

    @Nullable
    public static SupportedArrayType toEnum(Object sample) {
        if (!sample.getClass().isArray()) return null;
        Class<?> cls = sample.getClass();

        return cls == float[].class ? FLOAT_ARRAY
                : cls == double[].class ? DOUBLE_ARRAY
                : cls == byte[].class ? BYTE_ARRAY
                : cls == short[].class ? SHORT_ARRAY
                : cls == int[].class ? INT_ARRAY
                : cls == long[].class ? LONG_ARRAY
                : toEnum((Number[]) sample, sample.getClass());
    }
}
