package driver;

import java.util.ArrayList;
import java.util.List;

/**
 * Prints out the contents of the directory given or if just ls
 * is given, prints out the contents of the current working directory
 * Must be given either:
 * 1. Command ls
 * 2. ls with specific arguments
 *
 */
public class ViewDirectory {
    
    /**
     * 
     */
	public ViewDirectory(){

	}
	/**
	 * the case where ls has no arguments in it
	 * @param The current directory object.
	 * @param The current directory according to JShell.
	 * @param The initial tree.
	 */
	public void printWorkingDirectory(String CurrentDirectory, ChangeDirectory currentDirectory,
			Tree initial){
		String [] path = CurrentDirectory.substring(1).split("/+");
		boolean temp = false;
		List<Object> root = new ArrayList<Object>();
		root = initial.getChildren();
		Tree next = null;
		// This checks if the first element is a /, meaning the root.
		if(CurrentDirectory.equals("/")){
			next = initial;
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
		}
		List<Object> cwd = next.getChildren();
		String toprint = "";
		for(int i = 0; i <cwd.size(); i++){
			if(cwd.get(i) instanceof Tree){
				toprint = toprint +((Tree) cwd.get(i)).getRootName()+ " ";
			}
			else if(cwd.get(i) instanceof Leaf){
				toprint = toprint + ((Leaf) cwd.get(i)).getFileName() + " ";
			}
		}
		System.out.println(toprint);
	}
	/**
	 * @param The input given in JShell.
	 * @param The current directory according to JShell.
     * @param The initial tree. 
	 */
	public void printPathContents(String[] input, ChangeDirectory currentDirectory,
			Tree initial){
		boolean temp = false;
		String toPrint = "";
		for(int i = 1; i<input.length;i++){
			String argument = input[i];
			if(argument.substring(0,1).equals("/")){
				String[]path = argument.substring(1).split("/+");
				List<Object> root = initial.getChildren();
				Tree next = null;

				for(int j = 0; j<root.size(); j++){
					if(root.get(j) instanceof Tree){
						if(((Tree) root.get(j)).getRootName().equals(path[0])){
							temp = true;
							next = (Tree) root.get(j);
						}
					}
				}
				if(temp){
					for(int j = 1; j<(path.length); j++){
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
					List<Object> cwd = next.getChildren();
					String toprinttemp = argument + ":" + "\n";
					for(int j = 0; j <cwd.size(); j++){
						if(cwd.get(j) instanceof Tree){
							toprinttemp = toprinttemp +((Tree) cwd.get(j)).getRootName()+ " ";
						}
						else if(cwd.get(j) instanceof Leaf){
							toprinttemp = toprinttemp + ((Leaf) cwd.get(j)).getFileName() + " ";
						}
					}
					toPrint = toPrint + toprinttemp + "\n";
				}
			}
			else{
				Tree next = currentDirectory.getCurrentDirectoryTree();
				List<Object> cdChildren = next.getChildren();
				String[] path = argument.split("/+");
				for(int j = 0; j<cdChildren.size(); j++){
					if(cdChildren.get(j) instanceof Tree){
						if(((Tree) cdChildren.get(j)).getRootName().equals(path[0])){
							temp = true;
							next = (Tree) cdChildren.get(j);
						}
					}
				}
				if(temp){
					for(int j = 1; j<(path.length); j++){
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
					List<Object> cwd = next.getChildren();
					String toprinttemp = argument + ":" + "\n";
					for(int j = 0; j <cwd.size(); j++){
						if(cwd.get(j) instanceof Tree){
							toprinttemp = toprinttemp +((Tree) cwd.get(j)).getRootName()+ " ";
						}
						else if(cwd.get(j) instanceof Leaf){
							toprinttemp = toprinttemp + ((Leaf) cwd.get(j)).getFileName() + " ";
						}
					}
					toPrint = toPrint + toprinttemp + "\n";
				}
			}
		}
		if(temp){
			System.out.println(toPrint);
		}
		else{
			System.out.println("Invalid Input");
		}
	}
	
	public static void main(String [] args){//delete this after
		ViewDirectory test = new ViewDirectory();
		Tree x = new Tree("x");
		Tree y = new Tree("y");
		x.addChild(y);
		Tree z = new Tree("z");
		y.addChild(z);
		ChangeDirectory currentDirectory = new ChangeDirectory(x);
		String [] input = {"ls","/y"};
		test.printWorkingDirectory(currentDirectory.getCurrentDirectory(), currentDirectory, x);
		test.printPathContents(input, currentDirectory, x);
	}

}
