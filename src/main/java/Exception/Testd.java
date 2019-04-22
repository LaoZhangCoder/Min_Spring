package Exception;

import annotation.AspectJ;
import annotation.Pointcut;

@AspectJ
public class Testd {
@Pointcut(execution="test()")
public void method() {
	
}
}
