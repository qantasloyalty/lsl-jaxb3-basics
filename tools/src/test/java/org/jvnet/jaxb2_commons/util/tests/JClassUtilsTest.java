package org.jvnet.jaxb2_commons.util.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.Externalizable;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.jvnet.jaxb2_commons.util.JClassUtils;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

class JClassUtilsTest {

  private JCodeModel codeModel = new JCodeModel();

  @Test
  void correctlyChecksIsInstanceOf() throws JClassAlreadyExistsException {

    final JClass arrayList = codeModel.ref("java.util.ArrayList");
    assertTrue(JClassUtils.isInstanceOf(arrayList, Collection.class));
    final JDefinedClass subArrayList = codeModel._class("SubArrayList");
    subArrayList._extends(arrayList);
    assertTrue(JClassUtils.isInstanceOf(subArrayList,
        Collection.class));

    final JClass subArrayListOfObjects = subArrayList.narrow(Object.class);
    assertTrue(JClassUtils.isInstanceOf(subArrayListOfObjects,
        Collection.class));

    final JDefinedClass subExternalizable = codeModel
        ._class("SubExternalizable");
    subExternalizable._implements(Externalizable.class);
    assertTrue(JClassUtils.isInstanceOf(subExternalizable,
        Externalizable.class));

    subArrayList._implements(subExternalizable);
    assertTrue(JClassUtils.isInstanceOf(subArrayList,
        Externalizable.class));

    assertFalse(JClassUtils.isInstanceOf(codeModel.NULL,
        Collection.class));

  }
}
