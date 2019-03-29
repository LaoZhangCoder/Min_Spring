package Exception;


public class Testa {
	private Testc testc;
 private byte bytea;
 private int  inta;
 private short shorta;
 private Boolean booleana;
 private String stringa;
public byte getBytea() {
	return bytea;
}
public Testc getTestc() {
	return testc;
}
public void setTestc(Testc testc) {
	this.testc = testc;
}
public void setBytea(byte bytea) {
	this.bytea = bytea;
}
public int getInta() {
	return inta;
}
public void setInta(int inta) {
	this.inta = inta;
}
public short getShorta() {
	return shorta;
}
public void setShorta(short shorta) {
	this.shorta = shorta;
}
public Boolean getBooleana() {
	return booleana;
}
public void setBooleana(Boolean booleana) {
	this.booleana = booleana;
}
public String getStringa() {
	return stringa;
}
public void setStringa(String stringa) {
	this.stringa = stringa;
}
@Override
public String toString() {
	return "Testa [testc=" + testc + ", bytea=" + bytea + ", inta=" + inta + ", shorta=" + shorta + ", booleana="
			+ booleana + ", stringa=" + stringa + "]";
}

 
	
	

}
