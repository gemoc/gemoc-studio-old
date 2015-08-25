/*
 * Created on Mar 23, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JWindow;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;

import cnrs.luchogie.up.SwingPlotter;
import cnrs.luchogie.up.system.Arrow;
import cnrs.luchogie.up.system.Axis;
import cnrs.luchogie.up.system.AxisLine;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Graduation;
import cnrs.luchogie.up.system.Grid;
import cnrs.luchogie.up.system.Legend;
import cnrs.luchogie.up.system.Space;
import cnrs.luchogie.up.system.SpaceElement;

public class UI extends JFrame implements TreeSelectionListener
{
	private JTree tree = new JTree();
	private SwingPlotter plotter;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private Map editorMap = new HashMap();
	
	public UI(SwingPlotter plotter)
	{
		super("UP control panel");
		this.plotter = plotter;
		editorMap.put(SpaceElement.class, new GraphicalElementEditor());		
		editorMap.put(Arrow.class, new ArrowEditor());		
		editorMap.put(Legend.class, new LegendEditor());

		setSize(plotter.getSize().width, plotter.getSize().height);
		setLocation(plotter.getLocationOnScreen().x + plotter.getSize().width, plotter.getLocationOnScreen().y);


		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.WEST, new JScrollPane(tree));		

		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.add(BorderLayout.CENTER, tabbedPane);

		JPanel bohPanel = new JPanel(new BorderLayout());
		bohPanel.setBorder(new EtchedBorder());
		bohPanel.add(BorderLayout.WEST, new JLabel("Edit object as..."));
		JButton closeButton = new JButton("Close");
		closeButton.setBorder(null);
		closeButton.setForeground(Color.blue);
		closeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
		bohPanel.add(BorderLayout.EAST, closeButton);
		rightPanel.add(BorderLayout.NORTH, bohPanel);
		contentPane.add(BorderLayout.CENTER, rightPanel);		


		tree.getSelectionModel().setSelectionMode(DefaultTreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(new UpTreeCellRenderer());
		tree.setBorder(new EtchedBorder());
		tree.addTreeSelectionListener(this);
		buildTree(plotter);
		
		for (int i = 0; i < tree.getRowCount(); ++i)
		{
			tree.expandRow(i);
		}

		setVisible(true);
	}
	
	private void buildTree(SwingPlotter plotter)
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Plotter");
		TreeModel model = new DefaultTreeModel(root);
		buildTree(root, plotter.getGraphics2DPlotter().getSpace());
		tree.setModel(model);
	}
	
	private void buildTree(DefaultMutableTreeNode root, Space space)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(space);
		root.add(node);
		buildTree(node, space.getXDimension());
		buildTree(node, space.getYDimension());
		buildTree(node, space.getLegend());
	}

	private void buildTree(DefaultMutableTreeNode root, Legend legend)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(legend);
		root.add(node);
	}

	private void buildTree(DefaultMutableTreeNode root, Dimension dimension)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dimension);
		root.add(node);
		buildTree(node, dimension.getLowerBoundAxis());
		buildTree(node, dimension.getOriginAxis());
		buildTree(node, dimension.getUpperBoundAxis());
		buildTree(node, dimension.getGrid());
		buildTree(node, dimension.getLegend());
	}

	private void buildTree(DefaultMutableTreeNode root, Grid grid)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(grid);
		root.add(node);
	}

	private void buildTree(DefaultMutableTreeNode root, Axis axis)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(axis);
		root.add(node);
		buildTree(node, axis.getLine());
		buildTree(node, axis.getGraduation());
	}

	private void buildTree(DefaultMutableTreeNode root, AxisLine axisLine)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(axisLine);
		root.add(node);
		buildTree(node, axisLine.getArrow());
	}

	private void buildTree(DefaultMutableTreeNode root, Graduation graduation)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(graduation);
		root.add(node);
	}

	private void buildTree(DefaultMutableTreeNode root, Arrow arrow)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(arrow);
		root.add(node);
	}

	public SwingPlotter getPlotter()
	{
		return plotter;
	}

	public void valueChanged(TreeSelectionEvent event)
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) event.getPath().getLastPathComponent();
		Object object = node.getUserObject();
		
		while (tabbedPane.getTabCount() > 0)
		{
			tabbedPane.removeTabAt(tabbedPane.getTabCount() - 1);
		}
		
		if (object instanceof String)
		{
			tabbedPane.addTab("Up logo", new JLabel(new ImageIcon(Object.class.getResource("/res/logo.png"))));
		}
		else
		{		
			Iterator editors = getEditors(object).iterator();
		
			while (editors.hasNext())
			{ 
				Editor editor = (Editor) editors.next();
				editor.setObject(object);

				JPanel editorContainer = new JPanel(new GridBagLayout());
				editorContainer.add(editor);

				tabbedPane.addTab(editor.toString(), editorContainer);
			}
		}
	}

	private Collection getEditors(Object object)
	{
		Collection editors = new Vector();
		Class clazz = object.getClass();

		while (clazz != null)
		{
			Editor editor = (Editor) editorMap.get(clazz);

			if (editor != null && !editors.contains(editor))
			{
				editor.setUpUI(this);
				editors.add(editor);
			}

			clazz = clazz.getSuperclass();
		}

		return editors;
	}
	
	private JFrame getPlotterFrame()
	{
		Component parent = plotter.getParent();

		while (true)
		{
			if (parent == null)
			{
				return null;
			}
			else if (parent instanceof JFrame)
			{
				return (JFrame) parent;
			}
			else
			{
				parent = parent.getParent();
			}
		}
	}
	
	private int getIndexOfComponent(Container container, Component component)
	{
		for (int i = 0; i < container.getComponentCount(); ++i)
		{
			if (container.getComponent(i) == component)
			{
				return i;
			}
		}
		
		throw new IllegalArgumentException("component is not in container");
	}
}
