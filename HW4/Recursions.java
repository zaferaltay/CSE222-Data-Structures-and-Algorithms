import java.util.Stack;

/**
 * @author zafer
 *The class that contains recursion methods
 */
public class Recursions {

	Stack<String> postfix=new Stack<>();
	Stack<String> prefix=new Stack<>();
	
	/**
	 * Gets the string and writes the element in the index
	 * @param input string array
	 * @param now index element
	 */
	public void ReversingString(String input,int now){
		String []mystr = input.split("\\s+");
		if(now==mystr.length) {
			return;
		}
		System.out.printf("%s ",mystr[mystr.length-now-1]);
		ReversingString(input,++now);
	}
	/**
	 * Looks for the second string letters nextth element in the first string.
	 * @param myStr first string
	 * @param elfish second string
	 * @param next is num of scenond string element
	 * @return
	 */
	public int IsElfish(String myStr,String elfish,int next){
		
		if(next==elfish.length()) {
			return 1;
		}
		if(myStr.indexOf(elfish.charAt(next))!=-1) {			//new Character(elfish.charAt(next)).toString())
			return IsElfish(myStr,elfish,++next);
		}
			return 0;	
	}
	
	
	
	/**
	 *  Sorts the array from small to large
	 * Sorting my array
	 * @param myArray
	 * @param next
	 * @param next2
	 * @param minindex
	 */
	public void SelectionSort(int []myArray,int next,int next2,int minindex) {
		
		if(next<myArray.length-1) {
			int min=myArray[minindex];
			if(next2<myArray.length) {
				if(min>myArray[next2]) {
					min=myArray[next2];
					minindex=next2;
				}
				SelectionSort(myArray,next,++next2,minindex);
			
			}
			if(min<myArray[next]) {
				int temp=myArray[next];
				myArray[next]=myArray[minindex];
				myArray[minindex]=temp;
			}
			SelectionSort(myArray,++next,next+1,next);
		}
	
		
	}

	/**
	 * It breaks the index string and evaluates the next pearl index and returns the result of postfix result
	 * @param index
	 * @param next
	 * @return
	 */
	public int evaluatePostFix(String index,int next){
		String []input=index.split("\\s+");
		if(input.length==next)
			return Integer.parseInt(postfix.pop());
		else {
			if(Character.isDigit(input[next].charAt(0))) {
				postfix.push(input[next]);
			}
			else {
				int right=Integer.parseInt(postfix.pop());
				int left=Integer.parseInt(postfix.pop());
				int result=0;
				
				switch(input[next].charAt(0)) {
				   case '+':
					   result=right+left;
					   break;
				   case '-':
					   result=left-right;
					   break;
				   case '/':
					   result= left/right;
					   break;
				   case '*':
					   result= left*right;
					   break;
				}
				
				postfix.push(new Integer(result).toString());
				
			}
			 return evaluatePostFix(index,++next);
		}
		
		
	}
	
	/**
	 * It breaks the index string and evaluates the next pearl index and returns the result of prefix result
	 * @param str2
	 * @param next
	 * @return
	 */
	public int evaluatePreFix(String str2,int next) {
		int left=0;
		int right=0;
		int result=0;
		String []input=str2.split("\\s+");
		if(next<0) {
				return Integer.parseInt(prefix.pop());
			}
			else {
				
				if(Character.isDigit(input[next].charAt(0))) {
					prefix.push(input[next]);
				}
				else {
					
					switch(input[next].charAt(0)) {
					    case '+':
					    	left=Integer.parseInt(prefix.pop());
					    	right=Integer.parseInt(prefix.pop());
					    	result=left+right;
			
					    	break;
					    case '-':
					    	left=Integer.parseInt(prefix.pop());
					    	right=Integer.parseInt(prefix.pop());
					    	result=left-right;
					    	
					    	break;
					    case '*':
					    	left=Integer.parseInt(prefix.pop());
					    	right=Integer.parseInt(prefix.pop());
					    	result=left*right;
					    	
					    	break;	
					    case '/':
					    	left=Integer.parseInt(prefix.pop());
					    	right=Integer.parseInt(prefix.pop());
					    	result=left/right;
					    	
					    	break;					    	
					}
					prefix.push(new Integer(result).toString());
				}		
				return evaluatePreFix(str2,--next);
			}
	}


	

}
