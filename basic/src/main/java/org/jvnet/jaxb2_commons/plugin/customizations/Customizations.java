package org.jvnet.jaxb2_commons.plugin.customizations;

import javax.xml.namespace.QName;

public class Customizations {

  public static final String NAMESPACE_URI = "http://jaxb2-commons.dev.java.net/basic/customizations";

  public static final String CUSTOMIZATIONS_LOCAL_PART = "customizations";

  public static final QName CUSTOMIZATIONS_ELEMENT_NAME = new QName(NAMESPACE_URI, CUSTOMIZATIONS_LOCAL_PART);

  private Customizations() {}

}
