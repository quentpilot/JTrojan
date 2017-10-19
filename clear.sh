# @Description:         This script would to clear all .class files and other file data
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            clear.sh
# @Date:                2017-10-19T15:07:09+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-19T16:21:07+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

rm $pwd/Trojan/*/**.class
rm $pwd/resources/dump/*.data
rm $pwd/resources/infos/*.json
