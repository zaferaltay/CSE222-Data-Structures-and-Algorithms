/**
 * @author zafer
 *This class keeps and sharing shipments informations with setters and getters
 */
public class Cargo {
 
 protected int trackingNumber;
 protected String senderName;
 protected String recieverName;
 protected int currentStatus;
 
 public void setSenderName(String name) {
	 senderName=name;
 }
 public String getSenderName() {
	 return senderName;
 }
 public void setRecieverName(String name) {
	 recieverName=name;
 }	
 public String getRecieverName() {
	 return recieverName;
 }
 public int getTrackingNumber() {
	return trackingNumber;
 }
 public void setTrackingNumber(int trackingNumber) {
	this.trackingNumber = trackingNumber;
 }
 public int getCurrentStatus() {
	return currentStatus;
 }
 public void setCurrentStatus(int currentStatus) {
	this.currentStatus = currentStatus;
 }

  /**
 *toString function for Cargo
 */
public String toString() {
	  return String.format("\nSender name: %s Reciever name: %s \nTracking Number: %d",senderName,recieverName,trackingNumber);
  }
  
}
