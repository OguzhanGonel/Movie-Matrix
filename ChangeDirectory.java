package driver;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Changes the current working directory to the specified directory.
 *
 */
public class ChangeDirectory {

  
/**
 * It is the current working directory.
 */
private String currentDirectory;

/**
 * The tree of the current working directory.
 */
private Tree currentDirectoryTree;

/**
 * Returns the current directory
 * @param It takes in no parameters
 * @return It returns the current directory.
 */
public String getCurrentDirectory(){
	return currentDirectory;
}

/**
 * Sets the current directory
 * @param The directory that you want to set the current directory to.
 */
public void setCurrentDirectory(String directory){
	this.currentDirectory = directory;
}

/**
 * Sets the current directory tree to the given tree.
 * @param Current Directory tree
 */
public void setCurrentDirectoryTree(Tree cdt){
	this.currentDirectoryTree = cdt;
}

/**
 * Returns the current directory tree.
 * @return It returns the current directory tree.
 */
public Tree getCurrentDirectoryTree(){
	return currentDirectoryTree;
}

/**
 * Initializes the ChangeDirectory object.
 * @param The root of the tree
 */
public ChangeDirectory(Tree root){
	this.currentDirectory = "/";
	this.currentDirectoryTree = root;
}

/**
 * This method checks what the input is, and calls the next method to change 
 * the directory.
 * @param The input given into JShell. 
 * @param The current directory object.
 * @param The current directory according to JShell.
 * @param The initial tree.
 */
public void CheckString(String A, String CurrentDirectory,
		ChangeDirectory currentDirectory, Tree initial){

	// This checks if the input wants to go up a directory.
	if (A.equals("..")){
		moveUP(A, CurrentDirectory, currentDirectory, initial);
	}

	// Checks if the user wants to change a directory from a relative path

	else if (A.substring(0, 1).equals("/")){
		moveFromRoot(A, CurrentDirectory,
				currentDirectory, initial);
	}

	// This checks for an invalid input.
	else if (A.matches(".*  .*")){
		System.out.print("Invalid Input");
	}

	// This checks if the input wants to go down one directory to the next one.
	else{
		moveFromRelative(A, CurrentDirectory, currentDirectory, initial);
	}
}  

/**
 * This method moves the directory from the root to the specific Directory.
 * @param The input given into JShell. 
 * @param The current directory object.
 * @param The current directory according to JShell.
 * @param The initial tree
 */
public void moveFromRoot(String A, String CurrentDirectory,
		ChangeDirectory currentDirectory, Tree initial){
	// This if statement checks if the first element is a /, meaning the root.
  if(A.equals("/")){
		currentDirectory.setCurrentDirectory(A);
	}
	String [] path = A.substring(1).split("/+");
	boolean temp = false;
	List<Object> root = new ArrayList<Object>();
	root = initial.getChildren();
	Tree next = null;

	for(int i = 0; i<root.size(); i++){
		if(root.get(i) instanceof Tree){
			if(((Tree) root.get(i)).getRootName().equals(path[0])){
				temp = true;
				next = (Tree) root.get(i);
			}
		}
	}
	if(temp){
		for(int i = 1; i<(path.length); i++){
			temp = false;
			List<Object> trees = next.getChildren();
			for(int k = 0; k<trees.size();k++){
				if(trees.get(k) instanceof Tree){
					if(((Tree) trees.get(k)).getRootName().
							equals(path[i])){
						temp = true;
						next = (Tree) trees.get(k);
					}
				}
			}
		}
	}
	if(temp){
		currentDirectory.setCurrentDirectory(A);
		currentDirectory.setCurrentDirectoryTree(next);
		System.out.println();
	}
	else{
		System.out.println("Invalid Input");
	}

}

/**
  * This method moves the directory from a relative directory to the specific
  * directory.
 * @param The input given into JShell. 
 * @param The current directory object.
 * @param The current directory according to JShell.
 * @param The initial tree
 */

public void moveFromRelative(String A, String CurrentDirectory,
		ChangeDirectory currentDirectory, Tree initial){
	String [] path = CurrentDirectory.substring(1).split("/+");
	String [] pathRelative = A.split("/+");
	boolean temp = false;
	List<Object> root = initial.getChildren();
	Tree next = null;
	// This if statement checks if the first element is /, meaning the root.
	if(CurrentDirectory.equals("/")){
		for(int i=0; i<root.size();i++){
			if(root.get(i) instanceof Tree){
				if(((Tree) root.get(i)).getRootName().equals(pathRelative[0])){
					temp = true;
					next = (Tree) root.get(i);
				}
			}
			if(pathRelative.length>1){
				for(int j = 0; j<(pathRelative.length); j++){
					temp = false;
					List<Object> trees = next.getChildren();
					for(int k = 0; k<trees.size();k++){
						if(trees.get(k) instanceof Tree){
							if(((Tree) trees.get(k)).getRootName().
									equals(pathRelative[j])){
								temp = true;
								next = (Tree) trees.get(k);
							}
						}
					}
				}
			}
		}
		if(temp){
			currentDirectory.setCurrentDirectory(CurrentDirectory + A);
			currentDirectory.setCurrentDirectoryTree(next);
			System.out.println();
		}
	}
	else {

		for(int i = 0; i<root.size(); i++){
			if(root.get(i) instanceof Tree){
				if(((Tree) root.get(i)).getRootName().equals(path[0])){
					temp = true;
					next = (Tree) root.get(i);
				}
			}
		}
		if(temp){
			for(int i = 1; i<(path.length); i++){
				temp = false;
				List<Object> trees = next.getChildren();
				for(int k = 0; k<trees.size();k++){
					if(trees.get(k) instanceof Tree){
						if(((Tree) trees.get(k)).getRootName().
								equals(path[i])){
							temp = true;
							next = (Tree) trees.get(k);
						}
					}
				}
			}
		}
		if(temp){
			for(int i = 0; i<(pathRelative.length); i++){
				temp = false;
				List<Object> trees = next.getChildren();
				for(int k = 0; k<trees.size();k++){
					if(trees.get(k) instanceof Tree){
						if(((Tree) trees.get(k)).getRootName().
								equals(pathRelative[i])){
							temp = true;
							next = (Tree) trees.get(k);
						}
					}
				}
			}
		}
		if(temp){
			currentDirectory.setCurrentDirectory(CurrentDirectory +"/"+ A);
			currentDirectory.setCurrentDirectoryTree(next);
			System.out.println();
		}
		else{
			System.out.println("Invalid Input");
		}
	}

}

/**
 * This method goes back up a directory.
 * @param The input given into JShell. 
 * @param The current directory object.
 * @param The current directory according to JShell.
 * @param The initial tree
 */
public void moveUP(String A, String CurrentDirectory,
		ChangeDirectory currentDirectory, Tree initial){
	Tree next = null;
	String s = currentDirectory.getCurrentDirectory();
	String[] cd = s.substring(1).split("/+");
	if (currentDirectory.getCurrentDirectory() != "/"){
		boolean temp = false;
		List<Object> root = new ArrayList<Object>();
		root = initial.getChildren();
		
		for(int i = 0; i<root.size(); i++){
			if(root.get(i) instanceof Tree){
				if(((Tree) root.get(i)).getRootName().equals(cd[0])){
					temp = true;
					next = (Tree) root.get(i);
				}
			}
		}
		if(temp){
			for(int i = 1; i<(cd.length); i++){
				temp = false;
				List<Object> trees = next.getChildren();
				for(int k = 0; k<trees.size();k++){
					if(trees.get(k) instanceof Tree){
						if(((Tree) trees.get(k)).getRootName().
								equals(cd[i])){
							temp = true;
							next = (Tree) trees.get(k);
						}
					}
				}
			}
		}
		String currentD = "";
		if(cd.length > 1){
			for (int i = 0; i<cd.length-1;i++){
				currentD = currentD + "/" + cd[i];
				currentDirectory.setCurrentDirectoryTree(next.getParentTree());
			}
		}
		else if(cd.length == 1){
			for (int i = 0; i<cd.length; i++){
				currentD = currentD + "/";
				currentDirectory.setCurrentDirectoryTree(initial);
			}
		}
		currentDirectory.setCurrentDirectory(currentD);
		currentDirectory.setCurrentDirectoryTree(next.getParentTree());
		System.out.println();
	}
	else{
		System.out.println("Invalid input");
	}


}
    
    public static void main(String[] args){// delete this later
    	Tree x = new Tree("ROOTFOLDER");
    	Tree y = new Tree("y");
    	x.addChild(y);
    	ChangeDirectory currentDirectory = new ChangeDirectory(x);
    	String A = y.getRootName();
    	currentDirectory.CheckString(A, currentDirectory.getCurrentDirectory(), currentDirectory, x);
    	System.out.println(currentDirectory.getCurrentDirectory());
    	System.out.println(currentDirectory.getCurrentDirectoryTree());
    	Tree z = new Tree("z");
    	y.addChild(z);
    	String B = "z";
    	currentDirectory.CheckString(B, currentDirectory.getCurrentDirectory(), currentDirectory, x);
    	System.out.println(currentDirectory.getCurrentDirectory());
    	System.out.println(currentDirectory.getCurrentDirectoryTree());
    	currentDirectory.CheckString("..", currentDirectory.getCurrentDirectory(), currentDirectory, x);
    	System.out.println(currentDirectory.getCurrentDirectory());
    	System.out.println(currentDirectory.getCurrentDirectoryTree());
    	currentDirectory.CheckString("..", currentDirectory.getCurrentDirectory(), currentDirectory, x);
    	System.out.println(currentDirectory.getCurrentDirectory());
    	System.out.println(currentDirectory.getCurrentDirectoryTree());
    	currentDirectory.CheckString("/y/z", currentDirectory.getCurrentDirectory(), currentDirectory, x);
    	System.out.println(currentDirectory.getCurrentDirectory());
    	System.out.println(currentDirectory.getCurrentDirectoryTree());
    	
    }
    
    
    
    
  
  
  
  
}
