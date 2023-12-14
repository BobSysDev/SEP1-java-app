package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class is used to read and write the settings.txt file. This file contains the path to the folder where the website (the second part of the Semester Project) is located.
 * The path is used to copy the images from the GUI to the website and to save the XML file directly in the website folder so that the website's scripts can read it.
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */

public class TXTFileHandlerForFilePathSettings
{
  private static final String SETTINGS_FILE_PATH = "settings.txt";

  /**
   * This method reads the settings.txt file and returns the path to the folder where the website (the second part of the Semester Project) is located.
   * The path of the settings.txt file is hardcoded as a static variable in this class.
   *
   * @return the (absolute) path to the folder where the website (the second part of the Semester Project) is located.
   * @throws FileNotFoundException if the settings.txt file is not found or is not accessible.
   */
  public String readSettingsFilePath() throws FileNotFoundException{
    String pathToReturn = "";

    File file = new File(SETTINGS_FILE_PATH);
    Scanner scanner = new Scanner(file);
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      String[] parts = line.split("=");
      if(parts[0].equals("websiteImageFilePath")){
        pathToReturn = parts[1];
      }
    }
    scanner.close();

    return pathToReturn;
  }

  /**
   * This method writes the path to the folder where the website (the second part of the Semester Project) is located to the settings.txt file.
   * The path of the settings.txt file is hardcoded as a static variable in this class.
   *
   * @param websiteImageFilePath the (absolute) path to the folder where the website (the second part of the Semester Project) is located.
   * @throws FileNotFoundException if the settings.txt file is not found or is not accessible.
   */
  public void writeSettingsFilePath(String websiteImageFilePath) throws FileNotFoundException{
    File file = new File(SETTINGS_FILE_PATH);

    PrintWriter out = new PrintWriter(file);
    out.println("websiteImageFilePath=" + websiteImageFilePath);

    out.close();
  }
}
