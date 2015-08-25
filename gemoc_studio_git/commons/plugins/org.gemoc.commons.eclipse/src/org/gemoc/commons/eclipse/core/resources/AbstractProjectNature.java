package org.gemoc.commons.eclipse.core.resources;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public abstract class AbstractProjectNature implements IProjectNature {

	private IProject _project;

	@Override
	public IProject getProject() {
		return _project;
	}

	@Override
	public void setProject(IProject project) {
		_project = project;
	}

	protected void addBuilder(String builderId) throws CoreException 
	{
		IProjectDescription desc = _project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderId)) {
				return;
			}
		}

		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 0, commands.length);
		ICommand command = desc.newCommand();
		command.setBuilderName(builderId);
		newCommands[newCommands.length - 1] = command;
		desc.setBuildSpec(newCommands);
		_project.setDescription(desc, null);
	}
	
	protected void removeBuilder(String builderId) throws CoreException
	{
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderId)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i,
						commands.length - i - 1);
				description.setBuildSpec(newCommands);
				_project.setDescription(description, null);			
				return;
			}
		}
	}

}
