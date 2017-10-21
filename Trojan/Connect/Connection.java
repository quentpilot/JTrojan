/**
 * @Description:        Connection class would to connect our trojan to client OS
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Connection.java
 * @Date:               2017-10-19T15:26:15+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-21T12:21:35+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Connect;

import Trojan.Install.Infos;
import Trojan.Tools.Parser;
import Trojan.Transfert.ITransfert;

public class Connection implements ITransfert {

    /**
    * This attribute would to store
    * OS infos parsed to resources/infos/os.json
    *
    * @see Connection#run()
    * @see Connection#getInfos()
    */
    protected Infos       infos = null;

    /**
    * Main Connection constructor
    *
    * @see Connection#run()
    */
    public             Connection(){}

    /**
    * This method would to start user connection
    *
    * @return Success or not
    *
    * @see Connection#infos
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
    * @see Connection#infos
    * @see Connection#run()
    */
    public Infos        getInfos() {
        return this.infos;
    }

    /**
    * This method would to get current transfert data
    *
    * @see Connection#run()
    */
    public void         get() {}

      /**
      * This method would to update transfert data
      *
      * @see Connection#run()
      */
      public void         update() {}
}
