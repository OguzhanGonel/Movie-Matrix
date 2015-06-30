package driver;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Displays the contents of a specified file in the shell.
 *
 */
public class Cat {
    /**
     * Constructs a cat object?! WTF is this
     */
	public Cat(){

	}
    /**
     * 
     * @param A The given input at JShell.
     * @param currentDirectory The current working directory
     * @param initial The tree that is initialized when JShell stars.
     */
	public void printFileContents(String A, ChangeDirectory currentDirectory,
			Tree initial){
	  //This if statement checks if the first element is a /, meaning the root.
		if(A.substring(0,1).equals("/")){
			Tree next = initial;
			String[] path = A.substring(1).split("/+");
			boolean temp = false;
			List<Object> root = next.getChildren();
			if(path.length == 1){
				for(int i = 0; i<root.size(); i++){
					if(root.get(i) instanceof Leaf){
						if(((Leaf) root.get(i)).getFileName().equals(path[0])){
							temp = true;
						}
					}
				}
			}
			else{
			for(int i = 0; i<root.size(); i++){
				if(root.get(i) instanceof Tree){
					if(((Tree) root.get(i)).getRootName().equals(path[0])){
						temp = true;
						next = (Tree) root.get(i);
					}
				}
			}
			}
			if(temp){
				if(path.length > 1){
				for(int i = 0; i<(path.length); i++){
					temp = false;
					List<Object> trees = next.getChildren();
					for(int k = 0; k<trees.size();k++){
						if(trees.get(k) instanceof Leaf){
							if(((Leaf) trees.get(k)).getFileName().
									equals(path[i])){
								temp = true;
							}
						}
					}
				}
			}
				else{
					for(int i = 0; i<(path.length); i++){
						temp = false;
						List<Object> trees = next.getChildren();
						for(int k = 0; k<trees.size();k++){
							if(trees.get(k) instanceof Leaf){
								if(((Leaf) trees.get(k)).getFileName().
										equals(path[i])){
									temp = true;

								}
							}
						}
					}
				}
			}
			if(temp){
				String s = "";
				List<Object> trees = next.getChildren();
				temp=false;
				for(int k = 0; k<trees.size();k++){
					if(trees.get(k) instanceof Leaf){
						if(((Leaf) trees.get(k)).getFileName().
								equals(path[path.length-1])){
							temp=true;
							s = ((Leaf) trees.get(k)).getFileName();
						}
					}
				}
				System.out.println(s);
			}
			else{
				System.out.println("Invalid Input");
			}
		}
		else{
			Tree next = currentDirectory.getCurrentDirectoryTree();
			String[] path = A.split("/+");
			boolean temp = false;
			List<Object> root = next.getChildren();
			if(path.length == 1){
				for(int i = 0; i<root.size(); i++){
					if(root.get(i) instanceof Leaf){
						if(((Leaf) root.get(i)).getFileName().equals(path[0])){
							temp = true;
						}
					}
				}
			}
			else{
			for(int i = 0; i<path.length-1; i++){
				if(path[i].equals("..")){
					next = next.getParentTree();
				}
			}
					for(int j = 0; j<root.size(); j++){
						if(root.get(j) instanceof Tree){
							if(((Tree) root.get(j)).getRootName().equals(path[0])){
								temp = true;
								next = (Tree) root.get(j);
							}
						}
					}
			}
					if(temp){
						for(int j = 1; j<(path.length-1); j++){
							temp = false;
							List<Object> trees = next.getChildren();
							for(int k = 0; k<trees.size();k++){
								if(trees.get(k) instanceof Tree){
									if(((Tree) trees.get(k)).getRootName().
											equals(path[j])){
										temp = true;
										next = (Tree) trees.get(k);
									}
								}
							}
						}
					}
					if(temp){
						String s = "";
						List<Object> trees = next.getChildren();
						temp=false;
						for(int k = 0; k<trees.size();k++){
							if(trees.get(k) instanceof Leaf){
								if(((Leaf) trees.get(k)).getFileName().
										equals(path[path.length-1])){
									temp=true;
									s = ((Leaf) trees.get(k)).getFileName();
								}
							}
						}
						System.out.println(s);
					}
					else{
						System.out.println("Invalid Input");
					}
				}
		}
	
	public static void main(String [] args){
		Cat cat = new Cat();
		Tree x = new Tree("x");
		ChangeDirectory currentDirectory = new ChangeDirectory(x);
		Tree y = new Tree("y");
		x.addChild(y);
		Leaf a = new Leaf(y, "a", "abcd");
		Leaf b = new Leaf(y,"b","abcd");
		Tree z = new Tree("z");
		y.addChild(z);
		z.addLeaf(a);
		y.addLeaf(a);
		y.addLeaf(b);
		x.addLeaf(b);
		cat.printFileContents("b", currentDirectory, x);
	}

}

