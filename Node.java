import java.util.ArrayList;

public class Node {

	int[] path;
	String bnr;
	boolean flag;
	
	public Node(){
		path=null;
		bnr=null;
		flag = false;
	}
	
	//setters
	public void setPath(int[] path){
		this.path = path;
	}
	
	public void setBinaryRepresentation(String bnr){
		this.bnr = bnr;
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}

	
	//getters
	public int[] getPath(){
		return this.path;
	}

	public String getBinary(){
		return this.bnr;
	}
	
	public boolean getFlag(){
		return this.flag;
	}

}
