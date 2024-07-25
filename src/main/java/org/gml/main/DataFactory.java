package org.gml.main;

import org.gml.util.ArrayConverter;
import org.linear.main.Linear;

import java.nio.*;
import java.util.Objects;

import static org.gml.main.Datas.*;

public final class DataFactory {
    private DataFactory() {}

    public static <V extends Linear<Float, V>> StructData.Floats<V> createFloatStruct(V[] data) {
        return new StructArrayData.Floats<>(data);
    }

    public static <V extends Linear<Double, V>> StructData.Doubles<V> createDoubleStruct(V[] data) {
        return new StructArrayData.Doubles<>(data);
    }

    public static <V extends Linear<Byte, V>> StructData.Bytes<V> createByteStruct(V[] data) {
        return new StructArrayData.Bytes<>(data);
    }

    public static <V extends Linear<Short, V>> StructData.Shorts<V> createShortStruct(V[] data) {
        return new StructArrayData.Shorts<>(data);
    }

    public static <V extends Linear<Integer, V>> StructData.Ints<V> createIntStruct(V[] data) {
        return new StructArrayData.Ints<>(data);
    }

    public static <V extends Linear<Long, V>> StructData.Longs<V> createLongStruct(V[] data) {
        return new StructArrayData.Longs<>(data);
    }

    public static Data<?> create(DataAttribute attribute, Object array) {
        if (array.getClass().isArray()) {
            SupportedArrayType type = SupportedArrayType.toEnum(array);
            if (Objects.requireNonNull(type).isPrimitive) {
                return switch (type) {
                    case FLOAT_ARRAY -> new PrimitiveArrayData.Floats(attribute, (float[]) array);
                    case DOUBLE_ARRAY -> new PrimitiveArrayData.Doubles(attribute, (double[]) array);
                    case BYTE_ARRAY -> new PrimitiveArrayData.Bytes(attribute, (byte[]) array);
                    case INT_ARRAY -> new PrimitiveArrayData.Shorts(attribute, (short[]) array);
                    case SHORT_ARRAY -> new PrimitiveArrayData.Ints(attribute, (int[]) array);
                    case LONG_ARRAY -> new PrimitiveArrayData.Longs(attribute, (long[]) array);
                    default -> null; // not reach
                };
            } else {
                return switch (type) {
                    case WRAP_FLOAT_ARRAY -> new PrimitiveArrayData.Floats(attribute, ArrayConverter.toPrimitive((Float[]) array));
                    case WRAP_DOUBLE_ARRAY -> new PrimitiveArrayData.Doubles(attribute, ArrayConverter.toPrimitive((Double[]) array));
                    case WRAP_BYTE_ARRAY -> new PrimitiveArrayData.Bytes(attribute, ArrayConverter.toPrimitive((Byte[]) array));
                    case WRAP_INT_ARRAY -> new PrimitiveArrayData.Shorts(attribute, ArrayConverter.toPrimitive((Short[]) array));
                    case WRAP_SHORT_ARRAY -> new PrimitiveArrayData.Ints(attribute, ArrayConverter.toPrimitive((Integer[]) array));
                    case WRAP_LONG_ARRAY -> new PrimitiveArrayData.Longs(attribute, ArrayConverter.toPrimitive((Long[]) array));
                    default -> null; // not reach
                };
            }
        } else if (array instanceof Buffer buffer) {
            return switch (Objects.requireNonNull(SupportBufferType.enumOf(buffer), "buffer type '" + buffer.getClass().getName() + "' is unsupported.")) {
                case FLOAT_BUFFER -> new BufferedData.Floats(attribute, (FloatBuffer) buffer);
                case DOUBLE_BUFFER -> new BufferedData.Doubles(attribute, (DoubleBuffer) buffer);
                case BYTE_BUFFER -> new BufferedData.Bytes(attribute, (ByteBuffer) buffer);
                case SHORT_BUFFER -> new BufferedData.Shorts(attribute, (ShortBuffer) buffer);
                case INT_BUFFER -> new BufferedData.Ints(attribute, (IntBuffer) buffer);
                case LONG_BUFFER -> new BufferedData.Longs(attribute, (LongBuffer) buffer);
            };
        }
        return null;
    }

    public static Data<?> create(int size, Buffer buffer) {
        return create(DataAttributeFactory.create(size, Objects.requireNonNull(SupportBufferType.enumOf(buffer)).ofClass, null), buffer);
    }

    public static Data<?> create(int size, String name, Object array) {
        return create(DataAttributeFactory.create(size, ((Object[])array)[0].getClass(), name), array);
    }

    public static FloatData<float[]> create(DataAttribute attribute, float[] array) {
        return new PrimitiveArrayData.Floats(attribute, array);
    }

    public static DoubleData<double[]> create(DataAttribute attribute, double[] array) {
        return new PrimitiveArrayData.Doubles(attribute, array);
    }

    public static ByteData<byte[]> create(DataAttribute attribute, byte[] array) {
        return new PrimitiveArrayData.Bytes(attribute, array);
    }

    public static ShortData<short[]> create(DataAttribute attribute, short[] array) {
        return new PrimitiveArrayData.Shorts(attribute, array);
    }

    public static IntData<int[]> create(DataAttribute attribute, int[] array) {
        return new PrimitiveArrayData.Ints(attribute, array);
    }

    public static LongData<long[]> create(DataAttribute attribute, long[] array) {
        return new PrimitiveArrayData.Longs(attribute, array);
    }

    public static FloatData<float[]> create(int size, float[] array) {
        return create(DataAttributeFactory.create(size, float.class, null), array);
    }

    public static DoubleData<double[]> create(int size, double[] array) {
        return create(DataAttributeFactory.create(size, double.class, null), array);
    }

    public static ByteData<byte[]> create(int size, byte[] array) {
        return create(DataAttributeFactory.create(size, byte.class, null), array);
    }

    public static ShortData<short[]> create(int size, short[] array) {
        return create(DataAttributeFactory.create(size, short.class, null), array);
    }

    public static IntData<int[]> create(int size, int[] array) {
        return create(DataAttributeFactory.create(size, int.class, null), array);
    }

    public static LongData<long[]> create(int size, long[] array) {
        return create(DataAttributeFactory.create(size, long.class, null), array);
    }
}
