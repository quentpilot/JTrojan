/**
 * @Description:        Server class would to link our trojan to client OS
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Server.java
 * @Date:               2017-10-19T15:27:04+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-19T16:38:46+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Connect;

import Trojan.Installer.Infos;
import Trojan.Tools.Parser;

public class Server extends Connection {

    /**
    * This attribute would to store
    * OS infos parsed to resources/infos/os.json
    *
    * @see Server#run()
    * @see Server#getInfos()
    */
    protected Infos       infos = null;

    /**
    * Main Server constructor
    *
    * @see Server#run()
    */
    public             Server(){}

    /**
    * This method would to start server connection
    *
    * @return Success or not
    *
    * @see Server#infos
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
    * @see Server#infos
    * @see Server#run()
    */
    public Infos        getInfos() {
        return this.infos;
    }
}
