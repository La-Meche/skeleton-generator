package org.skeleton.generator.bc.factory.command.file.impl;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.generator.bc.executor.FileWriteCommandTree;
import org.skeleton.generator.bc.executor.FileWriteCommandTreeNode;
import org.skeleton.generator.bc.factory.command.file.interfaces.FileWriteCommandTreeFactory;
import org.skeleton.generator.bc.strategy.interfaces.LayerStrategy;
import org.skeleton.generator.model.om.Project;

public class AbstractFileWriteCommandTreeFactory implements FileWriteCommandTreeFactory {

	protected LayerStrategy fileImportStrategy;
	
	protected LayerStrategy configurationStrategy;
	
	protected List<LayerStrategy> layerStrategies;
	
	public AbstractFileWriteCommandTreeFactory() {
		layerStrategies = new ArrayList<>();
	}
	
	
	@Override
	public FileWriteCommandTree buildFileImportTree(Project project) {
		return new FileWriteCommandTree(fileImportStrategy.getLayerNode(project));
	}

	@Override
	public FileWriteCommandTree buildConfigurationTree(Project project) {
		return new FileWriteCommandTree(configurationStrategy.getLayerNode(project));
	}
	
	@Override
	public FileWriteCommandTree buildTree(Project project) {

		FileWriteCommandTreeNode rootNode = new FileWriteCommandTreeNode(project.projectName);
		FileWriteCommandTree tree = new FileWriteCommandTree(rootNode);
		
		for (LayerStrategy layerStrategy:layerStrategies) {
			rootNode.add(layerStrategy.getLayerNode(project));
		}
		
		return tree;
	}
}