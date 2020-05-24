import java.io.File; 
import java.io.FileInputStream; 

import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.*;


import java.util.*;

public class ByteArraySpeichern { 

    private static byte[] readZipFile(String zipFnm){
        File file = new File(zipFnm);
        FileInputStream fileInputStream=null;
        byte[] bFile = null;
        try{
            fileInputStream = new FileInputStream(zipFnm); 
            bFile = new byte[(int) file.length()];
            fileInputStream.read(bFile);
        }catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }finally{ 
            try { 
                if(fileInputStream != null) fileInputStream.close(); 
            } catch (IOException e) {} 
        }
        return bFile;


    }

    public static void main(String[] args) { 
	// ##########	change name	###################
        String string = "applaus.zip";
        

        ByteArraySpeichern bas = new ByteArraySpeichern();
        byte[] array = bas.readZipFile(string);


        int[] unsigned_array = new int[(int) bas.readZipFile(string).length];
         
        
        for(int i=0; i<bas.readZipFile(string).length;i++) {
            unsigned_array[i]=array[i] & 0xFF;
        }

        System.out.println(Arrays.toString(unsigned_array));
        System.out.println(bas.readZipFile(string).length);

    } 
} 
