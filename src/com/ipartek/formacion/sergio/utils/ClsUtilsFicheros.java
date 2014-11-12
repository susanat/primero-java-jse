

package com.ipartek.formacion.sergio.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Clase de recopilación de funciones útiles para trabajar con ficheros
 * 
 * @author baskito
 * @version 03.11.2014
 */
public class ClsUtilsFicheros {
	
	private final static String BARRA_PATH_SIMPLE = "/";
    private final static String BARRA_PATH_DOBLE = "\\";
    
    
    public static boolean existeFichero(String path){
        
        File fFile = new File(path);        
        return (fFile.exists() ? true : false);
    }
    
    public static String combinarRutas(String path1, String path2){
        
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath().toString();        
        
    }
    
    private static long espacioLibre(String unidad) {
        File drive = new File(unidad);
        return drive.getFreeSpace();
    }

    public static boolean existeExpacioLibre(String unidad, Long mayorQue) {
        if (espacioLibre(unidad) > mayorQue) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean existeExpacioLibre(String unidad) {
        if (espacioLibre(unidad) > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String checkBarraFinal(String path)
    {
        String barra = "";        
        //comprobamos el tipo de ruta:
        if(path.contains(BARRA_PATH_SIMPLE))
            barra = BARRA_PATH_SIMPLE;
        else if(path.contains(BARRA_PATH_DOBLE))
            barra = BARRA_PATH_DOBLE;
        if(!path.endsWith(barra))               
        {
            path += barra;            
        }        
        return path;
    }
    
    public static String getAbsolutePath(String relativePath)
    {
        Path path = Paths.get(relativePath);               
        String spath = path.toAbsolutePath().toString();               
        spath = spath.replace(".", "");
        return spath;
    }
    
    /**
     * Lee un fichero y devuelve un string </p>
     * 
     * Ejemplos:   
     * The StandardCharsets class define some constants for the encodings required of all Java runtimes:
     * - String content = readFile("test.txt", StandardCharsets.UTF_8);
     * 
     * The platform default is available from the Charset class itself:
     * - String content = readFile("test.txt", Charset.defaultCharset());
     * 
     * @param path Ruta del fichero
     * @param encoding Codificación
     * @return
     * @throws IOException 
     */
    public static String readFile1(String path, Charset encoding)  throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
    
    public static String readFile2(String path) throws FileNotFoundException{
        
        String content = "";        
        content = new Scanner(new File(path)).useDelimiter("\\Z").next();
        //System.out.println(content);
        
        
        
        return content;
    }
    
    /**
     * 
     * 
     * - orientado a ficheros pequeños
     * @param path
     * @param encoding
     * @return 
     */
    public static String readFile3(String path, Charset encoding) {
        FileInputStream fis = null;
        byte[] data = null;
        String content = "";
        
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            content = new String(data, encoding);
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ClsFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                //Logger.getLogger(ClsFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return content;
    }
   
    /**
     * http://www.javapractices.com/topic/TopicAction.do?Id=42 Note: the javadoc
     * of Files.readAllLines says it's intended for small files. But its
     * implementation uses buffering, so it's likely good even for fairly large
     * files.
     */
    public static List<String> readSmallTextFile(String aFileName, Charset encoding) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, encoding);
    }

    public static void writeSmallTextFile(List<String> aLines, String aFileName, Charset encoding) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines, encoding);
    }

    //For larger files  
    public static List<String> readLargerTextFile(String aFileName, Charset encodig) throws IOException {
        Path path = Paths.get(aFileName);
        List<String> texto = new ArrayList<String>();
        try (Scanner scanner = new Scanner(path, encodig.name())) {
            while (scanner.hasNextLine()) {
                //process each line in some way
                texto.add(scanner.nextLine());
            }
        }
        return texto;
    }

    public static List<String> readLargerTextFileAlternate(String aFileName, Charset encoding) throws IOException {
        Path path = Paths.get(aFileName);
        List<String> texto = new ArrayList<String>();
        try (BufferedReader reader = Files.newBufferedReader(path, encoding)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                //process each line in some way
                texto.add(line);
            }
        }
        return texto;
    }

    public static void writeLargerTextFile(String aFileName, List<String> aLines, Charset encoding) throws IOException {
        Path path = Paths.get(aFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, encoding)) {
            for (String line : aLines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
    
    public static List<String> readWithScanerToList(String path, Charset encoding) throws IOException
    {
        Path fFilePath = Paths.get(path);
        List<String> texto = new ArrayList<String>();
        
        Scanner scanner =  new Scanner(fFilePath, encoding.name());
        //procesamos la lectura en filas
        while (scanner.hasNextLine()){
            texto.add(scanner.nextLine());
        } 
        
        scanner.close();
        
        return texto;
    }
}
