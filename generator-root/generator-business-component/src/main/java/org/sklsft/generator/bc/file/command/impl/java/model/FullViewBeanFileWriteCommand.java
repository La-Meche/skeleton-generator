package org.sklsft.generator.bc.file.command.impl.java.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.sklsft.generator.bc.file.command.impl.java.JavaFileWriteCommand;
import org.sklsft.generator.model.domain.business.Bean;
import org.sklsft.generator.model.domain.business.Property;


public class FullViewBeanFileWriteCommand extends JavaFileWriteCommand {

	private Bean bean;
	/*
	 * constructor
	 */
	public FullViewBeanFileWriteCommand(Bean bean) {
        
		super(bean.myPackage.model.project.workspaceFolder + File.separator + bean.myPackage.model.project.projectName + "-api\\src\\main\\java\\" + bean.myPackage.ovPackageName.replace(".","\\"), bean.fullViewBean.className);
		
		this.bean = bean;
		
	}
	
	@Override
	protected void fetchSpecificImports() {
		javaImports.add("import java.util.Date;");
        javaImports.add("import java.io.Serializable;");
	}
	
	
	@Override
	protected void writeContent() throws IOException {

		writeLine("package " + bean.myPackage.ovPackageName + ";");
        skipLine();

        writeImports();
        skipLine();

        writeLine("/**");
        writeLine(" * auto generated view bean class file");
        writeLine(" * <br/>basic representation of what is going to be considered as model in MVC patterns");
        writeLine(" * <br/>write modifications between specific code marks");
        writeLine(" * <br/>processed by skeleton-generator");
        writeLine(" */");
        writeLine("public class " + this.bean.fullViewBean.className + " implements Serializable {");
        skipLine();

        writeLine("private static final long serialVersionUID = 1L;");
        skipLine();

        createProperties();
        createGettersAndSetters();
        writeNotOverridableContent();
        
        writeLine("}");

    }

    private void createProperties()
    {
        writeLine("/*");
        writeLine(" * properties");
        writeLine(" */");
        writeLine("private Long id;");

        List<Property> visiblePropertyList = this.bean.fullViewBean.properties;

        for (Property property:visiblePropertyList) {
            writeLine("private " + property.beanDataType + " " + property.name + ";");
        }
        skipLine();

    }

    private void createGettersAndSetters()
    {
        writeLine("/*");
        writeLine(" * getters and setters");
        writeLine(" */");
        writeLine("public Long getId() {");
        writeLine("return this.id;");
        writeLine("}");
        skipLine();
        
        writeLine("public void setId(Long id) {");
        writeLine("this.id = id;");
        writeLine("}");
        skipLine();

        List<Property> visiblePropertyList = this.bean.fullViewBean.properties;

        for (Property property:visiblePropertyList) {
            writeLine("public " + property.beanDataType + " get" + property.capName + "() {");
            writeLine("return this." + property.name + ";");
            writeLine("}");
            skipLine();
            
            writeLine("public void set" + property.capName + "(" + property.beanDataType + " " + property.name + ") {");
            writeLine("this." + property.name + " = " + property.name + ";");
            writeLine("}");
            skipLine();
        }
        skipLine();
	}
}
