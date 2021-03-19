import java.util.Comparator;

/**
 * @author zafer
 *Special comparison class
 * @param <E>
 */
public class MyComparator<E extends Comparable<E>> implements Comparator<E> {

	/**
	 *class comparing the ageNums of the arg0 and arg1
	 *if arg0>arg1 ,returns 1
	 *if arg0<arg1 ,return -1
	 *if arg0=arg1, returns 0
	 */
	@Override
	public int compare(E arg0, E arg1) {
		if(arg0 instanceof AgeData) {
		  if(((AgeData) arg0).getAgeNum()>((AgeData) arg1).getAgeNum()) {
			  return 1;
		  }
		  else if(((AgeData) arg0).getAgeNum()==((AgeData) arg1).getAgeNum()) {
			  return 0;
		  }
		  else {
			  return -1;
		  }
		}
		else{
			return arg0.compareTo(arg1);
		}
	}

}
