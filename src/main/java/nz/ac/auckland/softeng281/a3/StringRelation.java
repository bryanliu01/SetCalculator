package nz.ac.auckland.softeng281.a3;

import java.util.List;

//*******************************
//YOU SHOULD MODIFY THIS CLASS FOR TASK2, TASK3, TASK4, TASK5, and TASK6.
//- you can add all the methods that you need.
//- you cannot modify the method signature (return type, method name and parameters) of the existing methods
//- you can change the code of the existing methods but at your own risk! the program might not work properly
//*******************************

/**
 * A class for binary relations over a set of strings.
 *
 * @author Partha Roop
 */
public class StringRelation extends SetOfStrings {
	// This is a set used to store the members of the binary relation
	private SetOfStrings setMembers;

	/**
	 * create an empty StringRelation when no arguments are given -- constructor In
	 * this event the setMembers is a new SetOfStrings with no members yet
	 */
	public StringRelation() {
		this(new SetOfStrings());
	}

	/**
	 * create a StringRelation object
	 */
	public StringRelation(SetOfStrings setMembers) {
		super();
		this.setMembers = setMembers;
	}

	public void setSetMemberElements(SetOfStrings set) {
		setMembers = set;
	}

	public boolean isValid() {
		SetOfStrings product = setMembers.product(setMembers);
		return product.isSupersetOf(this);
	}

	public boolean isReflexive() {
		if (!isValid()) {
			return false;
		}
		//The following gets the elements from setMembers and relations
		//setMembers.getElements();
		//this.getElements();
		
	
		List<String> setMemberElements = setMembers.getElements();
		List<String> relationElements = this.getElements();
		
		//Set up count to return true if count equals size
		int count = 0;
		int i;
		int size = setMemberElements.size();

		//Iterate through each element and compare to each string
		for (String setElement: setMemberElements) {
			for (String relationElement: relationElements) {
				
				//String builder set up, do not include comma
				int commaIndex = relationElement.indexOf(",");

				StringBuilder indexRelation1 = new StringBuilder();
				StringBuilder indexRelation2 = new StringBuilder();
				
				
				//String builder for first element in relation
				for (i = 0; i < commaIndex; i++) {
					indexRelation1.append(relationElement.charAt(i));
				}
				//String builder for second element in relation
				for (i = commaIndex + 1; i < relationElement.length(); i++) {
					indexRelation2.append(relationElement.charAt(i));
				}
				
				String relationStr1 = indexRelation1.toString();
				String relationStr2 = indexRelation2.toString();
				
				
				//Continues through the loop comparing index char variables
				//Returns true if all elements in set satisfies relation
				//Otherwise, false
				if ((setElement.equals(relationStr1)) && (setElement.equals(relationStr2))) {
					count++;

				}
			}
			
		}
		if (count == size) return true;
		else return false;
		
	}
		

	public boolean isSymmetric() {
		if (!isValid()) {
			return false;
		}
		//Plan
		//Iterate through each element, if element fits relation index 0, store the entire relation
		//Check if that relation has symmetric properties by reversing the char variable assignments
		
		//The following gets the elements from setMembers and relations
		//setMembers.getElements();
		//this.getElements();
		
	
		List<String> relationElements = this.getElements();
		
		//Cannot have symmetric relations if set size is 1 or relation has odd number of elements
		
		int target = relationElements.size();
		int count = 0;
		int i;
		
		for (String relationElement: relationElements) {
			
			//String builder set up, do not include comma
			int commaIndex1 = relationElement.indexOf(",");

			StringBuilder indexRelation1 = new StringBuilder();
			StringBuilder indexRelation2 = new StringBuilder();
			
			
			//String builder for first element in relation
			for (i = 0; i < commaIndex1; i++) {
				indexRelation1.append(relationElement.charAt(i));
			}
			//String builder for second element in relation
			for (i = commaIndex1 + 1; i < relationElement.length(); i++) {
				indexRelation2.append(relationElement.charAt(i));
			}
			
			String relationStr1 = indexRelation1.toString();
			String relationStr2 = indexRelation2.toString();
			
			for (String compareRelationElement: relationElements) {
				
				int commaIndex2 = compareRelationElement.indexOf(",");
				StringBuilder indexRelation3 = new StringBuilder();
				StringBuilder indexRelation4 = new StringBuilder();
				
				
				//String builder for first element in relation
				for (i = 0; i < commaIndex2; i++) {
					indexRelation3.append(compareRelationElement.charAt(i));
				}
				//String builder for second element in relation
				for (i = commaIndex2 + 1; i < compareRelationElement.length(); i++) {
					indexRelation4.append(compareRelationElement.charAt(i));
				}
				
				String relationStr3 = indexRelation3.toString();
				String relationStr4 = indexRelation4.toString();
				
				if ((relationStr1.equals(relationStr4)) && (relationStr2.equals(relationStr3))) {
					count++;
				}
				
			}
		}
		if (count == target) return true;
		else return false;

	}

	public boolean isTransitive() {
		if (!isValid()) {
			return false;
		}	
		//Plan
		//First loop iterates through relations
		//From second loop, find relations that have the same char as y in (x,y) and (y,z)
		//From third loop, after satisfying both first and second loop, find relation (x,z)
		
		List<String> relationElements = this.getElements();
		
		
		int count = 0;
		int countFinal = 0;
		int i;
		
		for (String firstRelation: relationElements) {
			
			int commaIndex1 = firstRelation.indexOf(",");

			StringBuilder indexRelation1 = new StringBuilder();
			StringBuilder indexRelation2 = new StringBuilder();
			
			
			//String builder for first element in relation
			for (i = 0; i < commaIndex1; i++) {
				indexRelation1.append(firstRelation.charAt(i));
			}
			//String builder for second element in relation
			for (i = commaIndex1 + 1; i < firstRelation.length(); i++) {
				indexRelation2.append(firstRelation.charAt(i));
			}
			
			//x
			String relationStr1 = indexRelation1.toString();
			
			//y
			String relationStr2 = indexRelation2.toString();
			
			for (String secondRelation: relationElements) {
				
				int commaIndex2 = secondRelation.indexOf(",");

				StringBuilder indexRelation3 = new StringBuilder();
				StringBuilder indexRelation4 = new StringBuilder();
				
				
				//String builder for first element in relation
				for (i = 0; i < commaIndex2; i++) {
					indexRelation3.append(secondRelation.charAt(i));
				}
				//String builder for second element in relation
				for (i = commaIndex2 + 1; i < secondRelation.length(); i++) {
					indexRelation4.append(secondRelation.charAt(i));
				}
				
				//y
				String relationStr3 = indexRelation3.toString();
				
				//z
				String relationStr4 = indexRelation4.toString();
				
				if (relationStr2.equals(relationStr3)) {
					for (String thirdRelation: relationElements) {
						
						int commaIndex3 = thirdRelation.indexOf(",");

						StringBuilder indexRelation5 = new StringBuilder();
						StringBuilder indexRelation6 = new StringBuilder();
						
						
						//String builder for first element in relation
						for (i = 0; i < commaIndex3; i++) {
							indexRelation5.append(thirdRelation.charAt(i));
						}
						//String builder for second element in relation
						for (i = commaIndex3 + 1; i < thirdRelation.length(); i++) {
							indexRelation6.append(thirdRelation.charAt(i));
						}
						
						//x
						String relationStr5 = indexRelation5.toString();
						
						//z
						String relationStr6 = indexRelation6.toString();
						
						//If x from first loop = x from third loop and z from second loop = z from third loop, continue.
						if (relationStr1.equals(relationStr5) && (relationStr4.equals(relationStr6))) {
							continue;
						}
						else count++;
					}
					
					//From the second loop iteration, if none of the elements can match (x,z) then the relation is not transitive
					if (count == relationElements.size()) {
						return false;
					}
					
					//Reset count for next third loop iteration
					count = 0;
				}
			}
			//Counter to see if entire loop runs without break
			countFinal++;
		}
		
		//If entire nested loop runs without break, then the transitive condition is satisfied.
		if (countFinal == relationElements.size()) return true;
		else return false;
		
	}

	public boolean isEquivalence() {
		
		//If relation is equivalent, then it will satisfy all three of the following relations
		if (this.isReflexive() && this.isSymmetric() && this.isTransitive()) {
			return true;
		}
		else return false;
			
		//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * do not change this method
	 * 
	 * @param node
	 * @return
	 */
	public SetOfStrings eqClass(String node) {
		if (!isEquivalence()) {
			System.out.println("Can't compute equivalence class.. NOT an equivalence relation");
			return new SetOfStrings();
		}
		return computeEqClass(node);
	}

	public SetOfStrings computeEqClass(String node) {
		SetOfStrings equivalenceClass = new SetOfStrings();
		
		//If the relation is not equivalent, then the object will be returned as empty
		if (!this.isEquivalence()) {
			return new SetOfStrings();
		}
		List<String> relationElements = this.getElements();
		int i;
		

		for (String relationElement: relationElements) {
			//String builder set up
			int commaIndex = relationElement.indexOf(",");

			StringBuilder indexRelation1 = new StringBuilder();
			StringBuilder indexRelation2 = new StringBuilder();
			
			
			//String builder for first element in relation
			for (i = 0; i < commaIndex; i++) {
				indexRelation1.append(relationElement.charAt(i));
			}
			//String builder for second element in relation
			for (i = commaIndex + 1; i < relationElement.length(); i++) {
				indexRelation2.append(relationElement.charAt(i));
			}
			
			String relationStr1 = indexRelation1.toString();
			String relationStr2 = indexRelation2.toString();
			
			//If node is equal to the first element, insert second element in equivalenceClass
			if (node.equals(relationStr1)) {
				equivalenceClass.insertElement(relationStr2);
			}
		}
		
		return equivalenceClass;
	}
}