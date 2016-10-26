package fileInterface;

import java.io.InputStream;

public interface IReadFromFile {
	 public void readFileByRandomAccess(String fileName);
	 public void readFileByLines(String fileName);
	 public void readFileByChars(String fileName) ;
	 public void readFileByBytes(String fileName);
	 //private void showAvailableBytes(InputStream in);
}
