package Exception;

public class Testb {
private Testa testa;
private Testc testc;
private String testb;
public Testa getTesta() {
	return testa;
}

public void setTesta(Testa testa) {
	this.testa = testa;
}

public Testc getTestc() {
	return testc;
}

public void setTestc(Testc testc) {
	this.testc = testc;
}

public String getTestb() {
	return testb;
}

public void setTestb(String testb) {
	this.testb = testb;
}


public String toStringa() {
	return "Testb [testa=" + testa + ", testc=" + testc + ", testb=" + testb + "]";
}

public void test() {
	System.out.println("testb的值为"+testb);
}



}
