package collectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicate
{

	public static void main(String[] args)
	{
		 Set<String> uniques = new HashSet<String>();
	        Set<String> dups    = new HashSet<String>();

	        for (String a : args)
	            if (!uniques.add(a))
	                dups.add(a);

	        // Destructive set-difference
	        uniques.removeAll(dups);

	        System.out.println("Unique words:    " + uniques);
	        System.out.println("Duplicate words: " + dups);
	}

	public static void main1(String[] args) 
	{
		 Set<String> s = new HashSet<String>();
	        for (String a : args)
	               s.add(a);
	               System.out.println(s.size() + " distinct words: " + s);
	    
		
	}
//	program prints out all distinct words in its argument list
	public static void main0(String[] args) 
	{
		Set<String> distinctWords = Arrays.asList(args).stream()
				.collect(Collectors.toSet());
		System.out.println(distinctWords.size()+ " distinct words:"+distinctWords);

	}
}


