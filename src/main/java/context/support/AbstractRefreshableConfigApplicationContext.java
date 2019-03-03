package context.support;

import Exception.ConfigPathisNull;

public abstract class AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext {
private String configpath;
	public void setSpringxmlpath(String path) {
		if(path!=null) {
			
			setConfigpath(path);
		}else {
			throw new ConfigPathisNull("spring path is must not null");
		}
		
		
	}
	public String getConfigpath() {
		return configpath;
	}
	public void setConfigpath(String configpath) {
		this.configpath = configpath;
	}
	
}
