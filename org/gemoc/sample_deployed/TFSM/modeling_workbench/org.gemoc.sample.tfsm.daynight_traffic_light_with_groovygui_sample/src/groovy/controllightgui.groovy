package groovy

import javax.swing.WindowConstants as WC
import java.awt.BorderLayout as BL
import java.awt.FlowLayout;
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.*
import org.eclipse.swt.layout.RowLayout as Layout
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.events.*
import java.net.ServerSocket
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.Font
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI


//
// Here is implemented the GUI which is controlled by the calls from groovy-kermeta methods
// 
class controllightgui {
	
	
	
	def crossredday = new Image(display, ResourcesPlugin.getWorkspace().getRoot()
		.findMember("/org.gemoc.sample.tfsm.daynight_single_traffic_light_sample/groovy/cross0-day.png").getLocation().toString())
	def crossrednight = new Image(display, ResourcesPlugin.getWorkspace().getRoot()
		.findMember("/org.gemoc.sample.tfsm.daynight_single_traffic_light_sample/groovy/cross0-night.png").getLocation().toString())
	def crossgreenday = new Image(display, ResourcesPlugin.getWorkspace().getRoot()
		.findMember("/org.gemoc.sample.tfsm.daynight_single_traffic_light_sample/groovy/cross1-day.png").getLocation().toString())
	def crossgreennight = new Image(display, ResourcesPlugin.getWorkspace().getRoot()
		.findMember("/org.gemoc.sample.tfsm.daynight_single_traffic_light_sample/groovy/cross1-night.png").getLocation().toString())
	
	
	
	def server = new ServerSocket(4444)
	def boolean needRefresh = true
	def boolean isDay = true
	def boolean isNight = false
	
	def boolean isRed = true
	def boolean isGreen = false
	def nticks = 0 
	Font f = new Font("Serif", Font.BOLD, 16) 
	
	def display
	
	def boolean needToClose = false
	
	//
	// Semaphore GUI initialization
    void initControlLight() { 
		def displayThread = Thread.start {
			def display = new Display(); // display must be created in the thread that wait for the  readAndDispatch()
			def shell = new Shell(display)
			def cross = new Label(shell, SWT.NONE)
			
			def tick = new Label(shell, SWT.NONE)
			
			println "Traffic Control initialization ... done"
			println "Starting at Day"
			
			shell.text = 'Traffic Control: on Day'
			
			shell.setSize (crossredday.width, crossredday.height)
			
			// starting in red
			cross.setImage(crossredday)
			cross.pack()
			
			tick.setText('0 minutes')
			tick.setLocation(300, crossredday.height+15)
			tick.pack()
			
			
			// Day/Night Button 
			Button dayButton = new Button(shell, SWT.TOGGLE)
			Button nightButton = new Button(shell, SWT.TOGGLE)
			
			dayButton.setSelection(true)
			dayButton.text = ' Day '	
			dayButton.addSelectionListener({ SelectionEvent se -> 
				isDay = true
				isNight = false
				nightButton.setSelection(false)
				shell.text = 'Traffic Control: on Day'
				needRefresh = true
			} as SelectionListener)
			dayButton.setLocation(0, crossredday.height+10 )
			dayButton.pack()
			
			// Night Button
			nightButton.setSelection(false)
			nightButton.text = ' Night '
			nightButton.addSelectionListener({ SelectionEvent se -> 
				isDay = false
				isNight = true
				dayButton.setSelection(false)
				shell.text = 'Traffic Control: on Night'
				needRefresh = true
			} as SelectionListener)
			nightButton.setLocation(50, crossredday.height+10 )
			nightButton.pack()
			
			shell.pack()
			shell.open()
			
			println "listening at localhost:4444"
			
			def th = Thread.start {
				while (!needToClose) {
					server.accept { socket ->
						println "---- new request ----"
						socket.withStreams { input, output ->
							def reader = input.newReader()
							def buffer = reader.readLine()
							println "received: $buffer"
							if (buffer == 'setred') {
								isRed = true
								isGreen = false
								println "Light in red"
							} else if (buffer == 'setgreen') {
									isGreen = true
									isRed = false
									println "Light in green"
							} else if (buffer == 'isday'){
									output << isDay.toString() + "\n"
									println "returned: "+isDay.toString()
							} else if (buffer == 'isnight') {
									output << isNight.toString() + "\n"
									println "returned: "+isNight.toString()
							} else if (buffer == "tick") {
									nticks = nticks + 1
									println "ticked: " + nticks.toString()
							} else if (buffer == "close"){
								println "closing "
								needToClose = true 
							}
							println "---- request finished ----"
						}
					
				}
				needRefresh = true
			 }
			}
			
			
			while (!shell.disposed && !needToClose) {
				if(needRefresh){
					if (isRed) {
						if (isDay) {cross.setImage(crossredday)} else {cross.setImage(crossrednight)}
						} else{
						 if (isDay){cross.setImage(crossgreenday)} else {cross.setImage(crossgreennight)}
						} 
					tick.setText(nticks.toString()+' minutes ')
					needRefresh = false
				}
				if (!shell.display.readAndDispatch()) shell.display.sleep()
			}
			needToClose = true
			def s = new Socket("localhost", 4444)
			s.withStreams { input, output ->
			  output << "close" + "\n"
			}
			// wait a bit, that the socket is correctly closed
			shell.display.sleep(2000)
			server.close()
		}
    }
	
	
}


