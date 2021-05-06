package userInput;

public class ActionInputSignal implements IncomingInputInterface {
	private String who;
	private String identifier;
	private String tag;
	
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}
	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	/**
	 * @return the type
	 */
	public String getWho() {
		return who;
	}
	/**
	 * @param type the type to set
	 */
	public void setWho(String who) {
		this.who = who;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return identifier;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if((o instanceof ActionInputSignal) && (((ActionInputSignal)o).identifier == identifier)){
			return true;
		}else{
			return false;
		}
	}
	
}
