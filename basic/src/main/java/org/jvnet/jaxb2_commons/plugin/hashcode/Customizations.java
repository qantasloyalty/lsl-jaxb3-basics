package org.jvnet.jaxb2_commons.plugin.hashcode;

import javax.xml.namespace.QName;

public class Customizations {

  public static final String NAMESPACE_URI = "http://jaxb3-commons.dev.java.net/basic/hashCode";

  public static final QName IGNORED_ELEMENT_NAME = new QName(NAMESPACE_URI, "ignored");

  private Customizations() {}

}
