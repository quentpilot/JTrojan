# @Description:         Tjis script would to save current Java sources files in resources/backup
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            backup.sh
# @Date:                2017-10-20T18:52:06+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-21T12:41:16+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


# get current path
pwd=$(pwd)

# clear old backup
./resources/bin/backup.clear.sh

# create new tmp repository
mkdir $pwd/resources/backup/tmp/

# copy new java sources
cp -r Trojan/ resources/backup/tmp

# then copy new resources files
cp -r resources/ resources/backup/tmp

# create Java sources archive
tar -cvf resources/backup/JTrojan.sources.tar resources/backup/tmp/*

# then remove temporary files
rm -r $pwd/resources/backup/tmp/
