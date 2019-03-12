package container;


public class SorterC{
    public static void main(String[] args){
       //int sortThis = 87120356;
       int sortThis = 28491046;
       //int sortThis = 1801938563;
       System.out.println("Sorting the following number: " + sortThis);
       SorterC merge = new SorterC();
       //String data = String.valueOf(sortThis);
       merge.init(sortThis);
    }
    
    public void display(char[] input)
    {
       System.out.print("Current value of array: {");
       for(int i = 0; i < input.length; i++)
       {
          System.out.print(input[i]);
       }//iterate through the array and print
       System.out.println("}~>");
    }//This function will be used to display
    //The full contents of the input character
    //array.
    
    public void init(int input)
    {
      System.out.println("Initializing...");
      
      int size = 1;
      boolean done = false;
      String inputData = String.valueOf(input);
      
      while(!done)
      {	
      		size = size * 2;
        	
      		if(size >= inputData.length())
        {
        		done = true;
        }
      }
      
      //int setSize = size / 4;
      
      System.out.println("Size of work variable: " + size + ".");
      
      char[] data = inputData.toCharArray();
      char[] newData = new char[size];
      char[] finalData = new char[size];
      
      for(int i = 0; i < newData.length; i++)
      {
      		newData[i] = '*';
        	finalData[i] = '*';
      }
      
      for(int j = 0; j < data.length; j++)
      {
      		newData[j] = data[j];
      }
      
      display(newData);
      
      String output = String.valueOf(newData);
      
      sort(output, finalData, 0, 1, 1, size, false, false, '*', 1);
      
    }//End of init function
    
    public void sort(String input, char[] newData, int spotA, int spotB, int level, int reset, boolean two, boolean resort, char holderA, int set)
    {
       if(level == reset)
       {
          return;
       }
       
       char[] data = input.toCharArray();
       
       System.out.println("Sorting at level: " + level);
       display(data);
       
       if(level == 1)
       {
          int repeat = 1;
            
          if(data.length > 2)
          {
             repeat = 2;
          }//just to make sure we are not
          //overstepping our variable size
         
          for(int i = 0; i < repeat; i++)
          {
             char A = data[spotA];
             System.out.println("A = : " + A);
             char B = data[spotB];
             System.out.println("B = : " + B);
            
             if(A == '*' || B == '*')
             {
                if(A == '*' && B == '*')
                {
                   break;
                }//Both are empty
               
                else if(A == '*' && B != '*')
                {
                   data[spotA] = B;
                }//A is empty
               
                else if(B == '*' && A != '*')
                {
                   data[spotA] = A;
                }//B is empty
               
               
             }//Asterisk check code
            
             else if(Character.getNumericValue(B) < Character.getNumericValue(A))
             {
                char x = data[spotA];
                data[spotA] = data[spotB];
                data[spotB] = x;
               
             }//This if checks to see if B is less than A 
            
             spotA = spotA + 2;
             spotB = spotB + 2;
            
          }//This for loop will step through
          //four numbers in the array and 
          //partially sort them
         
          level = 2;
         
          //Base spot values off the current set value
          if(set == 1)
          {
             spotA = 0;
             spotB = 2;
          }//On set 1
         
          else
          {
             spotA = (set * 4) - 4;
             spotB = (set * 4) - 2;
             System.out.println("Setting up position variables");
             System.out.println("spotA = : " + spotA);
             System.out.println("spotB = : " + spotB);
          }//Not on set 1
          //spotA = ?;
          //spotB = ?;
         
          System.out.println("Level 1 partial sort complete.");
          System.out.println("Current value of data:");
          display(data);
          System.out.println("Current value of newData:");
          display(newData);
          
       }//This if deals with the first
       //Level.
       
       else
       {
          System.out.println("We made it to the else.");
          System.out.println("spotA = : " + spotA);
          System.out.println("spotB = : " + spotB);
         
          boolean done = false;
         
          int spot = spotA;
          int counterA = 0;
          int counterB = 0;
         
          while(done == false)
          {
             char A = data[spotA];
             System.out.println("A = : " + A);
             System.out.println("spotA = : " + spotA);
             System.out.println("spot = : " + spot);
             if(spotB >= data.length)
             {
                spotB = data.length - 1;
             }
             char B = data[spotB];
             System.out.println("B = : " + B);
             System.out.println("spotB = : " + spotB);
            
             /*if(holderA != '*')
             {
                A = holderA;
             }*/
            
             if(B == '*')
             {
                if(B == '*' && A != '*')
                {
                   if(counterB == level && counterA != level)
                   {
                      newData[spot] = A;
                      counterA++;
                      spotA++;
                      spot++;
                   }
                  
                   else
                   {
                      newData[spot] = A;
                      level = reset;
                      done = true;
                   }
                }//B is an asterisk but we still have a value
                //for a. We take that and then we are done.
               
             }//This is to check if we have hit
             //an empty value location
            
             else if(counterA == level || counterB == level)
             {
                if(counterA == level && counterB == level)
                {
                   done = true;
                   System.out.println("All values exhausted");
                }//All values exhuasted
               
                else if(counterA == level)
                {
                   for(int a = counterB; a < level; a++)
                   {
                      newData[spot] = B;
                      spotB++;
                      spot++;
                      if(spotB == data.length)
                      {
                         B = data[spotB - 1];
                      }
                     
                      else
                      {
                         B = data[spotB];
                      }
                   }
                  
                   done = true;
                   System.out.println("A values exhausted");
                }//A values exhausted
               
                else if(counterB == level)
                {
                   for(int b = counterA; b < level; b++)
                   {
                      /*if(holderA != '*')
                      {
                         data[spot] = holderA;
                         holderA = '*';
                      }*/
                     
                     //else
                      //{ 
                         newData[spot] = A;
                      //}
                      spotA++;
                      spot++;
                      A = data[spotA];
                   }
                  
                   done = true;
                   System.out.println("B values exhuasted");
                }//B values exhausted
               
             }//Either some or all of the values got exhausted
            
             else if(Character.getNumericValue(A) < Character.getNumericValue(B) || Character.getNumericValue(B) < Character.getNumericValue(A) || Character.getNumericValue(A) == Character.getNumericValue(B))
             {
                if(Character.getNumericValue(A) < Character.getNumericValue(B))
                {
                   /*if(holderA != '*')
                   {
                      A = data[spot];
                      data[spot] = holderA;
                      holderA = A;
                      //holderA = '*';
                   }
                  
                   else
                   {
                      data[spot] = A;
                   }*/
                   newData[spot] = A;
                   counterA++;
                   spotA++;
                   spot++;
                }//A is less than B
               
                else if(Character.getNumericValue(B) < Character.getNumericValue(A))
                {
                   /*if(spotA == spot)
                   {
                         System.out.println("holderA had a value.");
                         holderA = data[spotA];
                         if(level == 2)
                         {
                            data[spotB] = holderA;
                         }
                         else
                         {
                            data[spotB] = '*';
                         }
                         //data[spotB] = '*';
                         spotA++;
                         counterA++;
                         //holderA = '*';
                        
                   }//We don't want to compare the wrong
                   //number in the future.*/
                   
                   newData[spot] = B;
                   counterB++;
                   spotB++;
                   spot++;
                }//B is less than A
               
                else if(Character.getNumericValue(A) == Character.getNumericValue(B))
                {
                   newData[spot] = A;
                   newData[spot + 1] = B;
                   counterA++;
                   counterB++;
                   spotA++;
                   spotB++;
                   spot = spot + 2;
                }//A is equal to B
             }//Here we check the status of A and B
             
             System.out.println("Sorting at level " + level);
             System.out.println("Current value of data:");
             display(data);
             System.out.println("Current value of newData:");
             display(newData);
            
             //done = true;
             //level = reset;
             
          }//I need a while here since
          //the operations performed
          //in this loop may not be redundant
          
          for(int j = (set * 4) - 4; j < (set * 4); j++)
          {
             data[j] = newData[j];
          } 
          System.out.println("New value of data:");
          display(data);  
          
          //System.out.println("Bottom of else");
          level = level * 2;
          //level = reset;
         
       }//THis else deals with every other level
       
       String output = String.valueOf(data);
       
       if(level == reset)
       {
          System.out.println("Sorting complete!");
          System.out.println("Final output: " + String.valueOf(newData));
       }
       
       else if(two == false)
       {
         
          if(level > 2)
          {
             two = true;
             level = 1;
             set++;
             spotA = (set * 4) - 4;
             spotB = (set * 4) - 3;
             System.out.println("Setting back to level 1");
             holderA = '*';
          }
       }
         
       else
       {
          if(level > 2)
          {
             two = false;
             //set++;
             spotA = 0;
             spotB = (set * 4) - level;
             holderA = '*';
             System.out.println("We made it here somehow...");
          }
       }
       
       sort(output, newData, spotA, spotB, level, reset, two, resort, holderA, set);
      	//This is how we make it recursive!!!
       
    }//End of sort function

}//End of class SorterC