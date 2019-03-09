package beans.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enums.Scope;

/*
 * @author cwt
 * @since  2017-01-25
 */
public  class BeanDefinition {
  private String id;
  private String name;
  private String  scope=Scope.valueOf(0);
  private String classpath;
  private HashMap<String, String> protpertymaps=new HashMap<String, String>() ;
  private List<String> depends=new ArrayList<String>();
  protected Map<String, String> refname = new HashMap<String, String>();
  
  
public Map<String, String> getRefname() {
	return refname;
}
public void setRefname(Map<String, String> refname) {
	this.refname = refname;
}
public BeanDefinition() {
	super();
}
public HashMap<String, String> getProtpertymaps() {
	return protpertymaps;
}
public void setProtpertymaps(HashMap<String, String> protpertymaps) {
	this.protpertymaps = protpertymaps;
}
public List<String> getDepends() {
	return depends;
}
public void setDepends(List<String> depends) {
	this.depends = depends;
}
public HashMap<String, String> getMap() {
	return protpertymaps;
}
public void setMap(HashMap<String, String> map) {
	this.protpertymaps = map;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getScope() {
	return scope;
}
public void setScope(String scope) {
	this.scope = scope;
}
public String getClasspath() {
	return classpath;
}
public void setClasspath(String classpath) {
	this.classpath = classpath;
}

@Override
public String toString() {
	return "BeanDefinition [id=" + id + ", name=" + name + ", scope=" + scope + ", classpath=" + classpath
			+ ", protpertymaps=" + protpertymaps + ", depends=" + depends + ", refname=" + refname + "]";
}
public Class<?> getBeanClass() throws ClassNotFoundException {
	// TODO Auto-generated method stub
	return Class.forName(getClasspath());
}

	
}
