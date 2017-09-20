import org.junit.runner.*;
import org.junit.runner.notification.Failure;
public class SpiralTestExecution {
	public static void main(String[] args){
		Spiral ExecutionSpiral = new Spiral();
		Result result = JUnitCore.runClasses(SpiralTest.class);
		for (Failure fail :result.getFailures()){
			System.out.println(fail.toString());
		}
		if(result.wasSuccessful()){
			
			ExecutionSpiral.drawMatrix();
			System.out.println("\n\nAll Test cases finished successfully");
		}
	}
}
