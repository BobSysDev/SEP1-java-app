package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TXTFileHandlerForFilePathSettings
{
  private static final String SETTINGS_FILE_PATH = "settings.txt";

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

  public void writeSettingsFilePath(String websiteImageFilePath) throws FileNotFoundException{
    File file = new File(SETTINGS_FILE_PATH);

    PrintWriter out = new PrintWriter(file);
    out.println("websiteImageFilePath=" + websiteImageFilePath);

    out.close();
  }
}
