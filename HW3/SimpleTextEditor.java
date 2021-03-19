import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class SimpleTextEditor{

	private List<Character> textEditor;
	private String arrayy;
	public String path=new String("abc.txt");
	
	/**
	 * Read from file the normally and add the text
	 * @throws IOException
	 */
	public void readFromFileNormal() throws IOException {
		  File dosya = new File(path);  
		  FileReader oku = new FileReader(dosya);
		  BufferedReader oku2 = new BufferedReader(oku);
		  arrayy = oku2.readLine();
		  
		  for(int i=0;i<arrayy.length();i++) {
			  textEditor.add(arrayy.charAt(i));
		  }
	}
	/**
	 * Read from file with iterator and add the text
	 * @throws IOException
	 */
	public void readFromFileIterator() throws IOException {
		  File dosya = new File(path);  
		  FileReader oku = new FileReader(dosya);
		  BufferedReader oku2 = new BufferedReader(oku);
		  arrayy = oku2.readLine();
		  ListIterator<Character> iter=textEditor.listIterator();
		  for(int i=0;i<arrayy.length();i++) {
			  iter.add(arrayy.charAt(i));
		  }
	}
	
	/**
	 * Adds the string to text at specified position using loop
	 * @param index where to start adding
	 * @param word is letters to add
	 */
	public void addNormal(int index,String word) {
		for(int i=0;i<word.length();i++) {
			textEditor.add(i+index, word.charAt(i));
		}
	}
	/**
	 * Adds the string to text at specified position using iterator
	 * @param index where to start adding
	 * @param word is letters to add
	 */
	public void addIterator(int index,String word) {
		ListIterator<Character> iter=textEditor.listIterator(index);
		for(int i=0;i<word.length();i++) {	
			iter.add(word.charAt(i));
		}
	}
	
	/**
	 * Searches for the word given with string.If it finds it, it returns the index that it started.If is not found,it return -1.(Use Loop)
	 * @param word is searched word
	 * @return starting index or -1
	 */
	public int findNormal(String word) {
		int firstOccur=-1,countEquals=0;
		
			for(int i=0;i<textEditor.size();i++) {
				for(int j=0;j<word.length();j++) {
					firstOccur=i;
					if(textEditor.get(i+j)==word.charAt(j)) {
						countEquals++;
					}
				}
				if(countEquals==word.length()) {
					return firstOccur;
				}
				firstOccur=-1;
				countEquals=0;
			}
		return -1;
	}
	/**Searches for the word given with string.If it finds it, it returns the index that it started.If is not found,it return -1.(Use iterator)
	 * @param word is searched word
	 * @return starting index or -1
	 */
	public int findIterator(String word){
		int firstOccur=-1,countEquals=0,i=0;
		ListIterator<Character> iterator=textEditor.listIterator();
		while(iterator.hasNext()) {
			ListIterator<Character> iter=textEditor.listIterator(i);
			for(int j=0;j<word.length();j++) {
				if(textEditor.size()-i<word.length()) {
					return -1;
				}
				firstOccur=i;
				if(iter.next()==word.charAt(j)) {
					countEquals++;
				}
			}
			if(countEquals==word.length()) {
				return firstOccur;
			}
			firstOccur=-1;
			countEquals=0;
			i++;
			iterator.next();
		}
	return -1;	
		
	}
	/**
	 * Replaces characters that equals(it use loop)
	 * @param old is old character
	 * @param neww is new character
	 */
	public void replacesNormal(Character old,Character neww) {		
		for(int i=0;i<textEditor.size();i++) {
			if(textEditor.get(i)==old) {
				textEditor.set(i, neww);
			}
		}
	}
	/**
	 * Replaces characters that equals(it use iterator)
	 * @param old is old character
	 * @param neww is new character
	 */
	public void replacesIterator(Character old,Character neww) {
		ListIterator<Character> iter=textEditor.listIterator();
		if(iter.next()==old) {
			iter.set(neww);
		}
	}
	
	/**	The methods return the text
	 * @return
	 */
	public List<Character> getTextEditor() {
		return textEditor;
	}
	/**
	 * No paramater constructor
	 */
	public SimpleTextEditor() {
		textEditor=new ArrayList<>();
	}
	/**
	 * One paramater consructor takes the object and creates text from the list type
	 * @param Obj type of list
	 */
	public SimpleTextEditor(List Obj) {
		if(Obj instanceof ArrayList) {
			textEditor=new ArrayList<>();
		}
		else {
			textEditor=new LinkedList<>();
		}
	}
		
}
