package mingh.research.io.util;

public class JaguarPropertyBean {

	private String propertyName;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public String toString() {
		return "Jaguar property [propertyName=" + propertyName + "]\n";
	}

	public JaguarPropertyBean() {}
	
	public JaguarPropertyBean(String propertyName) {
		super();
		this.propertyName = propertyName;
	}
	
	
}
