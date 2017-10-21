# @Description:         This script would to compile then execute Trojan project
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            make.sh
# @Date:                2017-10-19T15:04:48+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-20T19:36:18+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

# compile all sources files with related .jar files
javac -cp '.:resources/lib/gson-2.8.0.jar:resources/lib/json-20140107.jar:resources/lib/httpcore-4.4.7.jar:resources/lib/httpclient-4.5.3.jar:resources/lib/commons-logging-1.2.jar' $pwd/Trojan/*/**.java $pwd/Trojan/JTrojan.java

# execute main java class
java -cp '.:resources/lib/gson-2.8.0.jar:resources/lib/json-20140107.jar:resources/lib/httpcore-4.4.7.jar:resources/lib/httpclient-4.5.3.jar:resources/lib/commons-logging-1.2.jar' Trojan.JTrojan $*
