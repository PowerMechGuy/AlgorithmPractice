package insertion;

public class Sorter {

  public static void main(String[] args) {
       Sorter Insertion = new Sorter();
       String sortThis = "27182395604";
       System.out.println("Input: " + sortThis);
       System.out.println("Output: " + Insertion.sort(sortThis));
  }
  
  public String sort(String input)
  {
    //control flow booleans
    boolean sorted = false;
    boolean done = false;
    
    //postion variables
    int PA = 0;
    int PB = 0;
    int PC = 0;
    
    //pass counter
    int pass = 0;
    
    //char array made from input string
    char[] data = input.toCharArray();
    
    //character comparison variables
    char A = ' ';
    char B = ' ';
    char C = ' ';
    
    //output to be returned
    String output = "";
    
    //main while loop
    while(!sorted)
    {
      pass++;
      
      PC++;
      
      System.out.println("The leftmost digit is: " + data[0]);
      System.out.println("The next digit to compare is: " + data[PC]);
    
      A = data[PC - 1];
      B = data[PC];
    
      if(PC == 1)
      {
        if(Character.getNumericValue(B) < Character.getNumericValue(A))
        {
          C = data[PC - 1];
          data[PC - 1] = B;
          data[PC] = A;
          System.out.println("Current Output: " + String.valueOf(data));
        }
      }
      
      else
      {
        done = false;
        
        PB = PC;
        System.out.println("PC = " + PC);
        System.out.println("PB = " + PB);
        
        while(!done)
        {
          if(PB == 0)
          {
            done = true;
            break;
          }
        
          PA = PB - 1;
        
          A = data[PA];
          B = data[PB];
          
          if(Character.getNumericValue(B) < Character.getNumericValue(A))
          {
            C = data[PA];
            data[PA] = B;
            data[PB] = A;
            System.out.println("Current Output: " + String.valueOf(data));
            System.out.println("Change Made...");
          }//End of if
          
          PB--;
          System.out.println("PB = " + PB);    
        }//End of while
      }//End of else
      
      if(PC == (data.length - 1))
      {
        sorted = true;
      }
      
      System.out.println("Pass " + pass);
    }//End of main while loop

    output = String.valueOf(data);
    return output;
  }//End of sort function
}//End of Sorter class