package org.gemoc.execution.engine.io.controlpanels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.io.ControlPanel;

public class ConsoleControlPanel implements ControlPanel {

	private ExecutionEngine engine;

	public void initialize(ExecutionEngine engine) {
		this.engine = engine;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("Enter method name : (run)");
			String s = br.readLine();
			if (s.equals("run")) {
				System.out.println("Enter number of steps to run: (int)");
				try {
					int i = Integer.parseInt(br.readLine());
					this.engine.run(i);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
