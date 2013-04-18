package mingh.research.io.util;

public class JaguarFileBean {

	private String relativePath;
	
	private long size; //in byte
	
	private String type; //the suffix

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public JaguarFileBean(String relativePath, long size, String type) {
		super();
		this.relativePath = relativePath;
		this.size = size;
		this.type = type;
	}

	@Override
	public String toString() {
		return "JaguarFileBean [relativePath=" + relativePath + ", size="
				+ size + ", type=" + type + "]";
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
