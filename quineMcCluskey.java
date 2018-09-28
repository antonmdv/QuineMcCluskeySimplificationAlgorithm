import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class quineMcCluskey {

	
	public static void main(String[] args){
		
		//input
		int[] minTerms = {0,4,5,7,8,11,12,15};
		
		//construct Prime Implicant Table
		primeTable primeImplicantTable = solveForImplicants(minTerms);
		
		//Solve Prime Implicant Table
		
	}
	
	public static List readPITable(primeTable primeImplicantTable){
		List primeImplicants = null;
		
		ArrayList<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();
		
		return primeImplicants;
	}
	
	
	public static primeTable solveForImplicants(int[] minTerms){
		
		//entire table
		primeTable PT = new primeTable();
		
		ArrayList<ArrayList<Node>> table = new ArrayList<ArrayList<Node>>();
		
		//Need to ensure the correct group placement by the number of ones. So far works with only 4 bits 
		//Change later on

		for(int i = 0; i<5; i++){
			ArrayList<Node> group = new ArrayList<Node>();
			table.add(i, group);
		}
		
		//construct first column of the table
		for(int i:minTerms){
			
			int[] path = new int[1];
			path[0] = i;
			String bnr = Integer.toBinaryString(i);
			if(bnr.length() < 4){
				int missing = 4-bnr.length();
				String str = "";
				for(int k = 0; k<missing; k++){
					str = str+'0';
				}
				bnr = str+bnr;
			}
			//boolean check = (Boolean) null;
			
			int numberOfOnes = 0;
			for(int j = 0; j<bnr.length(); j++){
				if(bnr.charAt(j) == '1'){
					numberOfOnes++;
				}
			}
			
			Node node = new Node();
			node.setPath(path);
			node.setBinaryRepresentation(bnr);
			//node.setCheck(check);
			
			ArrayList<Node> currentGroup = table.get(numberOfOnes);
			currentGroup.add(node);
			currentGroup.trimToSize();
			
			table.set(numberOfOnes, currentGroup);
		}
		
		table.trimToSize();
		
		implicantTable mainTable = new implicantTable();
		mainTable.addElement(table);
		mainTable.growTable();
		
		System.out.println("");
		return PT;
	}
	
}
