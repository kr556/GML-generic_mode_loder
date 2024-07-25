package org.gml.main;

import org.gml.main.Datas.PrimitiveArrayData;

import java.nio.Buffer;
import java.nio.LongBuffer;

public interface LongData<D> extends Data<D> {
    @Override
    long[] array();

    @Override
    LongBuffer buffer();
}
