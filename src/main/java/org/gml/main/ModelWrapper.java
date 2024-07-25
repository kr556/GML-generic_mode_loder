package org.gml.main;

import java.util.Objects;

/**
 * Wrap various format model and provides anything data which model contains.
 * Also, conversion "ModelWrapper" by created float array type model in runtime JVM.
 * If want to create "ModelWrapper" by read file, see {@link org.gml.io.GMLInputUtils}, or create file by "ModelWrapper" see {@link org.gml.io.GMLOutputUtils}.
 */
public interface ModelWrapper {
    default Data<?> data(String dataName) {
        if (dataName == null) return null;
        for (Data<?> data : allData()) {
            if (Objects.equals(data.attribute().name(), dataName))
                return data;
        }

        return null;
    }

    default Data<?> data(DataAttribute attribute) {
        return data(attribute.name());
    }

    Data<?>[] allData();
}
