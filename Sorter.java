package bubble;

public class Sorter {

  public static void main(String[] args) {
       Sorter BubbleSort = new Sorter();
       String sortThis = "14235965087";
       System.out.println("Input: " + sortThis);
       System.out.println("Sorted Output: " + BubbleSort.sort(sortThis));
       
  }
  
  public String sort(String input)
  {
    boolean sorted = false;
    
    boolean switchMade = false;
      
    char[] currentInput = input.toCharArray();
    
    String output = "";
    
    int pass = 0;
    
    do
    {
      pass++;  
      
      for(int i = (currentInput.length - 1); i > 0; i--)
      {
           System.out.println("in for loop");
           int A = i;
           int B = i - 1;
           
           char a = currentInput[A];
           System.out.println("a =: " + a);
           char b = currentInput[B];
           System.out.println("b =: " + b);
           
           if (Character.getNumericValue(b) > Character.getNumericValue(a))
           {
             currentInput[B] = a;
             currentInput[A] = b;
             
             switchMade = true;
           }
           
           if(i == 1 && !switchMade)
           {
             sorted = true;
             i = 0;
           }
           
           else if (i == 1)
           {
             switchMade = false;
             i = 0;
           }
           
           if(!sorted)
           {
             System.out.println("Still Working...");
           }
           
           else
           {
             System.out.println("Finished!");
           }
      }
      System.out.println("Current Output: " + String.valueOf(currentInput));
      System.out.println("Pass Number: " + pass);
    }
    while(!sorted);
    
    output = String.valueOf(currentInput);
    
    return output; 
  }
}
