/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.fal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author MonsieurJ
 */
public class Writer {
    private final String _directory;
    private FileWriter _file;
    
    public Writer()
    {
        _directory = getUserLibDirectory() + "\\";
    }
    
    /**
     * Write the content param into the file, then saves
     * the file to the specified directory. If path is set
     * to null, the method will save automatically the file
     * in the current user working directory.
     * @param content content of the file
     * @param fileName name of the file, DO NOT append the extension (.txt).
     */
    public void write(String content, String fileName)
    {
        if (content == null) throw new NullPointerException("Path cannot be null");
        try 
        {
            _file = new FileWriter(_directory + fileName + ".txt");
            _file.write(content);
            _file.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, "Writer failed", ex);
        }
    }
    
    /**
     * Returns a string representation of the path to the current
     * user's home (home under Unix OS & Documents under Windows).
     * @return Returns a string representation of the path to the user's home
     */
    public static String getUserLibDirectory()
    {
        return FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
    }
}
