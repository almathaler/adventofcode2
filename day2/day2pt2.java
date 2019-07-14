import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class day2pt2{
  public static void main(String[] args){
    //just print out what our other function gets
    try{
      System.out.println(sameLetters("input2.txt"));
    }catch (FileNotFoundException e){
      System.out.println(e);
    }
  }
  //n * (250-n) loop
  //look at everything ahead, and do booleans check1 and check2
  //while scanning thru the 2 strings, if there is one diff check1. if there is 2 check2 and break
  //but if there's only 1 diff, stop everything and u found it!
  public static String sameLetters(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner IDs = new Scanner(f);
    String same1 = "";
    String same2 = "";
    //make array of ids
    String[] ids = new String[250];
    int i = 0;
    while (IDs.hasNext()){
      ids[i] = IDs.nextLine().trim();
      i++;
    }
    //now do the giant loop
    for (int k = 0; k<ids.length; k++){
      for (int j = k+1; j<ids.length; j++){
        boolean check1 = false;
        boolean check2 = false;
        for (int l = 0; l<26; l++){
          if (ids[k].charAt(l) != ids[j].charAt(l)){
            if (check1){
              check2 = true;
              l = 27; //break this loop; not the right word
            }else{
              check1 = true; //show that there is one diff already
            }
          }
        }
        if (check1 && !check2){//that means there is only difference, so break the entire loop we found the match
          //set some string1 to ids[k] && string2 to ids[l]
          same1 = ids[k];
          same2 = ids[j];
          j = ids.length;
          k = ids.length; //two breaks
        }
      }
    }
    String toReturn = "";
    for (int z = 0; z<same1.length(); z++){
      if (same1.charAt(z) == same2.charAt(z)){
        toReturn+=same1.charAt(z);
      }
    }
    return toReturn;
  }
}
