package core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public interface Resource  extends InputStreamSource{
	//判断文件是否存在
	boolean exists();
   //是否只可以读
	boolean isReadable();

    //是否能打开
	boolean isOpen();

	URL getURL() throws IOException;

	
	URI getURI() throws IOException;

	
	File getFile() throws IOException;

	String getFilename();

	String getDescription();
}
