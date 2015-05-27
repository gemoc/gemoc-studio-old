import java.io.File;

//
// This code can be called in EvalautedGuard
// they will be invoked from the kermeta's code
// this can be used to implement a GUI or to implement model specific behavior
//
class ControlScript {
	// Returns true if it's day
	boolean isDay() {
		return true
	}
	// Return true if it's night
	boolean isNight() {
		return false
	}
	// Turn the semaphore to green
	void doGreen() {
		println  "user model script> doGreen()" 
	}
	// Turn the semaphore to red
	void doRed() {
		println  "user model script> doRed()" 
	}
	
	void doNight(){
		println  "user model script> doNight()"
	}
	
	void doDay(){
		println  "user model script> doDay()" 
	}
	
	void doSomething(){
		println  "user model script> doSomething()" 
	}
	
	void doTick() {
		println  "user model script> doTick()"
	}
	
}