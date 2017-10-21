# @Description:         This script would to create a javadoc of Trojan/ repository
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            make.javadoc.sh
# @Date:                2017-10-19T15:12:01+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-20T19:18:22+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

# clear resources/javadoc repository
./resources/bin/clear.javadoc.sh

# import new java sources
cp -r $pwd/Trojan/* $pwd/resources/javadoc/

# create needed resources/javadoc repositories
mkdir $pwd/resources/javadoc/www/
mkdir $pwd/resources/javadoc/tar/

# execute javadoc program
javadoc -d $pwd/resources/javadoc/www/ -cp '.:resources/lib/gson-2.8.0.jar:resources/lib/json-20140107.jar:resources/lib/httpcore-4.4.7.jar:resources/lib/httpclient-4.5.3.jar:resources/lib/commons-logging-1.2.jar' $pwd/resources/javadoc/JTrojan.java $pwd/resources/javadoc/*/**.java

# create .tar file containing new javadoc files to export it easily
tar -cf $pwd/resources/javadoc/tar/JTrojan.javadoc.tar $pwd/resources/javadoc/www/*

# remove all copied .java source files
rm -r $pwd/resources/javadoc/JTrojan.java
rm -r $pwd/resources/javadoc/Connect
rm -r $pwd/resources/javadoc/Install
rm -r $pwd/resources/javadoc/Tools
rm -r $pwd/resources/javadoc/Transfert
