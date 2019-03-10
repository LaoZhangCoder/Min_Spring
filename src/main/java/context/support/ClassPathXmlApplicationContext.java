package context.support;
import java.io.File;
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
	private File file;
	public ClassPathXmlApplicationContext(String configLocation) {
		this.file=new File(configLocation);
		setFile(file);
		refresh();
		
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	
}
