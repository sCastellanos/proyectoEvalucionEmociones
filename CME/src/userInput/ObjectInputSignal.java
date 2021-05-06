package userInput;

public class ObjectInputSignal implements IncomingInputInterface {
	private String identifier;		// takes the value of the form of the shape
	private int xi,yi,xf,yf,w,h;
	private String color;
	
	
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
	 * @return the xi
	 */
	public int getXi() {
		return xi;
	}
	/**
	 * @param xi the xi to set
	 */
	public void setXi(int xi) {
		this.xi = xi;
	}
	/**
	 * @return the yi
	 */
	public int getYi() {
		return yi;
	}
	/**
	 * @param yi the yi to set
	 */
	public void setYi(int yi) {
		this.yi = yi;
	}
	/**
	 * @return the xf
	 */
	public int getXf() {
		return xf;
	}
	/**
	 * @param xf the xf to set
	 */
	public void setXf(int xf) {
		this.xf = xf;
	}
	/**
	 * @return the yf
	 */
	public int getYf() {
		return yf;
	}
	/**
	 * @param yf the yf to set
	 */
	public void setYf(int yf) {
		this.yf = yf;
	}
	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}
	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}
	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}
	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}
	/**
	 * @return the objColorFigure
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param objColorFigure the objColorFigure to set
	 */
	public void setColor(String color) {
		this.color = color;
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
		if((o instanceof ObjectInputSignal) && (((ObjectInputSignal)o).identifier == identifier)){
			return true;
		}else{
			return false;
		}
	}
	
}
