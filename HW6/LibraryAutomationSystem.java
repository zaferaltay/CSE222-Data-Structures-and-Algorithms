import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LibraryAutomationSystem {
	public static Map<String,Map<String,Set<String>>> authors=new HashMap<>();
	public static Map<String,Set<String>> books=new HashMap<>();
	public static Map<String,Set<String>> tempMap;
	public static Set<String> tempSet;

	
	
	
	/**
	 * Creates a set with location locations and writes to the inner map as a value.Makes the book name the key value of the inner map.
	 * Makes the inner map the value of the outer map.Makes author name outer key of map
	 * 
	 * @param an author name
	 * @param bn book name
	 * @param corridor corridor num
	 * @param shelf   shelf num
	 */
	public void addBook(String an,String bn,int corridor,int shelf) {
		String authorName=an;
		String bookName=bn;
		int get1=corridor;
		int get2=shelf;
		StringBuilder locations = new StringBuilder();
		
		locations.append("c");locations.append(new Integer(get1).toString());		
		locations.append("s");locations.append(new Integer(get2).toString());
		Random r=new Random();
		get1=r.nextInt(10000);locations.append(".");locations.append(new Integer(get1).toString());
		
		tempMap=authors.get(authorName);
		if(tempMap!=null){
			tempSet=tempMap.get(bookName);
			if(tempSet!=null){
				tempSet.add(locations.toString());
			}
			else {
				tempSet=new HashSet<>();
				tempSet.add(locations.toString());
				tempMap.put(bookName,tempSet);
			}		
		}
		else {
			tempSet=new HashSet<>();
			tempMap=new HashMap<>();
			tempSet.add(locations.toString());
			tempMap.put(bookName,tempSet);
			authors.put(authorName, tempMap);
		}
		
		
		
	}

	/**
	 * Searches for the name of the author in the keys of the external map.If it does, it looks for the name of the book among the keys of the inner map.
	 * If  finds both,  removes it.
	 * @param an author name
	 * @param bn book name
	 */
	public void deleteBook(String an,String bn) {
		String authorName=an;
		String bookName=bn;
		String locations;
		Scanner scan=new Scanner(System.in);
		
		tempMap=authors.get(authorName);
		if(tempMap!=null) {
			tempSet=tempMap.get(bookName);
			if(tempSet!=null) {
				System.out.println("Please select the book which you want delete");
				System.out.println(tempSet);
				System.out.println("Your choice(Please enter all code ex: c1s1.1111):");
				locations=scan.next();
				if(tempSet.remove(locations)) {
					System.out.println("The book removed succesfully");
					if(tempSet.size()==0) {
						tempMap.remove(bookName);
					}
				}
			}else {
				System.out.println("The book already deleted or never added");
			}
			
		}else {
			System.out.println("The book already deleted or never added");
		}

	}

	/**
	 * Finds the book as it found in the delete method. Lists its locations, gets the new location, and saves new values
	 * @param an author name
	 * @param bn book name
	 */
	public void updateInformation(String an,String bn) {
		String authorName=an;
		String bookName=bn;
		String locations;
		StringBuilder newlocations=new StringBuilder();
		int gett;
		Scanner scan=new Scanner(System.in);	
		tempMap=authors.get(authorName);
		if(tempMap!=null) {
			tempSet=tempMap.get(bookName);
			if(tempSet!=null) {
				System.out.println("Please select the book which you want to update");
				System.out.println(tempSet);
				System.out.println("Your choice(Please enter all code ex: c1s1.1111):");
				locations=scan.next();
				System.out.println("Please enter new locations");
				System.out.println("Corridor : ");
				gett=scan.nextInt();newlocations.append("c");newlocations.append(new Integer(gett).toString());
				System.out.println("Shelf : ");
				gett=scan.nextInt();newlocations.append("s");newlocations.append(new Integer(gett).toString());
				Random r=new Random();
				gett=r.nextInt(10000);newlocations.append(".");newlocations.append(new Integer(gett).toString());
				
				if(tempSet.remove(locations)) {
					tempSet.add(newlocations.toString());
				}
			}else {
				System.out.println("The book never added");
			}
			
		}else {
			System.out.println("The book never added");
		}
		
	}

	/**It travels all values ​​of the outer map with the iterator. It looks for the key value in the inner map of each value.If finds it, it is the book sought.
	 * @param name is book name
	 */
	public void searchingBook(String name) {
		String author;
		Iterator<Map.Entry<String,Map<String,Set<String>>>> iter=authors.entrySet().iterator();
		Iterator<Map.Entry<String,Map<String,Set<String>>>> iter2=authors.entrySet().iterator();
		while(iter.hasNext()) {
			tempMap=iter.next().getValue();
			author=iter2.next().getKey();
			tempSet=tempMap.get(name);
			if(tempSet!=null){
				System.out.println("Author of the "+name+" "+author);
				System.out.println("Locations of the "+name);
				System.out.println(tempSet);
				
			}

		}
		
	}

	/**
	 *It prints all the features of the value found by the keys of the outer map on the screen
	 * @param name is author name
	 */
	public void searchingAuthor(String name) {
		tempMap=authors.get(name);
		String book;
		if(tempMap!=null) {
			Iterator<Map.Entry<String,Set<String>>> iter=tempMap.entrySet().iterator();
			Iterator<Map.Entry<String,Set<String>>> iter2=tempMap.entrySet().iterator();
			
			while(iter.hasNext()) {
				book=iter.next().getKey();
				System.out.println(book);
				tempSet=iter2.next().getValue();
				System.out.println("Location of "+book+"'s");
				System.out.println(tempSet);
			}
			
		}
	}

	/**
	 * ​ It created iterator for both outher and internal map. It used a new inner map iterator for each value object of the iterator of the outer map, so It got around all the books. 
	 * The set of values ​ ​ for each object of the inner map of the iterator indicates the locations of a book in the library and printed them. 
	 */
	public void print() {
		String book;
		Iterator<Map.Entry<String,Map<String,Set<String>>>> iter=authors.entrySet().iterator();
		Iterator<Map.Entry<String,Map<String,Set<String>>>> iter2=authors.entrySet().iterator();
		
		while(iter.hasNext()){
			tempMap=iter.next().getValue();
			String name=iter2.next().getKey();
			Iterator<Map.Entry<String,Set<String>>> iter3=tempMap.entrySet().iterator();
			Iterator<Map.Entry<String,Set<String>>> iter4=tempMap.entrySet().iterator();
			System.out.println("Author Name: "+name);
			while(iter3.hasNext()) {
				book=iter3.next().getKey();
				System.out.println(book);
				tempSet=iter4.next().getValue();
				System.out.println("Locations of "+book);
				System.out.println(tempSet);
			}
		}
		
	}


}
