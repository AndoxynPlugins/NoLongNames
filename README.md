NoLongNames - Bukkit plugin request
=========================
Features
========
* Kicks all players on join who have a username that is longer than a specified length.

Commands
========
* /reloadnlnl - Reloads the configuration file.

Permissions
===========
* nolongnames.reload - Allows the user of /reloadnln

Configuration
=============
config.yml contains two values:
* maxnamelength:
 * Description: kick players who have names longer than this length.
 * Type: Integer

* kickmessage:
 * Description: Message to display when kicking players.
 * Type: String
