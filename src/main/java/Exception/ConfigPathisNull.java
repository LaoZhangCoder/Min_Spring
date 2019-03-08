package Exception;

public class ConfigPathisNull extends BeansException {
	private BeansException exception;
	private String readC;
	private String read1C;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	

	

	public BeansException getException() {
		return exception;
	}

	public void setException(BeansException exception) {
		this.exception = exception;
	}

	public String getReadC() {
		return readC;
	}

	public void setReadC(String readC) {
		this.readC = readC;
	}

	
	public String getRead1C() {
		return read1C;
	}

	public void setRead1C(String read1c) {
		read1C = read1c;
	}

	public ConfigPathisNull(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ConfigPathisNull() {
		super();
	}

	@Override
	public String toString() {
		return "ConfigPathisNull [exception=" + exception + ", readC=" + readC + ", read1C=" + read1C + "]";
	}
	
	

}
