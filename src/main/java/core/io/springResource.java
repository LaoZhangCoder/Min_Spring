package core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class springResource implements Resource{
private File file;
private String path;

	public springResource(File file, String path) {
	super();
	this.setFile(file);
	this.setPath(path);
}
	

	public springResource(String path) {
		super();
		this.path = path;
	}


	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReadable() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public URL getURL() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public URI getURI() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public File getFile() throws IOException {
		// TODO Auto-generated method stub
		return getFile();
	}

	public String getFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
