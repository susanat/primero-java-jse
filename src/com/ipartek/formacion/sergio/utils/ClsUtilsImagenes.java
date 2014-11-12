/*
 * 
 * version 1.0 15/05/2013
 */
package com.ipartek.formacion.sergio.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase de recopilación de funciones útiles para imágenes
 * 
 * @author baskito
 * @version 03.11.2014
 */
public class ClsUtilsImagenes {
    
    //Extensiones de imÃ¡genes permitidas
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen","jpg","png");
        
    //guarda la imagen en formato fichero
    private File lImagenFile = null;
    //guarda la imagen en formato ImageIcon
    private ImageIcon lImageIcon = null;
    //guarda la imagen en memoria
    private BufferedImage lBufferedImage = null; 
    
    public ClsUtilsImagenes()
    {
        
    }
    
    private File abrirDialogoParaImagenes(){
       JFileChooser fileChooser = new JFileChooser();       
       
       fileChooser.setFileFilter(filter); 
       
       int result = fileChooser.showOpenDialog(null);  
       if ( result == JFileChooser.APPROVE_OPTION ){
            
           return fileChooser.getSelectedFile();
            
        }else{
           return null;
       }
    } 
    
    public void  imagenEnLabelFromDialog(JLabel label) throws Exception
    {
        File archivoImagen = null;
        
        //obtenemos la imagen
        try
        {
            archivoImagen = abrirDialogoParaImagenes();
            if (archivoImagen != null){
                
                //guardamos el fichero 
                lImagenFile = archivoImagen;
                
                //guardamos el imageIcon
                lImageIcon = new ImageIcon(archivoImagen.getAbsolutePath()); 
                
                //guardamos el buffer
                lBufferedImage = this.imageToBuffer(lImagenFile);
                
                //se lo asignamos al label
                label.setIcon(ajustarImagen(lImageIcon,label));                
            }
            
        }catch(Exception ex){
            throw ex;
        }    
    }
    
    public void imagenEnLabelFromFile(JLabel label, String imagen) throws Exception
    {
        System.out.println("ClsImagenes2->imagenEnLabelFromFile: Entrando");
        File archivoImagen = null;
        
        //obtenemos la imagen
        try
        {
            System.out.println("ClsImagenes2->imagenEnLabelFromFile: nuevo file desde el string " + imagen);
            archivoImagen = new File(imagen);
                           
            //guardamos el fichero 
            System.out.println("ClsImagenes2->imagenEnLabelFromFile: guardamos en la variable de tipo file de la clase");
            lImagenFile = archivoImagen;

            //guardamos el imageIcon
            System.out.println("ClsImagenes2->imagenEnLabelFromFile: guardamos en la variable de tipo imageIcon de la clase");
            lImageIcon = new ImageIcon(archivoImagen.getAbsolutePath()); 

            //guardamos el buffer
            System.out.println("ClsImagenes2->imagenEnLabelFromFile: guardamos en la variable de tipo buffer de la clase");
            lBufferedImage = this.imageToBuffer(lImagenFile);

            //se lo asignamos al label
            System.out.println("ClsImagenes2->imagenEnLabelFromFile: se lo asignamos al label");
            label.setIcon(ajustarImagen(lImageIcon,label));
            
        }catch(Exception ex){
            System.out.println("ClsImagenes2->imagenEnLabelFromFile: Error " + ex);            
            throw ex;
        }    
    }
    
    public String completaNombreImagen(String nuevoNombre) throws Exception
    {
        if (lImagenFile == null)
            throw new Exception("No se ha cargado ningÃºn fichero");
        
        //se extrae el fomato de la cadena "f" que contiene la direccion
        String formato = (lImagenFile.getName().endsWith(".jpg")) ? "jpg" : "png"; 
        nuevoNombre += "." + formato;
        return nuevoNombre;
    }
    
    public String guardarImagen(String newFile) throws IOException, Exception
    {        
        if (lImagenFile == null)
            throw new Exception("No se ha cargado ningÃºn fichero");
   
        try {
            //se extrae el fomato de la cadena "f" que contiene la direccion
            
            String formato = (lImagenFile.getName().endsWith(".jpg")) ? "jpg" : "png"; 
                       
            //ImageIO.write(_image, "jpg", new File("e:/carpeta/imagen2.jpg"));
            ImageIO.write(lBufferedImage, formato, new File(newFile));
            
            return newFile;
        } catch (IOException e) {            
            System.out.println("Error al crear el archivo");
            throw e;
                
        }        
    }
    
    private ImageIcon ajustarImagen(ImageIcon ico, JLabel label)
    {
        
        //Escalar Imagen
        ico = new ImageIcon(ico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return ico;
    }
    
    /* dada una direccion fisica de un archivo de imagen,
     * coloca esta en el objeto BufferedImage, o sea en memoria */
    private BufferedImage imageToBuffer(File imagePath) throws IOException{
         System.out.println("ClsImagenes2->imageToBuffer: entrando");
        //se llena el buffer con la imagen    
         BufferedImage temp = null;         
            try {
                temp = ImageIO.read(imagePath);
                System.out.println("ClsImagenes2->imageToBuffer: correcto");
                return temp;
            } catch (IOException ex) {
                System.out.println("ClsImagenes2->imageToBuffer: error " + ex);
                Logger.getLogger(ClsUtilsImagenes.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
    }
    
    public String dialogoGuardar(){       
       JFileChooser fileChooser = new JFileChooser();       
       fileChooser.setFileFilter(filter);
       String url = "";
       
       int result = fileChooser.showSaveDialog(null);       
       if ( result == JFileChooser.APPROVE_OPTION ){ 
                //se obtiene la direccion donde se guardara la imagen
                url = fileChooser.getSelectedFile().toString();
                //String namefile = fileChooser.getSelectedFile().getName();
                System.out.println("url: " + url);
        }       
       return url;
   }
   
    
    
}
