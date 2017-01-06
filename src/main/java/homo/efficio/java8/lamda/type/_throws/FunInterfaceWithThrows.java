package homo.efficio.java8.lamda.type._throws;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by hanmomhanda on 2016-12-03.
 */
public interface FunInterfaceWithThrows {

    void writeTo(PrintStream ps, String msg) throws IOException;
}
