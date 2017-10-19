# @Description:         This script would to open javadoc from mainstream firefox browser
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            open.javadoc.sh
# @Date:                2017-10-19T15:10:34+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-19T15:10:57+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

# launch firefox
firefox $pwd/resources/javadoc/www/index.html
