package org.jvnet.jaxb2_commons.plugin.codegenerator;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.xml.bind.JAXBElement;

import org.apache.commons.lang3.Validate;
import org.jvnet.jaxb2_commons.codemodel.JCMType;
import org.jvnet.jaxb2_commons.codemodel.JCMTypeFactory;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JType;

public class CodeGenerationAbstraction<A extends Arguments<A>> implements CodeGenerator<A> {

  private final JCodeModel codeModel;
  private final JCMTypeFactory typeFactory = JCMTypeFactory.INSTANCE;
  // Known code generators
  private final Map<JCMType<?>, CodeGenerator<A>> codeGenerators = new LinkedHashMap<>();
  private final CodeGenerator<A> defaultCodeGenerator;

  private final CodeGenerationImplementor<A> implementor;

  public CodeGenerationAbstraction(CodeGenerationImplementor<A> generationImplementor) {

    this.implementor = Validate.notNull(generationImplementor);
    this.codeModel = generationImplementor.getCodeModel();

    addCodeGenerator(this.codeModel.BOOLEAN, new BooleanCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.BYTE, new ByteCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.CHAR, new CharCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.DOUBLE, new DoubleCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.FLOAT, new FloatCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.LONG, new LongCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.INT, new IntCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.SHORT, new ShortCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.BOOLEAN.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.BYTE.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.SHORT.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.CHAR.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.INT.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.FLOAT.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.LONG.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.DOUBLE.array(), new ArrayCodeGenerator<>(this, this.implementor));
    addCodeGenerator(this.codeModel.ref(Object.class).array(), new ArrayCodeGenerator<>(this, this.implementor));

    addCodeGenerator(
        this.codeModel.ref(JAXBElement.class).narrow(Object.class),
        new JAXBElementCodeGenerator<>(this, this.implementor, this.typeFactory));

    addCodeGenerator(this.codeModel.ref(List.class).narrow(Object.class),
        new ListCodeGenerator<>(this, this.implementor));

    addCodeGenerator(this.codeModel.ref(Object.class),
        new ObjectCodeGenerator<>(this, this.implementor));
    defaultCodeGenerator = new ObjectCodeGenerator<>(this,
        this.implementor);
  }

  private void addCodeGenerator(final JType type,
      CodeGenerator<A> codeGenerator) {
    final JCMType<?> factoredType = typeFactory.create(type);
    this.codeGenerators.put(factoredType, codeGenerator);
  }

  private CodeGenerator<A> getCodeGenerator(JType type) {
    final JCMType<JType> factoredType = typeFactory.create(type);
    for (Entry<JCMType<?>, CodeGenerator<A>> entry : codeGenerators
        .entrySet()) {
      if (entry.getKey().matches(factoredType)) {
        return entry.getValue();
      }
    }
    return defaultCodeGenerator;
  }

  @Override
  public void generate(JBlock block, JType type,
      Collection<JType> possibleTypes, boolean isAlwaysSet, A arguments) {
    getCodeGenerator(type).generate(block, type, possibleTypes, isAlwaysSet,
        arguments);
  }
}
