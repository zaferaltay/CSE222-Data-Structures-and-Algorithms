
/**
 * @author zafer
 * This interface stores some methods.
 */
public interface CCInterface {
		/**
		 * @param obj is added to personel list
		 */
		public void addBranchEmployee(BranchEmployee obj);
		/**
		 * if the number matches one, it is removed
		 * @param num BE num
		 */
		public void removeBranchEmployee(int num);
		/**
		 * @param obj is added to personel list
		 */
		public void addTransportationPersonnel(TransportationPersonnel obj);
		/**
		 * if the number matches one, it is removed
		 * @param num TP num
		 */
		public void removeTransportationPersonnel(int num);
}
