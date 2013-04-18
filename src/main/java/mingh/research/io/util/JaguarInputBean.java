package mingh.research.io.util;

import java.util.Properties;

public class JaguarInputBean {
	
	private Properties inputParams;
	
	public JaguarInputBean() {
		inputParams = new Properties();
	}

	@Override
	public String toString() {
		String str = "Input Parameters are: \n";
		for (Object key : inputParams.keySet()){
			str += ( key + " = " + inputParams.getProperty((String) key) + "\n" );
		}
		return str;
	}

	public String toCommaDelimitedString() {
		String str = "";
		for (Object key : inputParams.keySet()){
			str += ( key + "=" + inputParams.getProperty((String) key) + "," );
		}
		if ( str.length() > 1){
			str = str.substring(0, str.length()-1); //remove the end ,
		}
		return str;
	}
	
	
	public Properties getInputParams() {
		return inputParams;
	}

	public void setInputParams(Properties inputParams) {
		this.inputParams = inputParams;
	}
	
	public void setInputParam(String key, String value) {
		this.inputParams.put(key, value);
	}

	public JaguarInputBean(Properties inputParams) {
		super();
		this.inputParams = inputParams;
	}
	
	
}
