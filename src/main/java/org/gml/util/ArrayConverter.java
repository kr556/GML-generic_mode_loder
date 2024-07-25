package org.gml.util;

import java.util.Arrays;
import java.util.Objects;

public final class ArrayConverter {
    private ArrayConverter() {}

    public static float[] toPrimitive(Float[] bytes) {
        return null; // TODO
    }
    public static double[] toPrimitive(Double[] bytes) {
        return null; // TODO
    }


    public static byte[] toPrimitive(Byte[] bytes) {
        Objects.requireNonNull(bytes);
        final int len = bytes.length;
        byte[] re = new byte[len];
        int i = 0;
        while (i < len)
            re[i++] = bytes[i];
        return re;
    }

    public static short[] toPrimitive(Short[] bytes) {
        return null; // TODO
    }

    public static int[] toPrimitive(Integer[] bytes) {
        return null; // TODO
    }

    public static long[] toPrimitive(Long[] bytes) {
        return null; // TODO
    }
}
