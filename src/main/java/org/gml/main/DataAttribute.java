package org.gml.main;

import java.util.UUID;

/**
 * This interface is attribute of model data. For example, 3D model is having pos, texcoord, color. This interface a define
 * data attribute like those.
 */
public interface DataAttribute {
    /**
     * @return Dimension of model data. In case of 3-dimensional vector return 3.
     */
    int dimension();

    /**
     * @return The type of minimum configuration data. When data element type is float vector, return class object of float.
     */
    Class<?> type();

    /**
     * @return Name of data attribute. Default name is "attribute_" to plus random UUID.
     */
    String name();
}
