package org.jvnet.jaxb2_commons.reflection.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.jvnet.jaxb2_commons.reflection.util.Accessor;
import org.jvnet.jaxb2_commons.reflection.util.FieldAccessor;

class FieldAccessorTest {

  @Test
  void testGetAndSet() throws URISyntaxException {
    final URI uri = new URI("urn:test");

    final Accessor<String> schemeAccessor = new FieldAccessor<String>(
        URI.class, "scheme", String.class);

    assertEquals("urn", schemeAccessor.get(uri));
    schemeAccessor.set(uri, "nru");
    assertEquals("nru", schemeAccessor.get(uri));
    assertEquals("nru", uri.getScheme());

  }

}
