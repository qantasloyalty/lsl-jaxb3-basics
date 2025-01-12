package org.jvnet.jaxb2_commons.tests.one;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;

import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.test.AbstractSamplesTest;

public class HashCodeTest extends AbstractSamplesTest {

  @Override
  protected void checkSample(File sample) throws Exception {

    // final Object lhs = createContext().createUnmarshaller().unmarshal(sample);
    // final Object rhs = createContext().createUnmarshaller().unmarshal(sample);
    // final Object chs = JAXBCopyStrategy.getInstance().copy(null, rhs);
    // final int leftHashCode = JAXBHashCodeStrategy.getInstance().hashCode(null, 0, lhs);
    // final int rightHashCode = JAXBHashCodeStrategy.getInstance().hashCode(null, 0, rhs);
    // final int copyHashCode = JAXBHashCodeStrategy.getInstance().hashCode(null, 0, chs);
    // assertEquals(leftHashCode, rightHashCode, "Values must be equal.");
    // assertEquals(leftHashCode, copyHashCode, "Values must be equal.");
  }
}
