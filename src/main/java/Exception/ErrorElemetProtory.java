package Exception;

public class ErrorElemetProtory extends BeansException {
	/**
	 * 
	 */
	private ConfigPathisNull config;
	private String readB;
	private String read1B;
	
	

	public ConfigPathisNull getConfig() {
		return config;
	}

	public void setConfig(ConfigPathisNull config) {
		this.config = config;
	}

	public String getReadB() {
		return readB;
	}

	public void setReadB(String readB) {
		this.readB = readB;
	}


	public String getRead1B() {
		return read1B;
	}

	public void setRead1B(String read1b) {
		read1B = read1b;
	}


	private static final long serialVersionUID = 1L;

	public ErrorElemetProtory(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorElemetProtory() {
		
	}
}
