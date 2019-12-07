package FunctionLibrary;
import java.io.FileWriter;


public class CSS_StyleSheet {

	public static void write_StyleSheet(String path) throws Exception{
		Global objGolbal = new Global();

		FileWriter f0=new FileWriter(path);

		String mstrstyleStrt="<!DOCTYPE html><head>\n\n<link href='css/bootstrap.css' rel='stylesheet' type='text/css' />\n\n";
		f0.append(mstrstyleStrt);
		String mstrDoc_end="\n</head>";
		f0.append(mstrDoc_end);

		f0.close();
	}

}
