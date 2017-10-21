/**
 * @Description:        Writer class is used to put each OS infos object in json file
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Writer.java
 * @Date:               2017-10-19T15:43:23+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-20T18:42:48+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Tools;

import Trojan.Install.Infos;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    /**
    * Iterates for each data object built
    *
    * @see Writer#getObjId()
    */
    protected int objId = 0;

    /**
    * define standard file format
    *
    * @see Writer#getFormat()
    * @see Writer#isFormated()
    */
    protected String format = ".json";

    /**
    * Main data Writer would to get
    * Each valid json file is instanced
    * into new Infos Class and stored as array
    *
    * @see Writer#getData()
    * @see Writer#write()
    * @see Writer#build(Infos _data)
    */
    protected Infos[] data = null;

    /**
    * Filename is used to know which is the
    * current object to write in file
    *
    * @see Writer#getFilename()
    * @see Writer#write()
    * @see Writer#build(Infos _data)
    */
    protected String filename = null;

    /**
    * Resource is used by default as
    * repository reference to access
    * to the needed json files
    *
    * @see Writer#getResource()
    * @see Writer#write()
    */
    protected String resource = "resources/infos/";

    /**
    * Main Writer constructor which set data
    *
    * @see Writer#data
    */
    public Writer() {
        this.data = new Infos[100];
    }

    /**
    * Second Writer constructor which set Infos array
    *
    * @param _data
    *               Infos array to genere file
    *
    * @see Writer#data
    */
    public Writer(Infos[] _data) {
        this.data = new Infos[100];
        this.data = _data;
        this.write();
    }

    /**
    * Third Writer constructor which set unique object
    *
    * @param _data
    *               Infos object to store and get-in-file
    *
    * @see Writer#data
    */
    public Writer(Infos _data) {
        this.data = new Infos[1];
        this.data[0] = _data;
        this.write();
    }

    /**
    * Third Writer constructor which set unique object
    *
    * @param _data
    *               Infos object to store and get-in-file
    * @param _resource
    *               set current resources repository
    *
    * @see Writer#data
    */
    public Writer(Infos _data, String _resource) {
        this.resource = _resource;
        this.data = new Infos[1];
        this.data[0] = _data;
        this.write();
    }

    /**
    * Add new Infos instance to current data Array
    *
    * @param _data
    *               store current Infos object to list
    *
    * @see Writer#data
    */
    public void add(Infos _data) {}

    /**
    * Parse related json files and store
    * them as Objects Array to work with
    *
    * @return Success or not
    *
    * @see Writer#data
    * @see Writer#filename
    * @see Writer#resource
    * @see Writer#isFormated()
    */
    public boolean write() {
        if (this.getSize() <= 0) {
            return false;
        }
        for (Infos infos : this.getData()) {
            if (infos == null) continue;
            this.filename = this.getResource() + "os" + this.getFormat();
            this.build(infos);
        }
        return true;
    }

    /**
    * Build writer while loop
    *
    * @param _data
    *                current data to genere file
    *
    * @return bool type following success or failure of each
    *         Infos objects
    *
    * @see Writer#data
    */
    protected boolean build(Infos _data) {
        try {
            Gson        gson = new Gson();
            String      string = gson.toJson((Object)_data);
            FileWriter  fileWriter = new FileWriter(this.getFilename());

            fileWriter.write(string);
            fileWriter.close();
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    /**
    * Computes how many Infos are stored
    *
    * @return number of object from array
    *
    * @see Writer#data
    */
    public int getSize() {
        if (this.data == null) {
            return 0;
        }
        return 1;
    }

    /**
    * Check if current object is well formated
    *
    * @return true or false following data set
    *
    * @see Infos#Infos()
    */
    protected boolean isFormated() {
      return false;
    }

    /**
    * Get id of current object
    *
    * @return objId attribute
    *
    * @see Writer#objId
    */
    public int getObjId() {
        return this.objId;
    }

    /**
    * Get file format autorized
    *
    * @return format attribute
    *
    * @see Writer#write()
    */
    public String getFormat() {
        return this.format;
    }

    /**
    * Get Infos array data from files parsed
    *
    * @return data attribute
    *
    * @see Writer#data
    */
    public Infos[] getData() {
        return this.data;
    }

    /**
    * Get current filename to parse
    *
    * @return filename attribute
    *
    * @see Writer#filename
    */
    public String getFilename() {
        return this.filename;
    }

    /**
    * Get repository source to parse files
    *
    * @return resource attribute
    *
    * @see Writer#resource
    */
    public String getResource() {
        return this.resource;
    }
}
