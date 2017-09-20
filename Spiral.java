import java.util.*;
public class Spiral {

    static String inputDirection=null;
    static int inputNumber=0;
    static int elem=0;
    static int left,right,up,down=0; 
    static int currentNumber = 0; //digits to be set. num has to go till n(input).
    static int spaces=0;
    static int count=0;
    static int len=0;
    static int[][] arr; 
    static int[] digitsInRowCounter ; 
    static int[] digitsInColCounter ;
    static int rowVal,colVal = 0;
    
    public Scanner sc = new Scanner(System.in);
        public static void main (String[] args) 
        {
        	Spiral spiralVal = new Spiral();
        	inputNumber = spiralVal.getNumber();
        	if(inputNumber<0 || inputNumber>999){
        		System.out.println("Invalid Number. Please enter in range of 1-999");
        		System.exit(0);
        	}
            inputDirection = spiralVal.getDirection();
            if(!(inputDirection.matches("left")||inputDirection.matches("right")||inputDirection.matches("Left")||inputDirection.matches("Right"))){
        		System.out.println("Please enter only left or right as valid directions");
        		System.exit(0);
        	}
        	spiralVal.drawMatrix();
        	
        }
                 
        public void drawMatrix() {
			// TODO Auto-generated method stub
        		sc.close();   
               len = initializeParameters();
               
               setPositionofZero();
               
               currentNumber=1;
               count = 1; 
               elem = len*len; 
               
               try
               {
                   if(inputDirection.matches("left")) 
                   {
                       left=-1; 
                       down=1;
                       right=2;
                       up=-2;
                       
                       while(count<elem-1){
               
                           moveLeftSpiral();
                           moveDownSpiral();
                           moveRightSpiral();
                           moveUpSpiral();
                           
                           left=left-2;
                           down=down+2;
                           right=right+2;
                           up=up-2;
                           
                       } 
                   }
                   
                   else
                   {
                       left=-2; 
                       down=1;
                       right=1;
                       up=-2;
                   
                   while(count<elem-1){

                           moveRightSpiral();
                           moveDownSpiral();
                           moveLeftSpiral();
                           moveUpSpiral();
                           
                           left=left-2;
                           down=down+2;
                           right=right+2;
                           up=up-2;
                               
                           }
                       
                   }
               }catch(ArrayIndexOutOfBoundsException e){
               }
               
               
               printSpiralMatrix();
               

		}
		public int getNumber(){
        	
        	System.out.println("Enter ending number:");
        	inputNumber = sc.nextInt();
        	return inputNumber;
        	
        }
        
        public String getDirection(){
        	
        	System.out.println("Enter direction:");
        	inputDirection = sc.next();
        	//sc.close();
        	return inputDirection;
        }
    public int initializeParameters(){
                int k=0;
                double sqrt = 0;
                
                for( int i=1; i<inputNumber;i++){
                	sqrt = Math.pow((i+1),2);
                	if(inputNumber>i && inputNumber<sqrt){
                		k = i+1;
                		break;
                	}
                }
                
                    arr = new int[k][k]; 
                    digitsInRowCounter = new int[k]; 
                    digitsInColCounter = new int[k];

            return k;
    }
    public void setPositionofZero(){
        if (len%2==0){
                if(inputDirection.matches("left"))
                {
                    rowVal = len/2-1; 
                    colVal=len/2;
                }
                else
                {
                    rowVal=len/2-1;
                    colVal=len/2-1;
                }
            }
            else{
                rowVal = colVal = (len+1)/2-1; 
            }
            
            
            arr[rowVal][colVal] = 0;
            digitsInRowCounter[rowVal] = 1;
            digitsInColCounter[colVal] = 1;
    }
    
    public void printSpiralMatrix()
    {
    	
    	System.out.println("\nSpiral Matrix is as follows:");
        for(int row =0;row<len;row++){
                System.out.println("\n");
                for(int col = 0;col<len;col++){
                    if(arr[row][col]==1000){
                       System.out.print("\t"); 
                    }
                    else
                    {
                    System.out.print(arr[row][col]+"\t");
                    }
                }
            }
    }
        
        public void moveLeftSpiral(){
                        
                        for(int x=0;x>left;x--){
                            
                        count++;
                        
                        if(colVal>=0 && colVal<len){
                            colVal=colVal-1;
                        }
                        if(currentNumber<inputNumber/2)
                        {
                            
                            if(digitsInRowCounter[rowVal]<(len-1) && digitsInColCounter[colVal]<(len-1))
                            {
                                arr[rowVal][colVal] = currentNumber; 
                                currentNumber++; 
                                digitsInRowCounter[rowVal]++; 
                                digitsInColCounter[colVal]++;
                                spaces=0; 
                            
                            }
                            else
                            {
                                arr[rowVal][colVal]=1000; 
                                spaces++;
                            
                            }
                        }
                        
                        else if(currentNumber<=inputNumber)
                        {
                            
                            if(digitsInRowCounter[rowVal]<len && digitsInColCounter[colVal]<len)
                            {
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                               spaces=0;
                            
                            }
                            else
                            {
                             arr[rowVal][colVal]=1000;
                             spaces++;
                            
                            
                            }
                        }
                        else
                        {
                            arr[rowVal][colVal]=1000;
                            spaces++;
                        }
                        
                    }
                            
        }
        
        public void moveRightSpiral(){
            for(int x=0;x<right;x++){
                        count++;
   
                        if(colVal>=0 && colVal<len)
                        {
                            colVal=colVal+1;
                        }
                         
                      
                        if(currentNumber<inputNumber/2)
                        {
                            if(digitsInRowCounter[rowVal]<(len-1) && digitsInColCounter[colVal]<(len-1))
                            {
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                                spaces=0;
                             
                           
                            }
                            else
                            {
                             arr[rowVal][colVal]=1000;
                             spaces++;
                            
                            
                            }
                        }
                        else if(currentNumber<=inputNumber)
                        {
                            if(digitsInRowCounter[rowVal]<len && digitsInColCounter[colVal]<len)
                            {
                                
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                                spaces=0;
                                
                            
                            }
                            else
                            {
                                arr[rowVal][colVal]=1000;
                                spaces++;
                           
                            
                            }
                            
                        }
                        else
                        {
                            arr[rowVal][colVal]=1000;
                            spaces++;
                        }
                        
                    }
            
        }
        public void moveDownSpiral(){
            for(int x=0;x<down;x++)
                        {
                        count++;
                        if(rowVal>=0 && rowVal<len)
                        {
                            rowVal=rowVal+1;
                        }
                        if(currentNumber<inputNumber/2)
                        {
                            if(digitsInRowCounter[rowVal]<(len-1) && digitsInColCounter[colVal]<(len-1))
                            {
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                                spaces=0;
                            }
                            else
                            {
                                arr[rowVal][colVal]=1000;
                                spaces++;
                            }
                        }
                        else if(currentNumber<=inputNumber)
                        {
                            if(digitsInRowCounter[rowVal]<len && digitsInColCounter[colVal]<len)
                            {
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                                spaces=0;
                                
                            
                            }
                            else
                            {
                            
                                spaces++;
                                if(spaces>2)
                                {
                                    
                                    arr[rowVal-2][colVal]=currentNumber-1;
                                    
                                    if(inputDirection.matches("left")){
                                        arr[rowVal-2][colVal+1]=1000;
                                        digitsInColCounter[colVal+1]--;
                                    }
                                    else
                                    {
                                        arr[rowVal-2][colVal-1]=1000;
                                        digitsInColCounter[colVal-1]--;
                                        
                                    }
                                    
                                    arr[rowVal][colVal]=1000; 
                                    
                                    spaces=0; 
                                    
                                     
                                    digitsInColCounter[colVal]++;
                            
                            
                                    
                                }
                                else
                                {
                                    arr[rowVal][colVal]=1000; 
                                }
                            
                            
                            }
                            
                        }
                        
                        
                        else
                        {
                            arr[rowVal][colVal]=1000;
                            spaces++;
                        }
                        
                    }
            
                    
        }
        public void moveUpSpiral(){
            for(int x=0;x>up;x--)
                    {
                        
                        count++;
                        
                        if(rowVal>=0 && rowVal<len)
                        {
                             
                            rowVal=rowVal-1;
                             
                        }
                        
                        
                        if(currentNumber<inputNumber/2)
                        {
                            if(digitsInRowCounter[rowVal]<(len-1) && digitsInColCounter[colVal]<(len-1))
                            {
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                                spaces=0;
                            
                                
                            }
                            else
                            {
                                arr[rowVal][colVal]=1000;
                                spaces++;
                            
                            }
                        }
                        else if (currentNumber<=inputNumber) 
                        {
                            if(digitsInRowCounter[rowVal]<len && digitsInColCounter[colVal]<len)
                            {
                                arr[rowVal][colVal] = currentNumber;
                                currentNumber++;
                                digitsInRowCounter[rowVal]++;
                                digitsInColCounter[colVal]++;
                                 spaces=0;
                            
                            }
                            else
                            {
                                spaces++;
                        
                                if(spaces>2)
                                {
                                    arr[rowVal+2][colVal]=currentNumber-1;
                                    if(inputDirection.matches("left")){
                                        arr[rowVal+2][colVal-1]=1000;
                                        digitsInColCounter[colVal-1]--;
                                    }
                                    else
                                    {
                                        arr[rowVal+2][colVal+1]=1000;
                                        digitsInColCounter[colVal+1]--;
                                    }
                                        
                                    
                                    arr[rowVal][colVal]=1000;
                                    spaces=0;
                                    
                                    digitsInColCounter[colVal]++;
                                }
                                else
                                {

                                    arr[rowVal][colVal]=1000;
                                }
                            
                            
                            }
                            
                        }
                        else
                        {
                            arr[rowVal][colVal]=1000;
                            spaces++;
                        }
                        
                    }
        }


        public int testinteger() {
            // TODO Auto-generated method stub
        	if(inputNumber<0 || inputNumber>999){
        		inputNumber=0;
        	}
            return inputNumber;
        }

        public String testdirection() {
            // TODO Auto-generated method stub
        	if(!(inputDirection.matches("left")||inputDirection.matches("right")||inputDirection.matches("Left")||inputDirection.matches("Right"))){
        		inputDirection="invalid";
        	}
        	
            return inputDirection;
            
        }
    }