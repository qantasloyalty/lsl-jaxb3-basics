package org.jvnet.jaxb2_commons.tests.one;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;

import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.test.AbstractSamplesTest;

public class CopyableTest extends AbstractSamplesTest {

  @Override
  protected void checkSample(File sample) throws Exception {

    // final Object original = createContext().createUnmarshaller().unmarshal(sample);
    // final Object copy = JAXBCopyStrategy.getInstance().copy(null, original);
    // assertTrue(JAXBEqualsStrategy.INSTANCE.equals(null, null, original, copy), "Source and copy must be equal.");
  }

}
