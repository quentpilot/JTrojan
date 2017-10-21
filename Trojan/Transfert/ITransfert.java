/**
 * @Description:        ITransfert class interface would to gives some tools to transfert data between Client and Server classes
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           ITransfert.java
 * @Date:               2017-10-19T16:20:06+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-21T12:19:59+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Transfert;

public interface ITransfert {

  /**
  * This method would to get current transfert data
  * between server and client
  *
  * @see ITransfert#get()
  */
  public void get();

  /**
  * This method would to update transfert data
  * between server and client
  *
  * @see ITransfert#update()
  */
  public void update();
}
