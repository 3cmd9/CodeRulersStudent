/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mrd.Tournament;

import dev.CodeRulers.ruler.AbstractRuler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MikeRD
 * Usage:
 * On first usage, fill in tournament location with information provided by teacher
 * Run the code
 */
public class UploadRulerToTourney extends ClassLoader{
    
    //this is going  to hold the location of the tournament as provided by teacher.
    static String loc = "d:\\backup\\tourney";
    //this is the local file that saves the tournament location between uses.
    static File f= new File("tournamentloc.txt");
    
    public static void main(String[] args){

        // try to load location from local file
      //  File f = new File("tournamentloc.txt");
      //  String loc = ;
        if (f.exists()){
            try{
            Scanner s = new Scanner(f);
            loc = s.nextLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            }
        //show popup
     JFrame frame = new JFrame();
     loc = (String)JOptionPane.showInputDialog(
                    frame,
                    "Enter location of tournament:",
                    "Tourney Location",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    loc);
     
        try {
            //save tourney location to file
            PrintWriter pw = new PrintWriter(f);
            pw.println(loc);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadRulerToTourney.class.getName()).log(Level.SEVERE, null, ex);
        }
     //save the class PROPERLY
          saveClassToTourney(loc);
          System.exit(0);
    }
    
   
    
    /**
     * Save the current MyRuler.class to location specified by tourneyLocation, getSchoolName and getRulerName
     */
    public static void saveClassToTourney(String loc){
    try {
        org.mrd.Tournament.MyRuler my = new org.mrd.Tournament.MyRuler();
        
        //save this ruler to location
        File f = new File(org.mrd.Tournament.MyRuler.class.getResource("MyRuler.class").toURI());
        //  f = new File(f.getAbsolutePath()+"MyRuler.class");
        System.out.println(f.getAbsoluteFile());
        File destination = new File(loc + "\\" + my.getRulerName() + "\\org\\mrd\\Tournament\\MyRuler.class");
        destination.getParentFile().mkdirs();
        Files.copy(f.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (URISyntaxException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        
    }
}
