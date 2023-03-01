package org.jvnet.jaxb2_commons.plugin.wildcard;

import javax.xml.namespace.QName;

public class Customizations {

  public static final String NAMESPACE_URI = "http://jaxb2-commons.dev.java.net/basic/wildcard";

  public static final QName LAX_ELEMENT_NAME = new QName(NAMESPACE_URI, "lax");
  public static final QName STRICT_ELEMENT_NAME = new QName(NAMESPACE_URI, "strict");
  public static final QName SKIP_ELEMENT_NAME = new QName(NAMESPACE_URI, "skip");

  private Customizations() {}

}
