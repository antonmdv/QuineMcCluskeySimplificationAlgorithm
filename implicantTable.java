import java.util.ArrayList;

public class implicantTable {
	
	ArrayList<ArrayList<ArrayList<Node>>> table;
	
	//ceate group only if there's anything to put in it 
	//public static ArrayList<Node> newGroup = new ArrayList<Node>();
	
	public implicantTable(){
		table = new ArrayList<ArrayList<ArrayList<Node>>>();
	}
	
	public void addElement(ArrayList<ArrayList<Node>> table){
		this.table.add(table);
		this.table.trimToSize();
	}
	
	
	public ArrayList<ArrayList<Node>> getRow(int i){
		return this.table.get(i);
	}
	
	public int getSize(){
		return this.table.size();
	}
	
	public void growTable(){
		
		int currentSize = table.size();
		ArrayList<ArrayList<Node>> row = table.get(currentSize-1);
		
		/////////////////////
		while(row.size() > 1){
			
			ArrayList<ArrayList<Node>> newRow = new ArrayList<ArrayList<Node>>();
			
			for(int groupNumber = 0; groupNumber<row.size()-1; groupNumber=groupNumber+1){
				
				//ceate group only if there's anything to put in it 
				//ArrayList<Node> newGroup = new ArrayList<Node>();
				ArrayList<Node> newGroup = new ArrayList<Node>();
				
				
				ArrayList<Node> groupOne = row.get(groupNumber);
				ArrayList<Node> groupTwo = row.get(groupNumber+1);
				
				////////
				for(int i = 0; i<groupOne.size(); i++){
					
					
					//int[] totalPath = groupOne.get(i).getPath();
					
					String compareGroupOne = groupOne.get(i).getBinary();
					//ArrayList<Integer> pathToOne = groupOne.get(i).getPath();
					
					for(int j=0; j<groupTwo.size(); j++){
					
						
						String compareGroupTwo = groupTwo.get(j).getBinary();
						
						//int[] pathToTwo = groupTwo.get(j).getPath();
						
						String result = checkStrings(compareGroupOne,compareGroupTwo);
						
						
						if((!result.isEmpty())){
						//if((!result.isEmpty()) && (checkForDuplicates(result,newGroup))){
							Node nd = new Node();
							
							groupOne.get(i).setFlag(true);
							groupTwo.get(j).setFlag(true);
							int[] totalPath = new int[groupOne.get(i).getPath().length + groupTwo.get(j).getPath().length];
							System.arraycopy(groupOne.get(i).getPath(), 0, totalPath, 0, groupOne.get(i).getPath().length);
							System.arraycopy(groupTwo.get(j).getPath(), 0, totalPath, groupOne.get(i).getPath().length, groupTwo.get(j).getPath().length);
							
							
							nd.setBinaryRepresentation(result);
							nd.setPath(totalPath);
				
							newGroup.add(nd);
						}
						
					}
					newGroup.trimToSize();
					System.out.println("");
				}
				
				//put new group in a row
				if(!newGroup.isEmpty()){
					newRow.add(newGroup);
					newRow.trimToSize();
					System.out.println("");
				}
				
			}
			
			if(!newRow.isEmpty()){
				System.out.println("");
				table.add(newRow);
				//table.addElement(newRow);
				row = newRow;
			}
			
			//this.newGroup = null;
		}
		//top is end of if/////////
		System.out.println("");
	}
	
	public static String checkStrings(String one, String two){
				
		String result = "";
		int dashCount = 0;
		
		for(int l = 0; l<one.length(); l++){
				
			char a = one.charAt(l);
			char b = two.charAt(l);
			
			if(a == b){
				result += a;
			}else{
				result += '-';
				dashCount++;
			}
				
		}
				
		if(dashCount > 1){
			result = "";
		}
				
		return result;
	}
	
	public static boolean checkForDuplicates(String str, ArrayList<Node> currentGroup){
		boolean duplicate = true;
		
		for(Node nd:currentGroup){
			String nodeString = nd.getBinary();
			if(nodeString.equals(str)){
				duplicate = false;
			}
		}
		return duplicate;
	}
}
