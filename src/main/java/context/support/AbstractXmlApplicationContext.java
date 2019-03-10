package context.support;
import java.io.File;
import beans.factory.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext {
	
	private final Object startupShutdownMonitor = new Object();
	private File file;
	
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	
			
		
		
		
		
	
	@Override
		protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
			
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		loadBeanDefinitions(beanDefinitionReader);
			
		}
	protected void loadBeanDefinitions(XmlBeanDefinitionReader reader)  {
		File file= getFile();
		if (file!= null) {
			reader.doLoadBeanDefinitions(file);
		}
		
	}
	}
