import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;




public class Details 
{
	public static void main(String[] args) throws Exception
	{
		{
//		    FileReader file = new FileReader("F:\\java_selenium\\core_java\\key.txt");
		    FileReader file = new FileReader("F:\\Work\\java\\javaApp2\\file\\keypair1.pem");
		    BufferedReader reader = new BufferedReader(file);

		    String key = "";
		    String line = reader.readLine();

		    while (line != null)
		    {
		        key += line;
		        line = reader.readLine();
		        key +="\n";
		    }

		    System.out.println(key); //this prints contents of .txt file
		}
	}

		
	
	public static void main1(String[] args) 
	{
		HashMap<String, String> hMap=new HashMap<>();
		hMap.put("allowed_headers","[\"*\"]");
		hMap.put("allowed_methods", "[\"PUT\",\"POST\"]");
//		hMap.put("allowed_methods", "POST");
		hMap.put("allowed_origins", "[\"https://reancloud.com\"]");
		hMap.put("expose_headers","[\"ETag\"]");
		hMap.put("max_age_seconds","3000");
		
		Set set=hMap.entrySet();
		Iterator iterator=set.iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry me = (Map.Entry)iterator.next();
	         System.out.print("\""+me.getKey()+"\""+ ": ");
	         System.out.println("\""+me.getValue()+"\"");
		}
		System.out.println();
	}
	
    

}
