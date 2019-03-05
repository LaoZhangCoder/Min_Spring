package Exception;

public class BeansException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String read;
	private String read1;
	private String read2;
	
	public String getRead1() {
		return read1;
	}
	public void setRead1(String read1) {
		this.read1 = read1;
	}
	public String getRead2() {
		return read2;
	}
	public void setRead2(String read2) {
		this.read2 = read2;
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

	

}
