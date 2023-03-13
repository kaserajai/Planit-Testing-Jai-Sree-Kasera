package StepDefinitions;

import enums.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	
	private Map<String, Object> scenarioContext;
	
	
	
	public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }
	
	public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }
	
	public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
	

}


//Explanation
//
//scenarioContext : This is a HasMap object which stores the information in the Key-Value pair. Key type is String and Value can be of any Object Type.
//setContext(): This method takes two parameters,  key as String and value as object. Key is nothing but a Context enum.
//getContext(): This method takes the key as a parameter and returned the object which matches the key.
//isContains(): This method performs a check on the complete Map that if it contains the key or not.
