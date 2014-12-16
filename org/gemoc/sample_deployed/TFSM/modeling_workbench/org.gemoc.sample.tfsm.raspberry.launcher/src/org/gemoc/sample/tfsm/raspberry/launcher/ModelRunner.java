package org.gemoc.sample.tfsm.raspberry.launcher;


public class ModelRunner 
{

	public static void main(String[] args) throws Exception
	{
		ModelRunner runner = new ModelRunner();
		runner.run();
	}
	
	public void run() throws Exception
	{
		Application app = new Application();
		app.start(null);
	}
	
}
