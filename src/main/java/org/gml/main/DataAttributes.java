package org.gml.main;

class DataAttributes {
    static abstract class DataAttributeImpl implements DataAttribute {
        @Override
        public String toString() {
            return "[<" + type() + ":" + dimension() + "> " + name() + "]";
        }
    }
}
