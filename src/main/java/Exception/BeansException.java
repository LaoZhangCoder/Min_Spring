package Exception;

public class BeansException extends RuntimeException {
	/**
	 * 
	 */
	private ErrorElemetProtory error;
	
	public ErrorElemetProtory getError() {
		return error;
	}
	public void setError(ErrorElemetProtory error) {
		this.error = error;
	}
	private static final long serialVersionUID = 1L;
	private String read;
	private String read1;
	
	
	public String getRead1() {
		return read1;
	}
	public void setRead1(String read1) {
		this.read1 = read1;
	}
	
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public BeansException() {
		
	}
	public BeansException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BeansException [error=" + error + ", read=" + read + ", read1=" + read1 +  "]";
	}

	

}
