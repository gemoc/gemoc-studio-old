/*
 * Created on Nov 30, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up;


/**
 * @author luc
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class CyclicTask
{
	private double frequency = 0;
	private Thread thread = null;
	private SwingPlotter plotter;
	
	abstract public void doIt();

	public void periodExceeded(long duration)
	{
		new Error( "the run() method of the cylic task took " + duration + " ms to execute, this is too long. You should optimize it or set a smaller grapic update frequency." ).printStackTrace();
	}
	

	/**
	 * @return
	 */
	public final double getFrequency()
	{
		return frequency;
	}

	/**
	 * Sets the frequency of the update process. There is a background
	 * thread (with maximum priority) that will invoke the cyclic task, the
	 * <code>setUpdatedNeed( true) </code> and <code>repaint()</code>
	 * methods of the component.
	 * @param newFrequency
	 */
	public void setFrequency( double newFrequency )
	{
		if ( newFrequency != frequency )
		{
			frequency = newFrequency;

			if ( frequency > 0 )
			{
				if ( thread == null )
				{
					thread = new Thread( new TaskThread() );
					thread.setPriority(Thread.MAX_PRIORITY);
					thread.start();
				}
				else
				{
					thread.interrupt();
				}
			}
			else
			{
				if ( thread != null )
				{
					thread = null;
				}
			}
		}
	}


	/**
	 * @return
	 */
	public SwingPlotter getPlotter()
	{
		return plotter;
	}

	/**
	 * @param plotter
	 */
	public void setPlotter(SwingPlotter plotter)
	{
		this.plotter = plotter;
	}


	private class TaskThread extends Thread
	{
		public void run()
		{
			while ( thread != null )
			{
				try
				{
					long period = (long) (1000 / getFrequency());
					long start = System.currentTimeMillis();
					doIt();
	
					long end = System.currentTimeMillis();
					long duration = end - start;
					
					if ( duration > period )
					{
						periodExceeded(duration);
					}
					else
					{
						Thread.sleep( period - duration );
					}

					Thread.yield();
	
					if (getPlotter() != null)
					{
						getPlotter().setUpdateNeeded( true );
						getPlotter().repaint(0);
					}
				}
				catch ( InterruptedException ex )
				{
				}
			}
		}
	}

}
