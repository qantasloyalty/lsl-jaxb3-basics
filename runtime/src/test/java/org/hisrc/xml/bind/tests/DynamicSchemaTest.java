
package org.hisrc.xml.bind.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.MarshalException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.SchemaOutputResolver;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import org.glassfish.jaxb.core.v2.WellKnownNamespace;
import org.junit.jupiter.api.Test;

class DynamicSchemaTest {

  @XmlRootElement
  public static class A {
    @XmlAttribute(required = true)
    public String name;

    public A() {}

    public A(String name) {
      this.name = name;
    }
  }

  @Test
  void generatesAndUsesSchema() throws JAXBException, IOException,
      SAXException {
    final JAXBContext context = JAXBContext.newInstance(A.class);
    final DOMResult result = new DOMResult();
    result.setSystemId("schema.xsd");
    context.generateSchema(new SchemaOutputResolver() {
      @Override
      public Result createOutput(String namespaceUri,
          String suggestedFileName) {
        return result;
      }
    });

    @SuppressWarnings("deprecation")
    final SchemaFactory schemaFactory = SchemaFactory
        .newInstance(WellKnownNamespace.XML_SCHEMA);
    final Schema schema = schemaFactory.newSchema(new DOMSource(result
        .getNode()));

    final Marshaller marshaller = context.createMarshaller();
    marshaller.setSchema(schema);
    // Works
    marshaller.marshal(new A("works"), System.out);
    // Fails
    assertThrows(MarshalException.class, () -> marshaller.marshal(new A(null), System.out));
  }
}
