import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Source
{
	public static void main(String[] args)
	{
		//Write("Good Morning");
		//Write("Purushottam");
		Read();
	}
	
	public static void Write(String msg)
	{
		FileOutputStream fos = null;
		try 
		{
			//fos = new FileOutputStream("F:\\JavaTest\\data.txt"); //for write 
			fos = new FileOutputStream("F:\\JavaTest\\data.txt", true); //for appending
			fos.write(msg.getBytes());
			System.out.println("File Write Complete ...");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found : " + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("IO Error : " + e.getMessage());
		}
		finally
		{
			try 
			{
				if(fos != null)
					fos.close();
			} catch (IOException e) 
			{
				System.out.println("IO Error : " + e.getMessage());
			}
		}
	}
	
	public static void Read()
	{
		File file = new File("F:\\JavaTest\\data.txt");
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			byte[] data = new byte[(int)file.length()];
			fis.read(data);
			String myData = new String(data);
			System.out.println("Data Read= "+ myData);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found : " + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("IO Error : " + e.getMessage());
		}
		finally
		{
			try 
			{
				if(fis != null)
					fis.close();
			} catch (IOException e) 
			{
				System.out.println("IO Error : " + e.getMessage());
			}
		}
	}
	
	public static void main2(String[] args)
	{
		File file=new File("F:\\JavaTest1");
		
		System.out.println("Folder Exists:"+file.exists());
		System.out.println("File List:");
		
		String[] filenames=file.list();
		for (String filename : filenames) 
		{
			System.out.println(filename);
						
		}
	}
	public static void main1(String[] args) 
	{
		File objFile = new File("F:\\JavaTest");
		
		System.out.println("Folder Exists: " + objFile.exists());
		
		if(!objFile.exists())
		{
			if(objFile.mkdir())
				System.out.println("Folder Created Successfully");
			else
				System.out.println("Folder Creation Failed !!!");
		}
		
		System.out.println("Files List:");
	    /*String[] fnames = objFile.list();
	    for(String fname: fnames)
	    {
	    	//System.out.println(fname);
	    	System.out.print(objFile.getAbsolutePath() +"\\"+ fname);
	    	
	    	if(fname.contains(".xml"))
	    	{
	    		File f = new File(objFile.getAbsolutePath() +"\\"+ fname);
	    		if(f.delete())
	    			System.out.print("*** Deleted ***");
	    	}
	    	System.out.println("");
	    }*/
		
		File[] files = objFile.listFiles();
		for(File f : files)
		{
			System.out.println(f.getName());
			System.out.println(f.length()+" Bytes");
			//System.out.println(f.getAbsolutePath());
			/*if(f.getName().contains(".class"))
			{
				if(f.delete())
				{
					System.out.println("File Deleted !!!");
				}
			}*/
		}
	}

}
