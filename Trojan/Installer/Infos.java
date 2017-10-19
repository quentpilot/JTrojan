/**
 * @Description:        Infos class would to store OS informations
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Infos.java
 * @Date:               2017-10-19T15:25:30+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-19T16:35:26+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Installer;

public class Infos {

  /**
  * This attribute would to store os infos
  *
  * @see Infos#getOSName()
  */
  protected String os_name = null;

  /**
  * This attribute would to store os infos
  *
  * @see Infos#getHostName()
  */
  protected String host_name = null;

  /**
  * This attribute would to store os infos
  *
  * @see Infos#getOSArch()
  */
  protected String os_arch = null;

  /**
  * This attribute would to store os infos
  *
  * @see Infos#getOSVersion()
  */
  protected String os_version = null;

  /**
  * This attribute would to store os infos
  *
  * @see Infos#getUserName()
  */
  protected String user_name = null;

  /**
  * This main constructor would to do nothing
  *
  * @see Infos#Infos()
  */
  public Infos() {
  }

  /**
  * This second constructor would to set attributes from arguments
  *
  * @param os_name
  *                 current OS infos
  * @param host_name
  *                 current OS infos
  * @param os_arch
  *                 current OS infos
  * @param os_version
  *                 current OS infos
  * @param user_name
  *                 current OS infos
  *
  * @see Infos#Infos()
  */
  public Infos(String os_name, String host_name, String os_arch, String os_version, String user_name) {
      this.os_name = os_name;
      this.host_name = host_name;
      this.os_arch = os_arch;
      this.os_version = os_version;
      this.user_name = user_name;
  }

  /**
  * This third constructor would to set attributes from an array
  *
  * @param infos
  *                 current OS infos in array
  *
  * @see Infos#Infos()
  */
  public Infos(String[] infos) {
      this.os_name = infos[0];
      this.host_name = infos[1];
      this.os_arch = infos[2];
      this.os_version = infos[3];
      this.user_name = infos[4];
  }

  /**
  * This method would to get data attribute
  *
  * @return os_name value
  *
  * @see Infos#os_name
  */
  public String getOSName() {
      return this.os_name;
  }

  /**
  * This method would to get data attribute
  *
  * @return host_name value
  *
  * @see Infos#host_name
  */
  public String getHostName() {
      return this.host_name;
  }

  /**
  * This method would to get data attribute
  *
  * @return os_arch value
  *
  * @see Infos#os_arch
  */
  public String getOSArch() {
      return this.os_arch;
  }

  /**
  * This method would to get data attribute
  *
  * @return os_version value
  *
  * @see Infos#os_version
  */
  public String getOSVersion() {
      return this.os_version;
  }

  /**
  * This method would to get data attribute
  *
  * @return user_name value
  *
  * @see Infos#user_name
  */
  public String getUserName() {
      return this.user_name;
  }

  /**
  * This method would to return a string
  * with related class data attributes
  *
  * @return value for each attribute
  *
  * @see Infos#Infos()
  */
  public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\t*** OS infos ***\n");
      stringBuilder.append(this.os_name + " ");
      stringBuilder.append(this.host_name + " ");
      stringBuilder.append(this.os_arch + " ");
      stringBuilder.append(this.os_version + " ");
      stringBuilder.append(this.user_name);
      return stringBuilder.toString();
  }
}
