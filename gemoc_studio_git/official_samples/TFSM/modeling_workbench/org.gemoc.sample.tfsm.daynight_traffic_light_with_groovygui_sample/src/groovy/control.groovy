package groovy
import java.io.File;

//
// This code controls the GUI
// The methods are invoked from the kermeta's code
//
class ControlScript {
	// Returns true if it's day
	boolean isDay() {
		def s = new Socket("localhost", 4444)
		s.withStreams { input, output ->
		  output << "isday" + "\n"
		  def buffer = input.newReader().readLine()
		  if (buffer == "true") {return true} 
		  else {return false}
		}
	}
	// Return true if it's night
	boolean isNight() {
		def s = new Socket("localhost", 4444)
		s.withStreams { input, output ->
		  output << "isnight" + "\n"
		  def buffer = input.newReader().readLine()
		  if (buffer == "true") {return true} 
		  else {return false}
		}
	}
	// Turn the semaphore to green
	void doGreen() {
		def s = new Socket("localhost", 4444)
		s.withStreams { input, output ->
		  output << "setgreen" + "\n"
		}
	}
	// Turn the semaphore to red
	void doRed() {
		def s = new Socket("localhost", 4444)
		s.withStreams { input, output ->
		  output << "setred" + "\n"
		}
	}
	
	void doNight(){
		// dosomething
	}
	
	void doDay(){
	// dosomething
}
	
	void dosomething(){
	// dosomething
}
	

	
	
	void doTick() {
		def s = new Socket("localhost", 4444)
		s.withStreams { input, output ->
		  output << "tick" + "\n"
		}
	}
	
}