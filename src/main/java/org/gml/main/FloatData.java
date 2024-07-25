package org.gml.main;

import org.gml.main.Datas.PrimitiveArrayData;

import java.nio.Buffer;
import java.nio.FloatBuffer;

public interface FloatData<D> extends Data<D> {
    @Override
    float[] array();

    @Override
    FloatBuffer buffer();
}
