 import java.io.File;
import java.io.IOException;


public class temp {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		String path = "\\\\10.42.63.11\\bat"+File.separator+"hello"+File.separator+"hi.txt";
		//(use relative path for Unix systems)
		File f = new File(path);
		//(works for both Windows and Linux)
		f.mkdirs(); 
		f.createNewFile();
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String mstr="wh1!wh2!wh3",s="!";
//		String[] arr=mstr.split(s);
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.println(arr[i]);
//		}
//		String run="\\\\10.42.63.11\\bat\\bat.bat";
//		File file = new File("\\\\10.42.63.11/bat/bat.bat");
//	//	Runtime.getRuntime().exec("build.bat", null, new File("."));
//		//Process p=Runtime.getRuntime().exec(run);
		String[] command ={"\\\\10.42.63.11\\cmd.exe", "/C", "Start ","FireFox Driver","\\\\10.42.63.11\\bat\\bat.bat"};
//		Runtime r = Runtime.getRuntime();
//		Process p=r.exec(command);
//
//		
//		
//		
//		System.out.println(file.canExecute());
//        System.out.println(file.getAbsolutePath());
		
		
		
		
	}

}
