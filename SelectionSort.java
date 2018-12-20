package selectionc;

public class Sorter {

  public static void main(String[] args) {
      Sorter Selection = new Sorter();
      String sortThis = "06827534192";
      System.out.println("Input: " + sortThis);
      System.out.println("Output: " + Selection.sort(sortThis));
      
   
  }
  
  public String sort(String input)
  {
    //Setup booleans here
    boolean sorted = false;
    boolean stillWorking = false;
    
    //Setup up placement variables here
    int p = 0;
    int P = 0;
    int PB = 0;
    int PC = 1;
    
    String output = "";
    
    char A = ' ';
    char B = ' ';
    char C = ' ';
    
    char[] data = input.toCharArray();
    
    while(!sorted)
    {
      for(int i = data.length; i > PC; i--)
      {
        P = i - 1;
      
        A = data[P];
        System.out.println("A = " + A);
        B = data[P-1];
        System.out.println("B = " + B);
      
        if(C == ' ')
        {
          if(Character.getNumericValue(B) < Character.getNumericValue(A))
          {
            C = B;
            p = P - 1;
            System.out.println("C = " + C);
          }
      
          else if(Character.getNumericValue(A) < Character.getNumericValue(B))
          {
            C = A;
            p = P;
            System.out.println("C = " + C);
          }
        }
      
        else if(Character.getNumericValue(A) < Character.getNumericValue(C) || Character.getNumericValue(B) < Character.getNumericValue(C))
        {
          if(Character.getNumericValue(A) < Character.getNumericValue(C))
          {
            C = A;
            p = P;
            System.out.println("C = " + C);
          }
        
          else if(Character.getNumericValue(B) < Character.getNumericValue(C))
          {
            C = B;
            p = P - 1;
            System.out.println("C = " + C);
          }
        }
      
        else
        {
          System.out.println("C = " + C);
        }
      System.out.println("i = " + i);
      }//End of smallest number for loop
    
      data[PB] = B;
      data[PB] = data[p];
      data[p] = B;
      PB++;
      PC = PB + 1;
      C = ' ';
    
      for(int j = data.length; j > 1; j--)
      {
        P = j - 1;
      
        A = data[P];
        B = data[P - 1];
      
        if(Character.getNumericValue(B) > Character.getNumericValue(A))
        {
          stillWorking = true;
          System.out.println("Still Working...");
          break;
        }
        
      }//End of sort check for loop
    
      if(stillWorking)
      {
        stillWorking = false;
      }
      
      else
      {
        sorted = true;
        System.out.println("Done!");
      }
      
      if(!sorted)
      {
        System.out.println("Current Output: " + String.valueOf(data));
      }
    }//End of while loop
    
    output = String.valueOf(data);
    return output;
  }//End of sort function
}//End of Sorter class
