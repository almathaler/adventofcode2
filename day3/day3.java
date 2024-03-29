import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class day3{
  public static void main(String[] args){
    try{
      System.out.println(getOverlap("input3.txt"));
    }catch(FileNotFoundException e){
      System.out.println(e);
    }
  }
  public static String getOverlap(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner inputs = new Scanner(f);
    int[][] grid = new int[1000][1000]; //all spaces are -1. if first, make 1. if 2nd, make 2. add everything up and / by 2
    for (int a = 0; a<1000; a++){
      for (int b = 0; b<1000; b++){
        grid[a][b]=-1;
      }
    }
    while (inputs.hasNext()){
      String claim = inputs.nextLine().trim(); //(393,863: 11x29)
      claim = claim.substring(claim.indexOf('@') + 2);
      claim = claim.replace(": ", ",");
      claim = claim.replace("x", ","); //(393,863,11,29)
      String[] instructions = claim.split(","); // {393, 863, 11, 29}
      int startF = Integer.parseInt(instructions[1]); //bc the first num is space from left, so that's index in 2nd array
      int startS = Integer.parseInt(instructions[0]);
      int width = Integer.parseInt(instructions[2]);
      int height = Integer.parseInt(instructions[3]);
      for (int i = 0; i<height; i++){
        for (int j = 0; j<width; j++){
          //if spot = -1, make 1. if spot = 1, make 2. else nothing
          if (grid[startF+i][startS+j] == -1){
            grid[startF+i][startS+j] = 1;
          }else if (grid[startF+i][startS+j] == 1){
            grid[startF+i][startS+j] = 2;
          }
        }
      }
    }
    inputs.close();
    Scanner inputsS = new Scanner(f);
    while (inputsS.hasNext()){
      boolean theOne = true;
      String claim = inputsS.nextLine().trim(); //(393,863: 11x29)
      String toReturn = claim;
      claim = claim.substring(claim.indexOf('@') + 2);
      claim = claim.replace(": ", ",");
      claim = claim.replace("x", ","); //(393,863,11,29)
      String[] instructions = claim.split(","); // {393, 863, 11, 29}
      int startF = Integer.parseInt(instructions[1]); //bc the first num is space from left, so that's index in 2nd array
      int startS = Integer.parseInt(instructions[0]);
      int width = Integer.parseInt(instructions[2]);
      int height = Integer.parseInt(instructions[3]);
      for (int i = 0; i<height; i++){
        for (int j = 0; j<width; j++){
          if (grid[startF+i][startS+j] != 1){
            theOne = false;
            j = width;
            i = height;
            //System.out.println(toReturn + ", NO");
          }
        }
      }
      if (theOne){
        return toReturn;
      }
    }
    return "none";

  }
}
