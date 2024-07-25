package org.gml.main;

import org.linear.main.Linear;

public interface StructData<V extends Linear<? extends Number, V>> extends Data<V[]> {
    @Override
    V[] data();

    interface Floats<V extends Linear<java.lang.Float, V>> extends StructData<V>, FloatData<V[]> {
        @Override
        float[] array();
    }

    interface Doubles<V extends Linear<java.lang.Double, V>> extends StructData<V>, DoubleData<V[]> {
        @Override
        double[] array();
    }

    interface Bytes<V extends Linear<java.lang.Byte, V>> extends StructData<V>, ByteData<V[]> {
        @Override
        byte[] array();
    }

    interface Shorts<V extends Linear<java.lang.Short, V>> extends StructData<V>, ShortData<V[]> {
        @Override
        short[] array();
    }

    interface Ints<V extends Linear<java.lang.Integer, V>> extends StructData<V>, IntData<V[]> {
        @Override
        int[] array();
    }

    interface Longs<V extends Linear<java.lang.Long, V>> extends StructData<V>, LongData<V[]> {
        @Override
        long[] array();
    }
}
