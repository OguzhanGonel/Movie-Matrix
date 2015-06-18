// **********************************************************
// Assignment0:
// UTOR user_name: gonelogu
// UT Student #: 1000646606
// Author: Oguzhan Ibrahim Gonel
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package a0;

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];

  /**
   * Default Constructor.
   */
  
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
    
  }

  /*
   * TODO:COMPLETE THIS I.E. APPROPRIATELY CREATE THE userMovieMatrix AND
   * userUserMatrix WITH CORRECT DIMENSIONS.
   */
  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers Determines size of matrix variables.
   * @param numberOfMovies Determines size of matrix variables.
   */
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
    userMovieMatrix = new int[numberOfUsers][numberOfMovies];
    userUserMatrix = new float[numberOfUsers][numberOfUsers];

  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) {
   
    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
    
    			
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC. Add/remove
   * 
   * @param AND
   *     
   * @return as required below.
   */
  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void calculateSimilarityScore() {
    
    int values[] = new int[userMovieMatrix.length]; 
    
    int counter = 0;
    for(int i = 0; i < userMovieMatrix.length; i++){
      
      for(int x = 0; x < userMovieMatrix[i].length; x++){
      
        if (i == counter && userMovieMatrix[i] != userMovieMatrix[-1]){
          values[x] = userMovieMatrix[i][x];
        }  
          else if(i != 0){
            values[x] = (int)(Math.pow(values[x] - userMovieMatrix[i][x], 2));
            int total = 0;
                
            for(int zz = 0; zz < values.length; zz++){
              total += values[zz];
              
            }
            total = (int)(Math.sqrt(total));
            total = 1/(1+total);
            userUserMatrix[i][x] = total;
          }
        
      counter += 1;
      }
    }
    
  }
  

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and
   * column representing each/single user and the cell position (i,j)
   * representing the similarity score between user i and user j.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void printUserUserMatrix() {
    for(int i = 0; i < userUserMatrix.length; i++){
      
      for(int z =0; z < userUserMatrix[i].length; z++){
        System.out.print(userUserMatrix[i][z]);
      }
    }
    
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT \\\\\\MAKE THIS FUNCTION STATIC
   */
  /**
   * This function finds the most similar pair of users in the userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */

  public void findMostSimilarPairOfUsers() {
    for(int i = 0; i < userUserMatrix.length; i++){
      float similar1 = 0;
      float similar2 = 0;
      
        for(int z = 0; z < userUserMatrix[i].length; z++){
        
        if(userUserMatrix[i][z] > similar2){
        similar2 = userUserMatrix[i][z] ;
        }
      }
      if (similar1 < similar2 && similar2 != 1){
        similar1 = similar2;
            
      }
    }
  }

  /*
   * TODO:COMPLETE THIS YOU ARE FREE TO CHANGE THE FUNCTION SIGNATURE BUT DO NOT
   * CHANGE THE FUNCTION NAME AND DO NOT MAKE THIS FUNCTION STATIC
   */
  /**
   * This function find s the most dissimilar pair of users in the
   * userUserMatrix.
   * 
   * @param COMPLETE THIS IF NEEDED
   * @param COMPLETE THIS IF NEEDED
   * @return COMPLETE THIS IF NEEDED
   */
  public void findMostDissimilarPairOfUsers() {
    for(int i = 0; i < userUserMatrix.length; i++){
      float dissimilar1 = 1;
      float dissimilar2 = 1;
          
      for(int z = 0; z < userUserMatrix[i].length; z++){
       
        if(userUserMatrix[i][z] < dissimilar1){
          dissimilar1 = userUserMatrix[i][z];
        }
      }
      if (dissimilar1 < dissimilar2 && dissimilar1 != 0){
        dissimilar2 = dissimilar1;
      }
    } 
  }
}
