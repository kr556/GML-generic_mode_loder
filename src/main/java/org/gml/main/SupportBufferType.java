package org.gml.main;

import org.jetbrains.annotations.Nullable;

import java.nio.*;
import java.util.Objects;

public enum SupportBufferType {
    FLOAT_BUFFER(FloatBuffer.class),
    DOUBLE_BUFFER(DoubleBuffer.class),
    BYTE_BUFFER(ByteBuffer.class),
    SHORT_BUFFER(ShortBuffer.class),
    INT_BUFFER(IntBuffer.class),
    LONG_BUFFER(LongBuffer.class),
    ;

    SupportBufferType(Class<?> cls) {
        ofClass = cls;
    }

    public final Class<?> ofClass;

    @Nullable
    public static SupportBufferType enumOf(Buffer sample) {
        return Objects.requireNonNull(
                  sample) instanceof FloatBuffer ? FLOAT_BUFFER
                : sample instanceof DoubleBuffer ? DOUBLE_BUFFER
                : sample instanceof ByteBuffer ? BYTE_BUFFER
                : sample instanceof ShortBuffer ? SHORT_BUFFER
                : sample instanceof IntBuffer ? INT_BUFFER
                : sample instanceof LongBuffer ? LONG_BUFFER
                : null;
    }
}
