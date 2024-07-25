package org.gml.main;

import java.nio.Buffer;

/**
 * Data of model.
 * @param <D> Data type. If model data configured by "Vector3D"s array, "Vector3D[]" is entered.
 */
public interface Data<D> {
    DataAttribute attribute();

    D data();

    /**
     * @return size of data.
     */
    int size();

    /**
     * @return size of serialized data.
     */
    int allSize();

    Object array();

    Buffer buffer();
}
