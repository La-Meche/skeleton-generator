package org.sklsft.generator.bc.file.command.impl.java.population;

import java.io.IOException;

import org.sklsft.generator.bc.file.command.impl.java.JavaFileWriteCommand;
import org.sklsft.generator.model.domain.business.Bean;
import org.sklsft.generator.model.domain.business.OneToManyComponent;
import org.sklsft.generator.model.domain.business.Property;
import org.sklsft.generator.model.metadata.DataType;

public class ViewOneToManyComponentBuilderFileWriteCommand extends JavaFileWriteCommand {

	private OneToManyComponent oneToManyComponent;
	private Bean referenceBean;
    private Bean parentBean;

    public ViewOneToManyComponentBuilderFileWriteCommand(OneToManyComponent oneToManyComponent){
        super(oneToManyComponent.referenceBean.myPackage.model.project.workspaceFolder + "\\" + oneToManyComponent.referenceBean.myPackage.model.project.projectName + "-populator\\src\\main\\java\\" + oneToManyComponent.referenceBean.myPackage.builderPackageName.replace(".","\\"),
        		oneToManyComponent.referenceBean.fullViewBean.className + "Builder");
        
        this.oneToManyComponent = oneToManyComponent;
        referenceBean = oneToManyComponent.referenceBean;
	    parentBean = oneToManyComponent.parentBean;
    }

	@Override
	protected void fetchSpecificImports() {
		
		javaImports.add("import java.util.Date;");
        javaImports.add("import " + oneToManyComponent.referenceBean.myPackage.ovPackageName + "." + oneToManyComponent.referenceBean.fullViewBean.className + ";");
	}

	@Override
	protected void writeContent() throws IOException {
		
		writeLine("package " + referenceBean.myPackage.builderPackageName + ";");
        skipLine();

        writeImports();
        skipLine();

        writeLine("/**");
        writeLine(" * auto generated view builder class file");
        writeLine(" * <br/>no modification should be done to this file");
		writeLine(" * <br/>processed by skeleton-generator");
		writeLine(" */");
        writeLine("public class " + referenceBean.fullViewBean.className + "Builder {");
        skipLine();
        
        writeLine("public static " + referenceBean.fullViewBean.className + " build(Object[] args) {");
        skipLine();
	    writeLine(referenceBean.fullViewBean.className + " " + referenceBean.fullViewBean.objectName + " = new " + referenceBean.fullViewBean.className + "();");
	    skipLine();
        
        Integer argNumber = parentBean.getFindProperties().size();
        for (Property property : referenceBean.fullViewBean.properties) {
            writeLine(referenceBean.fullViewBean.objectName + ".set" + property.capName + "((" + DataType.getJavaType(property.dataType) + ")args[" + argNumber + "]);");
            argNumber++;
        }

	    writeLine("return " + referenceBean.fullViewBean.objectName + ";");
        writeLine("}");
        writeLine("}");
		
	}
}