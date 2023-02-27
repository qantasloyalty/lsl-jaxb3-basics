package org.jvnet.jaxb2_commons.xml.bind.model.util.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.jvnet.jaxb2_commons.xml.bind.model.util.XmlTypeUtils;
import org.jvnet.jaxb2_commons.xml.namespace.util.QNameUtils;

public class XmlTypeUtilsTest {

  public static Stream<Arguments> data() {
    return Stream.of(
        Arguments.arguments("a1", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A1.class),
        Arguments.arguments("a2", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A2.class),
        Arguments.arguments("AThree", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A3.class),
        Arguments.arguments("AFour", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A4.class),
        Arguments.arguments("{urn:five}AFive", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A5.class),
        Arguments.arguments("a6", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A6.class),
        Arguments.arguments("{urn:seven}a7", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A7.class),
        Arguments.arguments(null, org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A8.class),
        Arguments.arguments("{urn:nine}ANine", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.alpha.A9.class),
        Arguments.arguments("a1", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A1.class),
        Arguments.arguments("a2", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A2.class),
        Arguments.arguments("AThree", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A3.class),
        Arguments.arguments("AFour", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A4.class),
        Arguments.arguments("{urn:five}AFive", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A5.class),
        Arguments.arguments("a6", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A6.class),
        Arguments.arguments("{urn:seven}a7", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A7.class),
        Arguments.arguments(null, org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A8.class),
        Arguments.arguments("{urn:nine}ANine", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.beta.A9.class),
        Arguments.arguments("{urn:gamma}a1", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A1.class),
        Arguments.arguments("{urn:gamma}a2", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A2.class),
        Arguments.arguments("{urn:gamma}AThree", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A3.class),
        Arguments.arguments("AFour", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A4.class),
        Arguments.arguments("{urn:five}AFive", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A5.class),
        Arguments.arguments("a6", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A6.class),
        Arguments.arguments("{urn:seven}a7", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A7.class),
        Arguments.arguments(null, org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A8.class),
        Arguments.arguments("{urn:nine}ANine", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.gamma.A9.class),
        Arguments.arguments("{urn:delta}a1", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A1.class),
        Arguments.arguments("{urn:delta}a2", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A2.class),
        Arguments.arguments("{urn:delta}AThree", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A3.class),
        Arguments.arguments("AFour", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A4.class),
        Arguments.arguments("{urn:five}five:AFive", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A5.class),
        Arguments.arguments("a6", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A6.class),
        Arguments.arguments("{urn:seven}a7", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A7.class),
        Arguments.arguments(null, org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A8.class),
        Arguments.arguments("{urn:nine}ANine", org.jvnet.jaxb2_commons.xml.bind.model.util.tests.delta.A9.class));
  }

  @ParameterizedTest
  @MethodSource("data")
  void producesCorrectTypeName(final String key, final Class<?> _class) {
    assertEquals(key, QNameUtils.getKey(XmlTypeUtils.getTypeName(_class)));

  }

}
