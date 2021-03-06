package org.sklsft.generator.skeletons.jsf.commands.presentation.richfaces4;

import java.io.File;
import java.io.IOException;

import org.sklsft.generator.model.domain.business.Bean;
import org.sklsft.generator.model.domain.ui.ViewProperty;

public class Richfaces4ModalViewFileWriteCommand extends Richfaces4XhtmlFileWriteCommand {

	private Bean bean;
	
	public Richfaces4ModalViewFileWriteCommand(Bean bean) {
		super(bean.myPackage.model.project.workspaceFolder + File.separator + bean.myPackage.model.project.projectName + "-webapp" + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "sections" + File.separator  + bean.myPackage.name + File.separator + bean.className.toLowerCase(), bean.className + "Modal");

		this.bean = bean;
	}

	@Override
	protected void writeContent() throws IOException {

		writeLine("<ui:composition xmlns=" + CHAR_34 + "http://www.w3.org/1999/xhtml" + CHAR_34);
        writeLine("xmlns:ui=" + CHAR_34 + "http://java.sun.com/jsf/facelets" + CHAR_34);
        writeLine("xmlns:f=" + CHAR_34 + "http://java.sun.com/jsf/core" + CHAR_34);
        writeLine("xmlns:h=" + CHAR_34 + "http://java.sun.com/jsf/html" + CHAR_34);
        writeLine("xmlns:rich=" + CHAR_34 + "http://richfaces.org/rich" + CHAR_34);
        writeLine("xmlns:a4j=" + CHAR_34 + "http://richfaces.org/a4j" + CHAR_34);
        writeLine("xmlns:c=" + CHAR_34 + "http://java.sun.com/jstl/core" + CHAR_34 + ">");
        skipLine();

        writeLine("<!-- -->");
        writeLine("<!-- auto generated jsf file -->");
        writeLine("<!-- write modifications between specific code marks -->");
        writeLine("<!-- processed by skeleton-generator -->");
        writeLine("<!-- -->");
        skipLine();

        writeLine("<div class=" + CHAR_34 + "modal-header" + CHAR_34 + ">");
		writeLine("<h2>");
		writeLine("#{i18n." + bean.objectName + "Detail}");
		writeLine("</h2>");
		writeLine("</div>");
		skipLine();
		
		writeLine("<div class=" + CHAR_34 + "modal-body" + CHAR_34 + ">");
		skipLine();
		
		writeLine("<h:panelGroup id=" + CHAR_34 + this.bean.objectName + "DetailPanelGroup" + CHAR_34 + ">");
        
        writeLine("<a4j:region>");
        skipLine();

        writeLine("<ui:param name=" + CHAR_34 + "view" + CHAR_34 + " value=" + CHAR_34 + "#{" + this.bean.listViewObjectName + ".selected" + this.bean.className + "}" + CHAR_34 + "/>");
        writeLine("<ui:param name=" + CHAR_34 + "form" + CHAR_34 + " value=" + CHAR_34 + "#{view.form}" + CHAR_34 + "/>");
        skipLine();
        
        writeLine("<div class=" + CHAR_34 + "row" + CHAR_34 + ">");

        for (ViewProperty property : this.bean.formBean.properties) {
        	writeInput(property, bean);
        }
        
        writeLine("</div>");

        skipLine();        
        
        if (bean.createEnabled) {
	        writeLine("<a4j:commandButton value=" + CHAR_34 + "#{i18n.save}" + CHAR_34 + " action=" + CHAR_34 + "#{" + bean.listControllerObjectName + ".save}" + CHAR_34 
	        		+ " rendered=" + CHAR_34 + "#{empty view.id}" + CHAR_34
	        		+ " styleClass=" + CHAR_34 + "btn btn-success" + CHAR_34 + " execute=" + CHAR_34 + "@region" + CHAR_34 + " render=" + CHAR_34 + bean.objectName + "PanelGroup, " + bean.objectName
					+ "DetailPanelGroup" + CHAR_34 + " oncomplete=" + CHAR_34 + "if (#{empty facesContext.maximumSeverity or facesContext.maximumSeverity.ordinal ==0}) $('#" + bean.objectName + "Modal').modal('hide');"
					+ CHAR_34 + "/>");
        }
        
        if (bean.updateEnabled) {
	        writeLine("<a4j:commandButton value=" + CHAR_34 + "#{i18n.update}" + CHAR_34 + " action=" + CHAR_34 + "#{" + bean.listControllerObjectName + ".update}" + CHAR_34 
					+ " rendered=" + CHAR_34 + "#{not empty view.id}" + CHAR_34 + " disabled=" + CHAR_34 + "#{not view.canUpdate}" + CHAR_34
					+ " styleClass=" + CHAR_34 + "btn btn-success" + CHAR_34 + " execute=" + CHAR_34 + "@region" + CHAR_34 + " render=" + CHAR_34 + bean.objectName + "PanelGroup, " + bean.objectName
					+ "DetailPanelGroup" + CHAR_34 + " oncomplete=" + CHAR_34 + "if (#{empty facesContext.maximumSeverity or facesContext.maximumSeverity.ordinal ==0}) $('#" + bean.objectName + "Modal').modal('hide');"
					+ CHAR_34 + "/>");
        }
        
		writeLine("<a4j:commandButton value=" + CHAR_34 + "#{i18n.cancel}" + CHAR_34 + " actionListener=" + CHAR_34 + "#{" + bean.listControllerObjectName + ".resetForm}" + CHAR_34
				+ " styleClass=" + CHAR_34 + "btn btn-info" + CHAR_34 
				+ " immediate=" + CHAR_34 + "true" + CHAR_34 + " execute=" + CHAR_34 + "@region" + CHAR_34 + " render=" + CHAR_34 + bean.objectName + "PanelGroup" + CHAR_34 
				+ " oncomplete=" + CHAR_34 + "$('#" + bean.objectName + "Modal').modal('hide')" + CHAR_34 + "/>");


        this.writeNotOverridableContent();
        skipLine();

        writeLine("</a4j:region>");
        skipLine();
        
        writeLine("</h:panelGroup>");
        skipLine();
        
        writeLine("</div>");
        skipLine();
        
        writeLine("</ui:composition>");
    }
}
