package org.jvnet.jaxb2_commons.plugin.simplify;

import javax.xml.namespace.QName;

public class Customizations {

  public static final String NAMESPACE_URI = "http://jaxb3-commons.dev.java.net/basic/simplify";

  public static final QName IGNORED_ELEMENT_NAME = new QName(NAMESPACE_URI, "ignored");

  public static final QName PROPERTY_ELEMENT_NAME = new QName(NAMESPACE_URI, "property");

  public static final QName AS_ELEMENT_PROPERTY_ELEMENT_NAME = new QName(NAMESPACE_URI, "as-element-property");

  public static final QName AS_REFERENCE_PROPERTY_ELEMENT_NAME = new QName(NAMESPACE_URI, "as-reference-property");

  private Customizations() {}

}
