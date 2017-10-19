/**
 * @Description:        Client class would to connect our trojan to client OS
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Client.java
 * @Date:               2017-10-19T15:27:34+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-19T16:38:34+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Connect;

import Trojan.Installer.Infos;
import Trojan.Tools.Parser;

public class Client extends Connection {

    /**
    * This attribute would to store
    * OS infos parsed to resources/infos/os.json
    *
    * @see Client#run()
    * @see Client#getInfos()
    */
    protected Infos       infos = null;

    /**
    * Main Client constructor
    *
    * @see Client#run()
    */
    public             Client(){}

    /**
    * This method would to start client connection
    *
    * @return Success or not
    *
    * @see Client#infos
    */
    public boolean      run() {
        Parser parser = new Parser();
        this.infos = parser.getData()[0];
        return true;
    }

    /**
    * This method would to get current OS infos
    *
    * @return current infos data class
    *
    * @see Client#infos
    * @see Client#run()
    */
    public Infos        getInfos() {
        return this.infos;
    }
}
