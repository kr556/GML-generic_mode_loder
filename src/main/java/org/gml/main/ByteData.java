package org.gml.main;

import org.gml.main.Datas.PrimitiveArrayData;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public interface ByteData<D> extends Data<D> {
    @Override
    byte[] array();

    @Override
    ByteBuffer buffer();
}
