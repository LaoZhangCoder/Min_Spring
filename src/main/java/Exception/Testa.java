package Exception;

import annotation.Component;

@Component
public class Testa {
private Testb b;
private String testa;
public Testb getB() {
	return b;
}
public void setB(Testb b) {
	this.b = b;
}
public String getTesta() {
	return testa;
}
public void setTesta(String testa) {
	this.testa = testa;
}
public String ccc() {
	return "Testa [b=" + b + ", testa=" + testa + "]";
}
public void test() {
	System.out.println("testa的值为"+testa);
}

}
