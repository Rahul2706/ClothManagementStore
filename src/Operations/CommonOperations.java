/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Rahul khurana
 */
public class CommonOperations {
    public static void showInternalFrame(JDesktopPane deskpane,JInternalFrame jif){
        deskpane.add(jif);
        jif.setVisible(true);
    }
    public static String getFileName(String path){
        int index = path.lastIndexOf("\\");
        if(index!=-1){
            return path.substring(index + 1);
        }
        return null;
    }
    public static String getExtension(String path){
        int index = path.lastIndexOf(".");
        if(index!=-1){
            return path.substring(index + 1);
        }
        return null;
    }
}

