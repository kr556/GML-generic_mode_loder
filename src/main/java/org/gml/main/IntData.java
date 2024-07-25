package org.gml.main;

import org.gml.main.Datas.PrimitiveArrayData;

import java.nio.Buffer;
import java.nio.IntBuffer;

public interface IntData<D> extends Data<D> {
    @Override
    int[] array();

    @Override
    IntBuffer buffer();
}
