package ic;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 * @author Brian Holland
 */
public class Ic {

    /**
     * This program calculates the index of coincidence.
     * @param args the command line arguments
     */
    
    private static float nTotal = 0;
    private static HashMap<Integer, Float> dLength = new HashMap<>();
    
    public static void main(String[] args) {
        if (args.length == 0)
        {
            System.out.println("No args");
            System.exit(-1);
        }
        nTotal = (float)Integer.parseInt(args[0]);
        if (nTotal <= 0)
        {
            System.out.println("Total char cannot be zero or negative! "
                    + "Exiting program.");
            System.exit(-1);
        }
        printFirst(); 
        for (int numArg = 1; numArg < args.length; numArg++)
        {
            if (Integer.parseInt(args[numArg]) <= 0)
            {
                System.out.println("Key length cannot be zero or negative! "
                        + "Exiting program.");
                System.exit(-1);
            }
            functionIC(Integer.parseInt(args[numArg]));
            dLength.put(Integer.parseInt(args[numArg]), 0f);
        }
        System.exit(1);
    }
    /**
     * Did not used but left in program in case I need it later.
     */
    private static void functionIC() 
    {
        float indexCoin = 0f;  
        float tempKey = 0f;
        System.out.println(dLength);
        for (int key : dLength.keySet())
        {
            tempKey = (float)key;            
            indexCoin = (1f/tempKey)*((nTotal - tempKey)/(nTotal - tempKey)) 
                    * 0.066f + ((tempKey - 1f) / tempKey) 
                    * (nTotal / (nTotal - 1f)) * 0.038f;
            dLength.put(key, indexCoin);
        }
    }
    /*
     * Print the header.
     */
    private static void printFirst() 
    {
        System.out.println("Key  Expected IC (N=" + (int)nTotal + ")");
        System.out.println("---- -------------------");
    }
    /**
     * Did not used but left in program in case I need it later.
     */
    private static void printLast() 
    {        
        String tempString = null;     
        String tempKey =  null;
        DecimalFormat format = new DecimalFormat();
        DecimalFormat front = new DecimalFormat("####");
        
        format.setMaximumFractionDigits(4);
        format.setMinimumFractionDigits(4);
        format.setMaximumIntegerDigits(1);
        format.setMinimumIntegerDigits(1); 
        front.setMaximumFractionDigits(0);
        front.setMinimumFractionDigits(0);
        front.setMaximumIntegerDigits(4);
        front.setMinimumIntegerDigits(4);
        
        for (int key : dLength.keySet())
        {
            tempKey = front.format(key);
            
            if (tempKey.charAt(0) ==  '0')
            {
                if (tempKey.charAt(1) == '0')
                {
                    if (tempKey.charAt(2) == '0')
                    {
                        tempKey = tempKey.replaceFirst("0", " ");
                        tempKey = tempKey.replaceFirst("0", " ");
                        tempKey = tempKey.replaceFirst("0", " ");
                    }
                    else
                    {
                        tempKey = tempKey.replaceFirst("0", " ");
                        tempKey = tempKey.replaceFirst("0", " ");
                    }
                }
                else
                {
                    tempKey = tempKey.replaceFirst("0", " ");
                }
            }
            tempString = format.format(dLength.get(key));
            System.out.println(tempKey + " " + tempString);
        }
    }
    /*
     * This does the math for the IoC and sends the inforatiom to be printed.
     */
    private static void functionIC(int parseInt) 
    {
        float indexCoin = 0f;  
        float tempKey = 0f;
        
        tempKey = (float)parseInt;            
        if (nTotal - tempKey == 0)
        {
            indexCoin = ((tempKey - 1f) / tempKey) * (nTotal / (nTotal - 1f)) 
                    * 0.038f;
        }
        else
        {
            indexCoin = ((1f/tempKey)*((nTotal - tempKey)/(nTotal - 1f)) 
                * 0.066f) + (((tempKey - 1f) / tempKey) 
                * (nTotal / (nTotal - 1f)) * 0.038f);
        }        
        printLast(tempKey, indexCoin);       
    }
    /**
     * This formats and prints the IoC for each input length given.
     * @param key
     * @param indexCoin 
     */
    private static void printLast(float key, float indexCoin) 
    {
        String tempString = null;     
        String tempKey =  null;
        DecimalFormat format = new DecimalFormat();
        DecimalFormat front = new DecimalFormat("####");
        
        format.setMaximumFractionDigits(4);
        format.setMinimumFractionDigits(4);
        format.setMaximumIntegerDigits(1);
        format.setMinimumIntegerDigits(1); 
        front.setMaximumFractionDigits(0);
        front.setMinimumFractionDigits(0);
        front.setMaximumIntegerDigits(10);
        front.setMinimumIntegerDigits(4);
        
        tempKey = front.format(key);
        
        if (tempKey.charAt(0) ==  '0')
        {
            if (tempKey.charAt(1) == '0')
            {
                if (tempKey.charAt(2) == '0')
                {
                    tempKey = tempKey.replaceFirst("0", " ");
                    tempKey = tempKey.replaceFirst("0", " ");
                    tempKey = tempKey.replaceFirst("0", " ");
                }
                else
                {
                    tempKey = tempKey.replaceFirst("0", " ");
                    tempKey = tempKey.replaceFirst("0", " ");
                }
            }
            else
            {
                tempKey = tempKey.replaceFirst("0", " ");
            }
        }
        tempString = format.format(indexCoin);
        System.out.println(tempKey + " " + tempString);        
    }

}
