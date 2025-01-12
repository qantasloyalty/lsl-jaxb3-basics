package org.jvnet.jaxb2_commons.tests.one;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;

import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.test.AbstractSamplesTest;

public class EqualsTest extends AbstractSamplesTest {

  @Override
  protected void checkSample(File sample) throws Exception {

    final Object lhs = createContext().createUnmarshaller().unmarshal(sample);
    final Object rhs = createContext().createUnmarshaller().unmarshal(sample);
    assertTrue(JAXBEqualsStrategy.getInstance().equals(null, null, lhs, rhs),
        "Values must be equal.");
  }
}
