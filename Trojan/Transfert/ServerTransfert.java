/**
 * @Description:        ServerTransfert class would to play with server data transit
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           ServerTransfert.java
 * @Date:               2017-10-21T14:41:18+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-21T14:59:21+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Transfert;

import Trojan.Transfert.ITransfert;

public class ServerTransfert implements ITransfert {

  /**
  * This main constructor would to do nothing
  *
  * @see ITransfert
  */
  public ServerTransfert() {}

  /**
  * This method would to get current transfert data
  * between server and client
  *
  * @see ITransfert#get()
  */
  public void get() {
    System.out.println("Get Server Transfert Data");
  }

  /**
  * This method would to update transfert data
  * between server and client
  *
  * @see ITransfert#update()
  */
  public void update() {
    System.out.println("Update Server Transfert Data");
  }
}
