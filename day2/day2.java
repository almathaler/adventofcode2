import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class day2{
  public static void main(String[] args){
    //just print out what our other function gets
    try{
      System.out.println(checksum("input2.txt"));
    }catch (FileNotFoundException e){
      System.out.println(e);
    }
  }
  public static int checksum(String filename) throws FileNotFoundException{
    int twos = 0;
    int threes = 0;
    File f = new File(filename);
    Scanner boxIDs = new Scanner(f);
    while (boxIDs.hasNext()){
      String ID = boxIDs.nextLine().trim();
      twos += checkTwo(ID);
      threes += checkThree(ID);
    }
    boxIDs.close();
    //System.out.println("twos: " + twos + ", threes: " + threes);
    return twos*threes;
  }
  public static int checkTwo(String ID){
    //if there is a 2, give 1. if no, give 0
    int[] chars = new int[26];
    for (int k = 0; k<26; k++){
      chars[k] = 0;
    }
    for (int i = 0; i<ID.length(); i++){
      int letterIndex = ID.charAt(i) - 97;
      //System.out.println("letterIndex of " + ID.charAt(i) + ": " + letterIndex);
      chars[letterIndex] = chars[letterIndex] + 1;
    }
    for (int num : chars){
      if (num == 2){
        return 1;
      }
    }
    return 0;
  }
  public static int checkThree(String ID){
    //if there is a 3, give 1. if no, give 0
    int[] chars = new int[26];
    for (int k = 0; k<26; k++){
      chars[k] = 0;
    }
    for (int i = 0; i<ID.length(); i++){
      int letterIndex = ID.charAt(i) - 97;
      //System.out.println("letterIndex of " + ID.charAt(i) + ": " + letterIndex);
      chars[letterIndex] = chars[letterIndex] + 1;
    }
    for (int num : chars){
      if (num == 3){
        return 1;
      }
    }
    return 0;
  }
}
