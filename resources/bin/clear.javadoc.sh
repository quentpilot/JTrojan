# @Description:         This script would to remove all javadoc files
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            clear.javadoc.sh
# @Date:                2017-10-19T15:12:29+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-19T16:42:02+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

# clear resources/javadoc repository
rm -r $pwd/resources/javadoc/www/
