package container;

public class Sorter{
    public static void main(String[] args){
			Sorter merge = new Sorter();
   		int sortThis = 10293848;
     	merge.sort(sortThis);
    }
    
    public void sort(int input)
    {
    		System.out.println("We made it!");
      
      int size = 0;
      int p = 1;
      int t = 0;
      int tb = 0;
      int pb = 10;
      int c = 0;
      boolean done = false;
      
      while(done == false)
      {
      		int d = input / p;
        System.out.println("d = : " + d);
        
        if(d >= 1)
        {
        		size++;
          System.out.println("size = : " + size);
          p = p * 10;
        }//End of if
        
        else
        {
        		done = true;
          //pb = (p / 10);
          p = p / 10;
          t = input / p;
          pb = (p / 10);
          //p = 10;
          //break;
        }//End of else
        
        //p = p * 10;
      }//End of while loop
      
      System.out.println("The size of the input variable is: " + size);
      
      int[] data = new int[size];
      
      System.out.println("Initializing data array...");
      
      //pb = p;
      
      for(int i = 0; i < size; i++)
      {
      		data[i] = t;
        System.out.println("t currently equals: " + t);
        tb = input / p;
        tb = tb * 10;
        System.out.println("tb = : " + tb);
        c = p / 10;
        p = c;
        System.out.println("pb currently equals: " + pb);
        c = input / pb;
        t = c;
        System.out.println("t = : " + t);
        t = t - tb;
        //c = pb / 10;
        if(pb == 1)
        {
        		pb = 1;
        }
        
        else
        {
        		c = pb / 10;
          pb = c;
        }
        
      }//End of initialization for loop
      
      System.out.println("Value of data array is as follows:");
      
      for(int j = 0; j < size; j++)
      {
      		System.out.println("Value " + j + " equals: " + data[j]);
      }
      
      int resetTotal = 1;
      
      while(resetTotal < data.length)
      {
        resetTotal = resetTotal * 2;
        System.out.println("Reset Total is equal to: " + resetTotal);
        
      }//End of while loop
      
      merge(data, 0, 1, 2, resetTotal, true, false);
      
    }//End of sort function
    
    public void merge(int[] input, int A, int B, int level, int reset, boolean two, boolean resort)
    {
    		if(level == reset)
      {
        return;
      }
       
       
      	if(level == 2 && two == true)
       {
           
      		int total = input.length;
      		total = total / level;
      
      		for(int k = 0; k < total; k++)
      		{
      
      				System.out.println("Value of A = : " + input[A]);
         		System.out.println("Value of B = : " + input[B]);
            
      				if(input[B] < input[A])
      				{
        				int x = input[B];
    			      	input[B] = input[A];
		          	input[A] = x;

      				}//End of main comparison if
        
        		System.out.print("Current value of array: ");
        		for(int l = 0; l < input.length; l++)
        		{
        				System.out.print(input[l]);
        		}
        		System.out.println(".");
        
        		A = A + level;
        		B = B + level;
      		}//End of level repeat for loop
      }//End of level 2 operation if
      
      else if(level == 2 && two == false)
      {
      		int total = input.length;
        	total = total / level;
         
         for(int p = 0; p < (total / 2); p++)
         {	
         	System.out.print("Current value of array: ");
           for(int o = 0; o < input.length; o++)
           {
             System.out.print(input[o]);
           }//End of display for loop
           System.out.println(".");
         
         	//A = total;
          	//B = total + 2;
           
           int spot = 0;
           
           if(p == 0)
           {
   					A = 0;
        			B = level;
           		spot = 0;             
           }//End p == 0 if
           
           else
           {
           		A = total;
             B = total + 2;
             spot = total;
           }
  
           boolean done = false;
         	int counterA = 0;
         	int counterB = 0;
         
          	//int spot = 0;
           int holderA = 0;
           int holderB = 0;
         
         	while(done == false)
         	{
         		System.out.println("It's working.");
           		//System.out.println("Counter A = : " + counterA);
             	//System.out.println("Counter B = : " + counterB);
          		//done = true;
            
            	if(counterA == 2 && counterB == 2)
             	{
               done = true;
               System.out.println("Value of A = : " + input[A]);
               System.out.println("Value of B = : " + input[B]);
               
               if(input[B] < holderA)
               {
                 input[spot] = input[B];
                 input[spot + 1] = holderA;
               }//End B was less than A if
               
               else if(input[A] < holderB)
               {
                 input[spot] = input[A];
                 input[spot + 1] = holderB;
               }//End A was less than B else if
               
               System.out.print("Current value of array: ");
             		for(int o = 0; o < input.length; o++)
             		{
               		System.out.print(input[o]);
             		}//End of display for loop
             		System.out.println(".");
             }//End final operation if
             
             else if((counterA == 2 && counterB == 0) || (counterB == 2 && counterA ==0))
             {
             		//done = true;
             		System.out.println("We made it.");
               	
               	
               if(counterA == 2)
               {
               		System.out.println("A values exhausted");
                 	done = true;
               	
               		holderA = input[B];
                 	holderB = input[B + 1];
                  
                  if(holderA < holderB)
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is less than holderB
                  
                  else if(holderB < holderA)
                  {
                  	input[spot] = holderB;
                   	input[spot + 1] = holderA;
                  }//End holderB is less than holderA
                  
                  else
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is equal to holderB
                  
                  //break;
                  
                  System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
               }//End A values exhausted if
               
               else if(counterB == 2)
               {
               		System.out.println("B values exhausted.");
                 	done = true;
               
               		holderA = input[A];
                 	holderB = input[A + 1];
                  
                  if(holderA < holderB)
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is less than holderB
                  
                  else if(holderB < holderA)
                  {
                  	input[spot] = holderB;
                   	input[spot + 1] = holderA;
                  }//End holderB is less than holderA
                  
                  else
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is equal to holderB
                  
                  //break;
                  
                  System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
               }//End B values exhausted else if
             }//End A or B value exhaustion check
             
             else if(counterA != 0 || counterB != 0)
             {
             
             		if(holderA != 0)
               {
               
             
             			if(input[B] < holderA || holderA < input[B])
               		{	
               			System.out.println("Value of A = : " + input[A]);
               			System.out.println("Value of B = : " + input[B]);
               
             				if(input[B] < holderA)
               			{
               				counterB++;
                 			holderA = input[A];
                 			//int x = input[spot];
                 			input[spot] = input[B];
                 			spot++;
                	   	B++;
               			}
               
               			else if(input[A] < input[B])
               			{
                 			counterA++;
                 			//holderB = input[B];
                 			//int x = input[spot];
                 			input[spot] = input[A];
                 			spot++;
                   		A++;
               			}
                  }//End of main comparison if
                  
                  else
             			{
             				System.out.println("Value of A = : " + holderA);
               			System.out.println("Value of B = : " + input[B]);
                  	System.out.println("There were equals.");
                  
                  	if(spot == input.length)
                   	{
                   		spot = spot - 2;
                   	}//End spot reset if
             
            			 	input[spot] = holderA;
               			input[spot + 1] = input[B];
                		counterA++;
                		counterB++;
                  	if(counterA >= 2 && counterB >= 2)
                   	{
                   		done = true;
                   	}//End doneness check if
                		A++;
                		B++;
                		spot = spot + 2;
                
               			/*System.out.print("Current value of array: ");
             				for(int o = 0; o < input.length; o++)
             				{
               				System.out.print(input[o]);
             				}//End of display for loop
             				System.out.println(".");*/
             			}//End of both are equal else
                 
                 	System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
                	
                
               }//End holderA check if
                
               else
               {
                  if(input[B] < holderA || holderA < input[B])
               		{	
               			System.out.println("Value of A = : " + holderA);
               			System.out.println("Value of B = : " + input[B]);
                  	//System.out.println("There were equals.");
               
             				if(input[B] < input[A])
               			{
               				counterB++;
                 			holderA = input[A];
                 			//int x = input[spot];
                 			input[spot] = input[B];
                 			spot++;
                	   	B++;
               			}
               
               			else if(input[A] < input[B])
               			{
                 			counterA++;
                 			//holderB = input[B];
                 			//int x = input[spot];
                 			input[spot] = input[A];
                 			spot++;
                   		A++;
               			}
                  }//End of main comparison if
                  
                  else
             			{
             				System.out.println("Value of A = : " + input[A]);
               			System.out.println("Value of B = : " + input[B]);
                  	System.out.println("There were equals.");
                  
                  	if(spot == input.length)
                   	{
                   		spot = spot - 2;
                   	}
            
           			 		input[spot] = holderA;
             				input[spot + 1] = input[B];
               			counterA++;
               			counterB++;
                  	if(counterA >= 2 && counterB >= 2)
                   	{
                   		done = true;
                   	}//End doneness check if
               			A++;
               			B++;
               			spot = spot + 2;
                
               			/*System.out.print("Current value of array: ");
           					for(int o = 0; o < input.length; o++)
             				{
               				System.out.print(input[o]);
             				}//End of display for loop
             				System.out.println(".");*/
             			}//End of both are equal else
                 
                 	System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
                }//End holderA empty else
                //done = true;
                System.out.println("Testing stop");
                
                System.out.println("Counter A = : " + counterA);
                System.out.println("Counter B = : " + counterB);
                System.out.println("Spot = : " + spot);
                System.out.println("HolderA = : " + holderA);
                System.out.println("HolderB = : " + holderB);
             }//End counterA and B check else
             
             else if(input[B] < input[A] || input[A] < input[B])
             {
             		System.out.println("Value of A = : " + input[A]);
               	System.out.println("Value of B = : " + input[B]);
             		
             		if(input[B] < input[A])
               {
               		counterB++;
                 holderA = input[A];
                 //int x = input[spot];
                 input[spot] = input[B];
                 spot++;
                 B++;
               }
               
               else if(input[A] < input[B])
               {
                 counterA++;
                 //holderB = input[B];
                 //int x = input[spot];
                 input[spot] = input[A];
                 spot++;
                 A++;
               }
               
               System.out.print("Current value of array: ");
             		for(int o = 0; o < input.length; o++)
             		{
               		System.out.print(input[o]);
             		}//End of display for loop
             		System.out.println(".");
               
               	//done = true;
                //System.out.println("Testing stop");
                //System.out.println("HolderA = : " + holderA);
                //System.out.println("HolderB = : " + holderB);
             }//End main comparison else if
             
             //A++;
             //B++;
           
           		System.out.println("Restarting while loop...");
             	//System.out.println("Counter A = : " + counterA);
             	//System.out.println("Counter B = : " + counterB);
           
         	}//End main operation while loop
         }//End total two for loop
         	
          	
                    
      }//End second level two else if
      
      else //ANy level over 2
      {
      		System.out.print("Current value of array: ");
         for(int o = 0; o < input.length; o++)
         {
        		System.out.print(input[o]);
         }//End of display for loop
         System.out.println(".");
      	
      		int total = input.length;
        	total = total / level;
         
         int spot = 0;
         boolean done = false;
        	int counterA = 0;
        	int counterB = 0;
         
         //int spot = 0;
  	 	    	int holderA = 0;
         int holderB = 0;
         
         for(int m = 0; m < (total / 2); m++)
         {
           if(m == 0)
           {
           		//System.out.println("Something happened");
             A = 0;
             B = level;
             spot = 0;
           }//End of m == 0 if
           
           else
           {
           		System.out.println("Something happened.");
           		A = level;
             	B = level + 4;
             	spot = level;
           }//End m != 0 else
           
           while(done == false)
         	{
         		System.out.println("It's working.");
           		//System.out.println("Counter A = : " + counterA);
             	//System.out.println("Counter B = : " + counterB);
              System.out.println("A = : " + A);
              System.out.println("B = : " + B);
          		//done = true;
            
            	if(counterA == level && counterB == level)
             	{
               done = true;
               System.out.println("Value of A = : " + input[A]);
               System.out.println("Value of B = : " + input[B]);
               
               if(input[B] < holderA)
               {
                 input[spot] = input[B];
                 input[spot + 1] = holderA;
               }//End B was less than A if
               
               else if(input[A] < holderB)
               {
                 input[spot] = input[A];
                 input[spot + 1] = holderB;
               }//End A was less than B else if
               
               System.out.print("Current value of array: ");
             		for(int o = 0; o < input.length; o++)
             		{
               		System.out.print(input[o]);
             		}//End of display for loop
             		System.out.println(".");
             }//End final operation if
             
             else if((counterA == level && counterB < level) || (counterB == level && counterA < level))
             {
             		//done = true;
             		System.out.println("We made it.");
               	
               	
               if(counterA == level)
               {
               		System.out.println("A values exhausted");
                 	done = true;
               	
               		//holderA = input[B];
                 	holderB = input[B];
                  
                  if(spot == input.length || spot == (input.length - 1))
                  {
                  	spot = spot - 1;
                  }//End spot size check if
                  
                  if(holderA < holderB)
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is less than holderB
                  
                  else if(holderB < holderA)
                  {
                  	input[spot] = holderB;
                   	input[spot + 1] = holderA;
                  }//End holderB is less than holderA
                  
                  else
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is equal to holderB
                  
                  //break;
                  
                  System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
               }//End A values exhausted if
               
               else if(counterB == level)
               {
               		System.out.println("B values exhausted.");
                 	done = true;
               
               		//holderA = input[A];
                 	holderB = input[B];
                  
                  if(spot == input.length || spot == (input.length - 1))
                  {
                  	spot = spot - 1;
                  }//End spot size check if
                  
                  if(holderA < holderB)
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is less than holderB
                  
                  else if(holderB < holderA)
                  {
                  	input[spot] = holderB;
                   	input[spot + 1] = holderA;
                  }//End holderB is less than holderA
                  
                  else
                  {
                  	input[spot] = holderA;
                   	input[spot + 1] = holderB;
                  }//End holderA is equal to holderB
                  
                  //break;
                  
                  System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
               }//End B values exhausted else if
             }//End A or B value exhaustion check
             
             else if(counterA != 0 || counterB != 0)
             {
             
             		if(holderA != 0)
               {
               
             
             			if(input[B] < holderA || holderA < input[B])
               		{	
               			System.out.println("Value of A = : " + holderA);
               			System.out.println("Value of B = : " + input[B]);
                  	System.out.println("Holder A had a value.");
               
             				if(input[B] < holderA)
               			{
               				counterB++;
                 			//holderA = input[A];
                 			//int x = input[spot];
                    	if(spot == input.length)
                     	{
                     		spot = spot - 0;
                     	}//End spot size check if
                 			input[spot] = input[B];
                 			spot++;
                	   	//B++;
                     	if(B != (input.length - 1))
                      {
                      		B++;
                      }//End of B size check if
               			}
               
               			else if(input[A] < input[B])
               			{
                 			counterA++;
                 			//holderB = input[B];
                 			//int x = input[spot];
                 			input[spot] = holderA;
                 			spot++;
                   		A++;
               			}
                  }//End of main comparison if
                  
                  else
             			{
             				System.out.println("Value of A = : " + holderA);
               			System.out.println("Value of B = : " + input[B]);
                  	System.out.println("There were equals.");
                  
                  	if(spot == input.length)
                   	{
                   		spot = spot - 2;
                   	}//End spot reset if
             
            			 	input[spot] = holderA;
               			input[spot + 1] = input[B];
                		counterA++;
                		counterB++;
                  	if(counterA >= level && counterB >= level)
                   	{
                   		done = true;
                   	}//End doneness check if
                		A++;
                		B++;
                		spot = spot + 2;
                
               			/*System.out.print("Current value of array: ");
             				for(int o = 0; o < input.length; o++)
             				{
               				System.out.print(input[o]);
             				}//End of display for loop
             				System.out.println(".");*/
             			}//End of both are equal else
                 
                 	System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
                	
                
               }//End holderA check if
                
               else
               {
                  if(input[B] < input[A] || input[A] < input[B])
               		{	
               			System.out.println("Value of A = : " + input[A]);
               			System.out.println("Value of B = : " + input[B]);
                  	System.out.println("Holder A was empty.");
               
             				if(input[B] < input[A])
               			{
               				counterB++;
                 			holderA = input[A];
                 			//int x = input[spot];
                 			input[spot] = input[B];
                 			spot++;
                	   	//B++;
                     	if(B != (input.length - 1))
                      {
                      		B++;
                      }//End of B size check if
               			}
               
               			else if(input[A] < input[B])
               			{
                 			counterA++;
                 			//holderB = input[B];
                 			//int x = input[spot];
                 			input[spot] = input[A];
                 			spot++;
                   		A++;
               			}
                  }//End of main comparison if
                  
                  else
             			{
             				System.out.println("Value of A = : " + input[A]);
               			System.out.println("Value of B = : " + input[B]);
                  	System.out.println("There were equals.");
                  
                  	if(spot == input.length)
                   	{
                   		spot = spot - 2;
                   	}
            
           			 		input[spot] = holderA;
             				input[spot + 1] = input[B];
               			counterA++;
               			counterB++;
                  	if(counterA >= level && counterB >= level)
                   	{
                   		done = true;
                   	}//End doneness check if
               			A++;
               			B++;
               			spot = spot + 2;
                
               			/*System.out.print("Current value of array: ");
           					for(int o = 0; o < input.length; o++)
             				{
               				System.out.print(input[o]);
             				}//End of display for loop
             				System.out.println(".");*/
             			}//End of both are equal else
                 
                 	System.out.print("Current value of array: ");
             			for(int o = 0; o < input.length; o++)
             			{
               			System.out.print(input[o]);
             			}//End of display for loop
             			System.out.println(".");
                }//End holderA empty else
                //done = true;
                System.out.println("Testing stop");
                
                System.out.println("Counter A = : " + counterA);
                System.out.println("Counter B = : " + counterB);
                System.out.println("Spot = : " + spot);
                System.out.println("HolderA = : " + holderA);
                System.out.println("HolderB = : " + holderB);
             }//End counterA and B check else
             
             else if(input[B] < input[A] || input[A] < input[B])
             {
             		System.out.println("Value of A = : " + input[A]);
               	System.out.println("Value of B = : " + input[B]);
               	System.out.println("We are in the first comparison.");
             		
             		if(input[B] < input[A])
               {
               		counterB++;
                 holderA = input[A];
                 //int x = input[spot];
                 input[spot] = input[B];
                 spot++;
                 B++;
               }
               
               else if(input[A] < input[B])
               {
                 counterA++;
                 //holderB = input[B];
                 //int x = input[spot];
                 input[spot] = input[A];
                 spot++;
                 A++;
               }
               
               System.out.print("Current value of array: ");
             		for(int o = 0; o < input.length; o++)
             		{
               		System.out.print(input[o]);
             		}//End of display for loop
             		System.out.println(".");
               
               	//done = true;
                //System.out.println("Testing stop");
                //System.out.println("HolderA = : " + holderA);
                //System.out.println("HolderB = : " + holderB);
             }//End main comparison else if
             
             //A++;
             //B++;
           
           		System.out.println("Restarting while loop...");
             	//System.out.println("Counter A = : " + counterA);
             	//System.out.println("Counter B = : " + counterB);
           
         	}//End main operation while loop
         }//End of main operation for loop 
      }//End of normal operation if
      
      if(level == 2 && two == true)
      {
        	two = false;
      		System.out.println("CURRENT LEVEL: " + level);
      }//End second level 2 if
      
      else
      {
      		level = level * 2;
      		System.out.println("CURRENT LEVEL: " + level);
      }//End normal operation else
    		
      A = 0;
      B = level;
      
      if(level == reset && resort == true)
      {
      		level = 2;
        	A = 0;
         B = 1;
         resort = false;
         System.out.println("Re sorting...");
         System.out.println("CURRENT LEVEL: " + level);
      }//End of resort if
      
      merge(input, A, B, level, reset, two, resort);
    }//End of merge function
    
}//End of Sorter class