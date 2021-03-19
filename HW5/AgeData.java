/**
 * @author zafer
 * This class is our special type class.The class that holds age and ageNum
 */
public class AgeData implements Comparable<AgeData> {

	private int age;
	private int ageNum;
	
	public AgeData(int age) {
		this.age=age;
		ageNum=1;
	}
	/**
	 *Compares its own age with the same type of object.
	 *if the incoming object greater than this return positive , less than return negative, or they are equals returns 0.
	 */
	public int compareTo(AgeData item) {
		if(age>item.age) {
			return 1;
		}
		else if(age<item.age) {
			return -1;
		}
		else {
			return 0;
		}
	}
	public int getAgeNum() {
		return ageNum;
	}
	/**
	 * Increases AgeNum by 1
	 */
	public void increaseAgeNum() {
		ageNum++;
	}
	/**
	 * Decreases AgeNum by 1
	 */
	public void decreaseAgeNum() {
		ageNum--;
	}
	/**
	 *Return string that has age and ageNum
	 */
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(age);
		sb.append("-");
		sb.append(ageNum);
		return sb.toString();
	}
	public int getAge() {
		return age;
	}
}
