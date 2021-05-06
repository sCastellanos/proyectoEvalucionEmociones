package userInput;

import java.util.ArrayList;
import java.util.List;

public class DimensionTree {
	
	private String identifier;
	private List<DimensionTree> children = new ArrayList<DimensionTree>();
	
	public DimensionTree(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the children
	 */
	public List<DimensionTree> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void addChild(DimensionTree child) {
		children.add(child);
	}
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return identifier;
	}
	
	@Override
	public boolean equals(Object o) {
		if((o instanceof DimensionTree) && (((DimensionTree)o).identifier == identifier)){
			return true;
		}else{
			return false;
		}
	}
	
	
}
