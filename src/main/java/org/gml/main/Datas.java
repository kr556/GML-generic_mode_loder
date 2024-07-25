package org.gml.main;

import org.linear.main.Linear;

import java.nio.*;

final class Datas {
    private Datas() {}

    static <A> A requireArray(A a) {
        if (a.getClass().isArray()) return a;
        throw new IllegalArgumentException("not array.");
    }

    static <B> B requireBuffer(B maybeBuf) {
        if (maybeBuf instanceof Buffer) return maybeBuf;
        throw new IllegalArgumentException("not buffer. see constructor.");
    }

    private static abstract class DataImpl<D> implements Data<D> {
        DataAttribute attribute;
        D data;
        final int size;

        DataImpl(DataAttribute a, D d, int s) {
            attribute = a;
            data = d;
            size = s;
        }

        @Override
        public DataAttribute attribute() {
            return attribute;
        }

        @Override
        public D data() {
            return data;
        }

        @Override
        public int size() {
            return size / attribute.dimension();
        }

        @Override
        public int allSize() {
            return size;
        }
    }

    //=======================================<array>=======================================
    static abstract class StructArrayData<V extends Linear<?, V>> extends ArrayData<V[]> implements StructData<V> { // when elements is array of structure :
        StructArrayData(DataAttribute a, V[] d) {
            super(a, d, d.length);
        }

        @Override
        public int allSize() {
            return size * attribute.dimension();
        }

        @Override
        public int size() {
            return size;
        }

        Buffer buffer(Buffer buffer) {
            V[] arr = data();
            final int dim = attribute.dimension();

            for (int i = 0; i < size; i++) {
                arr[i].get(dim * i, buffer);
            }
            return buffer;
        }

        static class Floats<V extends Linear<Float, V>> extends StructArrayData<V> implements StructData.Floats<V> {
            Floats(V[] d) {
                super(DataAttributeFactory.create(d[0], null), d);
            }

            @Override
            public float[] array() {
                final int dim = attribute.dimension();
                Float[] vec = new Float[dim];
                float[] re = new float[allSize()];
                V[] arr = data();

                for (int i = 0; i < size; i++) {
                    arr[i].toArray(vec);
                    for (int d = 0; d < dim; d++) {
                        re[i * dim + d] = vec[d];
                    }
                }
                return re;
            }

            @Override
            public FloatBuffer buffer() {
                return (FloatBuffer) buffer(FloatBuffer.allocate(allSize()));
            }
        }

        static class Doubles<V extends Linear<Double, V>> extends StructArrayData<V> implements StructData.Doubles<V> {
            Doubles(V[] d) {
                super(DataAttributeFactory.create(d[0], null), d);
            }

            @Override
            public double[] array() {
                final int dim = attribute.dimension();
                Double[] vec = new Double[dim];
                double[] re = new double[allSize()];
                V[] arr = data();

                for (int i = 0; i < size; i++) {
                    arr[i].toArray(vec);
                    for (int d = 0; d < dim; d++) {
                        re[i * dim + d] = vec[d];
                    }
                }
                return re;
            }

            @Override
            public DoubleBuffer buffer() {
                return (DoubleBuffer) buffer(DoubleBuffer.allocate(allSize()));
            }
        }

        static class Bytes<V extends Linear<Byte, V>> extends StructArrayData<V> implements StructData.Bytes<V> {
            Bytes(V[] d) {
                super(DataAttributeFactory.create(d[0], null), d);
            }

            @Override
            public byte[] array() {
                final int dim = attribute.dimension();
                Byte[] vec = new Byte[dim];
                byte[] re = new byte[allSize()];
                V[] arr = data();

                for (int i = 0; i < size; i++) {
                    arr[i].toArray(vec);
                    for (int d = 0; d < dim; d++) {
                        re[i * dim + d] = vec[d];
                    }
                }
                return re;
            }

            @Override
            public ByteBuffer buffer() {
                return (ByteBuffer) buffer(ByteBuffer.allocate(allSize()));
            }
        }

        static class Shorts<V extends Linear<Short, V>> extends StructArrayData<V> implements StructData.Shorts<V> {
            Shorts(V[] d) {
                super(DataAttributeFactory.create(d[0], null), d);
            }

            @Override
            public short[] array() {
                final int dim = attribute.dimension();
                Short[] vec = new Short[dim];
                short[] re = new short[allSize()];
                V[] arr = data();

                for (int i = 0; i < size; i++) {
                    arr[i].toArray(vec);
                    for (int d = 0; d < dim; d++) {
                        re[i * dim + d] = vec[d];
                    }
                }
                return re;
            }

            @Override
            public ShortBuffer buffer() {
                return (ShortBuffer) buffer(ShortBuffer.allocate(allSize()));
            }
        }

        static class Ints<V extends Linear<Integer, V>> extends StructArrayData<V> implements StructData.Ints<V> {
            Ints(V[] d) {
                super(DataAttributeFactory.create(d[0], null), d);
            }

            @Override
            public int[] array() {
                final int dim = attribute.dimension();
                Integer[] vec = new Integer[dim];
                int[] re = new int[allSize()];
                V[] arr = data();

                for (int i = 0; i < size; i++) {
                    arr[i].toArray(vec);
                    for (int d = 0; d < dim; d++) {
                        re[i * dim + d] = vec[d];
                    }
                }
                return re;
            }

            @Override
            public IntBuffer buffer() {
                return (IntBuffer) buffer(IntBuffer.allocate(allSize()));
            }
        }

        static class Longs<V extends Linear<Long, V>> extends StructArrayData<V> implements StructData.Longs<V> {
            Longs(V[] d) {
                super(DataAttributeFactory.create(d[0], null), d);
            }

            @Override
            public long[] array() {
                final int dim = attribute.dimension();
                Long[] vec = new Long[dim];
                long[] re = new long[allSize()];
                V[] arr = data();

                for (int i = 0; i < size; i++) {
                    arr[i].toArray(vec);
                    for (int d = 0; d < dim; d++) {
                        re[i * dim + d] = vec[d];
                    }
                }
                return re;
            }

            @Override
            public LongBuffer buffer() {
                return (LongBuffer) buffer(LongBuffer.allocate(allSize()));
            }
        }
    }

    static abstract class PrimitiveArrayData<A> extends ArrayData<A> { // when elements is primitive array :
        PrimitiveArrayData(DataAttribute a, A d, int s) {
            super(a, d, s);
        }

        public A array() {
            return data;
        }

        static class Floats extends PrimitiveArrayData<float[]> implements FloatData<float[]> {
            Floats(DataAttribute a, float[] data) {
                super(a, data, data.length);
            }

            @Override
            public FloatBuffer buffer() {
                return FloatBuffer.wrap(array());
            }
        }

        static class Doubles extends PrimitiveArrayData<double[]> implements DoubleData<double[]> {
            Doubles(DataAttribute a, double[] data) {
                super(a, data, data.length);
            }

            @Override
            public DoubleBuffer buffer() {
                return DoubleBuffer.wrap(array());
            }
        }

        static class Bytes extends PrimitiveArrayData<byte[]> implements ByteData<byte[]> {
            Bytes(DataAttribute a, byte[] data) {
                super(a, data, data.length);
            }

            @Override
            public ByteBuffer buffer() {
                return ByteBuffer.wrap(array());
            }
        }

        static class Shorts extends PrimitiveArrayData<short[]> implements ShortData<short[]> {
            Shorts(DataAttribute a, short[] data) {
                super(a, data, data.length);
            }

            @Override
            public ShortBuffer buffer() {
                return ShortBuffer.wrap(array());
            }
        }

        static class Ints extends PrimitiveArrayData<int[]> implements IntData<int[]> {
            Ints(DataAttribute a, int[] data) {
                super(a, data, data.length);
            }

            @Override
            public IntBuffer buffer() {
                return IntBuffer.wrap(array());
            }
        }

        static class Longs extends PrimitiveArrayData<long[]> implements LongData<long[]> {
            Longs(DataAttribute a, long[] data) {
                super(a, data, data.length);
            }

            @Override
            public LongBuffer buffer() {
                return LongBuffer.wrap(array());
            }
        }
    }

    private static abstract class ArrayData<D> extends DataImpl<D> {
        ArrayData(DataAttribute a, D d, int size) {
            super(a, requireArray(d), size);
        }
    }

    //=======================================<buffer>=======================================
    // when elements is primitive buffer :
    static abstract class BufferedData<B extends Buffer> extends DataImpl<B> {
        BufferedData(DataAttribute a, B d) {
            super(a, requireBuffer(d), a.dimension());
            if (d.limit() % a.dimension() != 0) throw new IllegalArgumentException("mismatch buffer size with data size.");
        }

        static class Floats extends BufferedData<FloatBuffer> implements FloatData<FloatBuffer> {
            Floats(DataAttribute a, FloatBuffer d) {
                super(a, d);
            }

            @Override
            public float[] array() {
                return data.array();
            }

            @Override
            public FloatBuffer buffer() {
                return data;
            }
        }

        static class Doubles extends BufferedData<DoubleBuffer> implements DoubleData<DoubleBuffer> {
            Doubles(DataAttribute a, DoubleBuffer d) {
                super(a, d);
            }

            @Override
            public double[] array() {
                return data.array();
            }

            @Override
            public DoubleBuffer buffer() {
                return data;
            }
        }

        static class Bytes extends BufferedData<ByteBuffer> implements ByteData<ByteBuffer> {
            Bytes(DataAttribute a, ByteBuffer d) {
                super(a, d);
            }

            @Override
            public byte[] array() {
                return data.array();
            }

            @Override
            public ByteBuffer buffer() {
                return data;
            }
        }

        static class Shorts extends BufferedData<ShortBuffer> implements ShortData<ShortBuffer> {
            Shorts(DataAttribute a, ShortBuffer d) {
                super(a, d);
            }

            @Override
            public short[] array() {
                return data.array();
            }

            @Override
            public ShortBuffer buffer() {
                return data;
            }
        }

        static class Ints extends BufferedData<IntBuffer> implements IntData<IntBuffer> {
            Ints(DataAttribute a, IntBuffer d) {
                super(a, d);
            }

            @Override
            public int[] array() {
                return data.array();
            }

            @Override
            public IntBuffer buffer() {
                return data;
            }
        }

        static class Longs extends BufferedData<LongBuffer> implements LongData<LongBuffer> {
            Longs(DataAttribute a, LongBuffer d) {
                super(a, d);
            }

            @Override
            public long[] array() {
                return data.array();
            }

            @Override
            public LongBuffer buffer() {
                return data;
            }
        }
    }
}
