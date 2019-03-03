package context.support;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
	public ClassPathXmlApplicationContext(String configLocation){
		this(configLocation,true);
	}
	public ClassPathXmlApplicationContext(String configLocation,Boolean refresh) {
		
		setConfigpath(configLocation);
		if (refresh) {
			refresh();
		}
		
	}
	public <T> T getbean(String id) {
		// TODO Auto-generated method stub
		try {
			return dogetbean(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
