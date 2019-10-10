// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.
import java.util.HashMap;

public class Environment {
    private HashMap <String, Double> hm= new HashMap<String, Double>();

    /**
     * puts the value val for key var in the hashmap
     * @param var
     * @param val
     * @return val
     */
    public double put(String var, double val) {
        hm.put(var, val);
        return val;
    }

    /**
     * gets the value for the key var
     * @param pos
     * @param var
     * @return key
     * @throws EvalException
     */
    public double get(int pos, String var) throws EvalException {
        return hm.get(var);
    }

}
