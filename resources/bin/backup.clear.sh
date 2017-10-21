# @Description:         Object class would to do some stuff
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            backup.clear.sh
# @Date:                2017-10-20T19:08:49+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-20T19:09:09+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

# remove previous backup
rm -r $pwd/resources/backup/*
