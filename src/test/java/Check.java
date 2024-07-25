import org.gml.main.Data;
import org.gml.main.DataFactory;
import org.gml.main.FloatData;
import org.gml.main.StructData;
import org.linear.main.vector.Vector4f;

import java.nio.FloatBuffer;
import java.util.Arrays;

public class Check {
    public static void main(String[] args) {
        Data<?> data = DataFactory.create(4, FloatBuffer.wrap(new float[]{
                0, 1, 3, 4, 2, 3, 5, 6, 1, 5, 0, 1
        }));

        System.out.println(Arrays.toString((float[]) data.array()));
    }
}
