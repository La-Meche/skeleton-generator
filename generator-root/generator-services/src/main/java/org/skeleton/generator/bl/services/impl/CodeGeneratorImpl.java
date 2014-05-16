package org.skeleton.generator.bl.services.impl;

import org.skeleton.generator.bc.executor.FileWriteCommandTree;
import org.skeleton.generator.bc.factory.command.file.impl.FileWriteCommandTreeFactoryBuilder;
import org.skeleton.generator.bc.factory.command.file.interfaces.FileWriteCommandTreeFactory;
import org.skeleton.generator.bl.services.interfaces.CodeGenerator;
import org.skeleton.generator.model.om.Project;
import org.springframework.stereotype.Component;

/**
 * An implementation of a {@link CodeGenerator} that uses a {@link FileWriteCommandTreeFactory} to build its {@link FileWriteCommandTree} trees<br/>
 * The choice of the factory is determined by a static Builder ({@link FileWriteCommandTreeFactoryBuilder})
 * @author Nicolas Thibault
 *
 */
@Component
public class CodeGeneratorImpl implements CodeGenerator {

	@Override
	public FileWriteCommandTree buildFileImportTree(Project project) {

		FileWriteCommandTreeFactory factory = FileWriteCommandTreeFactoryBuilder.getFileWriteCommandTreeFactory(project);
		
		return factory.buildFileImportTree(project);
	}
	
	@Override
	public FileWriteCommandTree buildConfigurationTree(Project project) {

		FileWriteCommandTreeFactory factory = FileWriteCommandTreeFactoryBuilder.getFileWriteCommandTreeFactory(project);
		
		return factory.buildConfigurationTree(project);
	}
	
	@Override
	public FileWriteCommandTree buildFileWriteCommandTree(Project project) {

		FileWriteCommandTreeFactory factory = FileWriteCommandTreeFactoryBuilder.getFileWriteCommandTreeFactory(project);
		
		return factory.buildTree(project);
	}	

	@Override
	public void generateCode(FileWriteCommandTree tree) {

		tree.launch();
		
	}

}
