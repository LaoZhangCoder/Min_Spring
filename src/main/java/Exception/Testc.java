package Exception;

import annotation.Component;

@Component
public class Testc {
private Testa testa;
private String testc;

public Testa getTesta() {
	return testa;
}



public void setTesta(Testa testa) {
	this.testa = testa;
}







public String getTestc() {
	return testc;
}



public void setTestc(String testc) {
	this.testc = testc;
}



@Override
public String toString() {
	return "Testc [testa=" + testa.toString() + ", testc=" + testc + "]";
}



public void test() {
	System.out.println("testc的值为"+testc);
}
}
