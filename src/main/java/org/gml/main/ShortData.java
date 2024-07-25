package org.gml.main;

import org.gml.main.Datas.PrimitiveArrayData;

import java.nio.Buffer;
import java.nio.ShortBuffer;

public interface ShortData<D> extends Data<D> {
    @Override
    short[] array();

    @Override
    ShortBuffer buffer();
}
