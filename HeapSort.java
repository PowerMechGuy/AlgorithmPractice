package container;

public class Sorter {

  //GLOBAL VARIABLES
  String heap = "";
  
  int heaplevels = 0;

  public static void main(String[] args) {
    Sorter heap = new Sorter();
    String sortThis = "38210452879675";
    System.out.println("This program will demonstrate heap sorting.");
    System.out.println("This is the current value of the our test variable: " + sortThis);
    System.out.println("Our test variable has (" + sortThis.length() + ") characters.");
    
    heap.generate(sortThis);
    heap.heapfunction("r");
    heap.heapfunction("f");
    heap.heapfunction("s");
    
  }//End of main function
  
  public void generate(String input)
  {
    //This function will first generate
    //a heap string to be used by the
    //sorter. It will increase the string
    //length by powers of two to accomodate
    //the size of the input string.
    
    char[] data = input.toCharArray();
    
    boolean same = false;
    
    int counter = 1;
    int levels = 1;
    
    while(!same)
    {
      if(counter >= data.length)
      {
        same = true;
      }
      
      else
      {
        if(counter == 1)
        {
          counter = 2;
          counter = counter * 2;
          levels++;
        }
        
        else
        {
          counter = counter * 2;
          levels++;
        }
      }
    }//End of while loop
    
    if(counter != data.length)
    {
      counter = counter - 1;
    }
    
    char[] newdata = new char[counter];
    
    for(int i = 0; i < newdata.length; i++)
    {
      newdata[i] = '*';
    }//End of for loop
    
    System.out.println("Heap created and initialized.");
    
    for(int j = 0; j < data.length; j++)
    {
      newdata[j] = data[j];
    }//End of for loop
    
    System.out.println("New data entered into Heap.");
    System.out.println("Heap contents: " + String.valueOf(newdata));
    System.out.println("This heap has " + newdata.length + " characters.");
    System.out.println("This heap has " + levels + " levels.");
    
    heap = String.valueOf(newdata);
    
    heaplevels = levels;    
  }//End of generate function
  
  public void heapfunction(String input)
  {
    if(input == "r")
    {
      regenerate(heap, heaplevels);
    }//End of sorting if
    
    else if(input == "s")
    {
      sort(format(heap));
    }
    
    else if(input == "f")
    {
      System.out.println("Formatted heap: " + format(heap));
    }//End of formatting else if
    
  }//End of sortheap function
  
  public void regenerate(String input, int levels)
  {
    char A = 0;
    char B = 0;
    char C = 0;
    char D = 0;
    
    int spotA = 0;
    int spotB = 0;
    int spotC = 0;
    
    char[] data = input.toCharArray();
    
    String output = "";
    
    for(int j = 0; j < levels; j++)
    {
      int currentlevel = 1;
      int toplevel = 1;
      int bottomlevel = 0;
      
      spotA = 0;
      spotB = 1;
      spotC = 2;
      
      while(currentlevel < levels)
      {
        if(currentlevel == 1)
        {
          A = data[spotA];
          B = data[spotB];
          C = data[spotC];
          
          if(Character.getNumericValue(B) > Character.getNumericValue(A) || Character.getNumericValue(C) > Character.getNumericValue(A))
          {
            if(Character.getNumericValue(B) > Character.getNumericValue(C))
            {
              D = data[spotA];
              data[spotA] = data[spotB];
              data[spotB] = D;
            }//End of if
            
            else if(Character.getNumericValue(C) > Character.getNumericValue(B))
            {
              D = data[spotA];
              data[spotA] = data[spotC];
              data[spotC] = D;
            }//End of else if
          }//End of large if
          
          spotA++;
          
          currentlevel++;
          
        }//End of larger if
        
        else
        {
          System.out.println("Toplevel = : " + toplevel);
          bottomlevel = (toplevel * 2) - 1;
          spotB = bottomlevel;
          spotC = spotB + 1;
          
          for(int i = 0; i < toplevel; i++)
          {
            A = data[spotA];
            B = data[spotB];
            C = data[spotC];
            
            System.out.println("A = : " + A + " And is at spot: " + spotA);
            System.out.println("B = : " + B + " And is at spot: " + spotB);
            System.out.println("C = : " + C + " And is at spot: " + spotC);
            System.out.println("Currently on level " + currentlevel);
            
            if(B == '*' && C == '*')
            {
              currentlevel = levels;
              break;
            }//End of double asterisk check if
            
            else if(B == '*' || C == '*')
            {
              if(B == '*')
              {
                if(Character.getNumericValue(C) > Character.getNumericValue(A))
                {
                  D = data[spotA];
                  data[spotA] = data[spotC];
                  data[spotC] = D;
                }//End of if
              }//End of B check if
              
              else if(C == '*')
              {
                if(Character.getNumericValue(B) > Character.getNumericValue(A))
                {
                  D = data[spotA];
                  data[spotA] = data[spotB];
                  data[spotB] = D;
                }//End of if
              }//End of C check else if
              
              currentlevel = levels;
              break;
            }//End of asterisk check if
            
            else
            {
              if(Character.getNumericValue(B) > Character.getNumericValue(A) || Character.getNumericValue(C) > Character.getNumericValue(A))
              {
                if(Character.getNumericValue(B) > Character.getNumericValue(C))
                {
                  D = data[spotA];
                  data[spotA] = data[spotB];
                  data[spotB] = D;
                }//End of B is less than C check if
                
                else if(Character.getNumericValue(C) > Character.getNumericValue(B))
                {
                  D = data[spotA];
                  data[spotA] = data[spotC];
                  data[spotC] = D;
                }//End of C is less than B check else if
              }//End of character value comparison if
              
              spotA++;
              spotB = spotB + 2;
              spotC = spotC + 2;
              
            }//End of noraml operation else
            
          }//End of for loop
          
          currentlevel++;
          
        }//End of else
        
        toplevel = toplevel * 2;
        
      }//End of main while loop
      
    }//End of main for loop
    
    System.out.println("Heap is now sorted.");
    
    output = String.valueOf(data);
    
    heap = output;
    
    System.out.println("New value of heap: " + heap);
    
  }//End of sort function
  
  public void sort(String input)
  {
    System.out.println("Beginning number sort");
    
    String result = "";
    String transfer = input;
    
    char A = 0;
    
    for(int i = 0; i < input.length(); i++)
    {
      char[] data = transfer.toCharArray();
      
      A = data[0];
      
      result = result + A;
      
      char[] newdata = new char[data.length - 1];
      
      for(int j = 1; j < data.length; j++)
      {
        newdata[j - 1] = data[j];
      }//End of initialization loop
      
      String B = String.valueOf(newdata);
      
      generate(B);
      regenerate(heap, heaplevels);
      transfer = format(heap);
      
    }//End of main for loop
    
    System.out.println("Fully sorted number: " + result);
  }
  
  public String format(String input)
  {
    char A = 0;
    
    int counter = 0;
    
    char[] data = input.toCharArray();
    
    String output = "";
    
    for(int i = 0; i < data.length; i++)
    {
      A = data[i];
      
      if(A == '*')
      {
        break;
      }//End of asterisk chedk if
      
      else
      {
        counter++;
      }//End of normal operation if
    }//End of counting for loop
    
    char[] newdata = new char[counter];
    
    for(int j = 0; j < newdata.length; j++)
    {
      newdata[j] = data[j];
    }//End of initialization for loop
    
    output = String.valueOf(newdata);
    
    //System.out.println("Final Output: " + output);
    
    return output;
    
  }//End of format function
  
}//End of Sorter class
