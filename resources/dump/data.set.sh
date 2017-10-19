# @Description:         This script would to get and store OS infos
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             JTrojan
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            data.set
# @Date:                2017-10-19T15:50:36+02:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-10-19T15:51:21+02:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/JTrojan


echo $USER > resources/dump/user_name.data
uname -n > resources/dump/host_name.data
uname -o > resources/dump/os_name.data
uname -s > resources/dump/os_arch.data
uname -r > resources/dump/os_version.data
