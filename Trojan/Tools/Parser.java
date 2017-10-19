/**
 * @Description:        Parser class is used to get each OS infos in object
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            JTrojan
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Parser.java
 * @Date:               2017-10-19T15:43:04+02:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-10-19T16:37:47+02:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/JTrojan
 */


package Trojan.Tools;

import Trojan.Installer.Infos;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Parser {

  /**
    * Iterates for each data object built
    *
    * @see Parser#getObjId()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected int objId = 0;

    /**
    * used to know if Parser uses basic resource folder
    * or from standard input
    *
    * @see Parser#getAuto()
    * @see Parser#Parser(String[] argvs)
    */
    protected boolean auto = true;

    /**
    * define standard file format
    *
    * @see Parser#getFormat()
    * @see Parser#isFormated()
    */
    protected String format = "json";

    /**
    * Main data parser would to get
    * Each valid json file is instanced
    * into new Infos Class and stored as array
    *
    * @see Parser#getData()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected Infos[] data = null;

    /**
    * Used to store each file entered as args
    * then Parse would use these files
    * instead of basic resource repository
    *
    * @see Parser#getArgFiles()
    * @see Parser#Parser(String[] args)
    */
    protected String[] argFiles = null;

    /**
    * Store files reading by folder reader
    *
    * @see Parser#getFiles()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected File[] files = null;

    /**
    * Filename is used to know which is the
    * current file parsed and stored into Infos object
    *
    * @see Parser#getFilename()
    * @see Parser#parse()
    * @see Parser#build()
    * @see Parser#isFormated()
    */
    protected String filename = null;

    /**
    * Resource is used by default as
    * repository reference to access
    * to the needed json files
    *
    * @see Parser#getResource()
    * @see Parser#Parser(String[] argv)
    * @see Parser#parse()
    */
    protected String resource = "resources/infos/";

    /**
    * Main Parser constructor which launch parser
    *
    * @see Parser#Parser()
    * @see Parser#Parser(String[] args)
    */
    public Parser() {
        this.parse();
    }

    /**
    * Second Parser constructor which launch parser
    * after setting related attributes
    *
    * @param _resource
    *                  to set resource path
    *
    * @see Parser#argFiles
    * @see Parser#auto
    * @see Parser#resource
    * @see Parser#Parser()
    * @see Parser#Parser(String[] args)
    */
    public Parser(String _resource) {
        this.resource = _resource;
        this.parse();
    }

    /**
    * Third Parser constructor which launch parser
    * after setting related attributes
    *
    * @param args
    *               Files arguments passed as paramareter
    *
    * @see Parser#argFiles
    * @see Parser#auto
    * @see Parser#resource
    * @see Parser#Parser()
    * @see Parser#Parser(String[] args)
    */
    public Parser(String[] args) {
        this.argFiles = args;
        this.auto = false;
        this.resource = "/";
        this.parse();
    }

    /**
    * Parse related json files and store
    * them as Objects Array to work with
    *
    * @see Parser#data
    * @see Parser#files
    * @see Parser#filename
    * @see Parser#resource
    * @see Parser#Parser()
    * @see Parser#Parser(String[] argv)
    * @see Parser#build()
    * @see Parser#isFormated()
    * @see Infos#Infos()
    */
    protected void parse() {
        String    string = this.resource;
        File      file = new File(string);
        File[]    arrfile = file.listFiles();

        this.files = arrfile;
        this.data = new Infos[this.getSize()];

        for (File file2 : arrfile) {
            string = "";
            if (!file2.isFile()) continue;
            this.filename = string = this.getResource() + file2.getName();
            if (!this.isFormated() || !this.build()) continue;
            ++this.objId;
        }
    }

    /**
    * Builds Infos object following json file
    *
    * @throws IOException if any json file is badly formated
    *
    * @return bool type following success or failure of each
    *         Infos objects built
    *
    * @see Parser#filename
    * @see Parser#data
    * @see Parser#objId
    * @see Parser#parse()
    * @see Parser#Parser()
    * @see Parser#Parser(String[] argv)
    * @see Infos#Infos()
    */
    protected boolean build() {
        try {
            Infos           infos;
            Gson            gson = new Gson();
            BufferedReader  bufferedReader = new BufferedReader(new FileReader(this.getFilename()));

            this.data[this.getObjId()] = infos = (Infos)gson.fromJson((Reader)bufferedReader, Infos.class);
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    /**
    * Computes how many files are stored
    *
    * @return number of files from array
    *
    * @see Parser#files
    * @see Parser#parse()
    */
    public int getSize() {
        int n = 0;
        for (File file : this.getFiles()) {
            ++n;
        }
        return n;
    }

    /**
    * Check if current file is well formated
    * first following by his own format
    *
    * @return true or false following file format
    *
    * @see Parser#filename
    * @see Parser#parse()
    */
    protected boolean isFormated() {
        String[] arrstring;

        for (String string : arrstring = this.filename.split("\\.")) {
            if (!string.equals(this.getFormat())) continue;
            return true;
        }
        return false;
    }

    /**
    * Get id of current object
    *
    * @return objId attribute
    *
    * @see Parser#objId
    */
    public int getObjId() {
        return this.objId;
    }

    /**
    * Get boolean auto value
    *
    * @return auto attribute
    *
    * @see Parser#auto
    */
    public boolean getAuto() {
        return this.auto;
    }

    /**
    * Get file format autorized
    *
    * @return format attribute
    *
    * @see Parser#auto
    */
    public String getFormat() {
        return this.format;
    }

    /**
    * Get Infos array data from files parsed
    *
    * @return data attribute
    *
    * @see Parser#data
    */
    public Infos[] getData() {
        return this.data;
    }

    /**
    * Get array of files given as arguments
    *
    * @return argFiles attribute
    *
    * @see Parser#argFiles
    */
    public String[] getArgFiles() {
        return this.argFiles;
    }

    /**
    * Get files read
    *
    * @return files attribute
    *
    * @see Parser#files
    */
    public File[] getFiles() {
        return this.files;
    }

    /**
    * Get current filename to parse
    *
    * @return filename attribute
    *
    * @see Parser#filename
    */
    public String getFilename() {
        return this.filename;
    }

    /**
    * Get repository source to parse files
    *
    * @return resource attribute
    *
    * @see Parser#resource
    */
    public String getResource() {
        return this.resource;
    }
}
