package org.gml.main;

import org.gml.main.Datas.PrimitiveArrayData;

import java.nio.Buffer;
import java.nio.DoubleBuffer;

public interface DoubleData<D> extends Data<D> {
    @Override
    double[] array();

    @Override
    DoubleBuffer buffer();
}
