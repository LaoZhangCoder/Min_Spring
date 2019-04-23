package Exception;

import annotation.After;
import annotation.AspectJ;
import annotation.Before;
import annotation.Pointcut;

@AspectJ
public class Testd {
@Pointcut(execution="test()")
public void method() {
	
}
@Before
public void befter() {
	System.out.println("Befter---------");
}
@After
public void after() {
	System.out.println("After-------");
}
}
