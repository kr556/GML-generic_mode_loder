package org.gml.main;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.linear.main.Linear;

import java.util.Objects;
import java.util.UUID;

public final class DataAttributeFactory {
    private DataAttributeFactory() {}

    @NotNull
    public static DataAttribute create(final int dimension, @NotNull final Class<?> type, @Nullable final String name) {
        Objects.requireNonNull(type);
        String aName = (name == null || name.isEmpty()) ? "attribute_" + UUID.randomUUID() : name;

        return new DataAttributes.DataAttributeImpl() {
            @Override
            public int dimension() {
                return dimension;
            }

            @Override
            public Class<?> type() {
                return type;
            }

            @Override
            public String name() {
                return aName;
            }
        };
    }

    public static DataAttribute create(Linear<?, ?> sample, String name) {
        Object element = sample.get(0);

        if (element instanceof Number num) {
            return switch (Objects.requireNonNull(SupportedBaseType.enumOf(num), "type '" + num.getClass().getName() + "' is unsupported.")) {
                case FLOAT -> create(sample.elementsSize(), float.class, name);
                case DOUBLE -> create(sample.elementsSize(), double.class, name);
                case BYTE -> create(sample.elementsSize(), byte.class, name);
                case INT -> create(sample.elementsSize(), int.class, name);
                case LONG -> create(sample.elementsSize(), long.class, name);
                case SHORT -> create(sample.elementsSize(), short.class, name);
                default -> create(sample.elementsSize(), num.getClass(), name);
            };
        }

        throw new NullPointerException("element of argument is null.");
    }
}
