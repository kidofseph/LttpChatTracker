-------Intro-------

Welcome to KidofSeph's LttP Randomizer Tracker (Trademark, Copyright, Patent Pending, etc)!

Thank you for trusting my programming skills. This is currently a very simple Tracking program. There is 
no customization, everything is how it looks. In future releases of this, I plan on building a 
customizable interface.

If you monitor your IRC list, you'll see a new user named "botofseph". Don't worry, this is fine. The 
tracker uses Twitch's IRC client to update the items. Currently, only moderators of the channel can 
update the items that have been found. This is mainly to eliminate chat spam. Items are initially greyed
out, as you typically see with other tracking programs. As the items are found (and mods type the correct
text in chat), they will light up. Did you find a sword and you're afraid two mods will both go to update
it at the same time? Have no fear! There is a 15 second cooldown on each item. This prevents two mods from
updating the same item and making it appear that you have a different item.



-------Usage-------

To use the tracker, simply open the .jar file. Since the username is currently hardcoded in the application,
it will automatically join your chat. For the mapping of the items, see the section below.

When you have found an item, a mod should type in your chat:

!up [item]

!up [dungeon] [reward]

If a mod mistakenly entered that you found an item, just have them type:

!down [item]

This will grey out non-upgradable items, or lower the upgraded item by one. If the upgradable item is the
basic level, the item will become greyed out.

!set [medallion] [dungeon]

This will set the medallion note that it is required to open a certain dungeon. The abbreviation for the
dungeon should be used (MM, TR). If both dungeons require the same, use "2" as the dungeon.


-------Item Mapping-------

This is probably THE MOST IMPORTANT PART (next to the syntax, of course). The tracker doesn't work on
"almost correct", so it may be wise to distribute this list to your moderators. It is not case
sensitive, but the item name must be typed as it is in the mapping. Most of them are self-explanatory,
but for consistency's sake I've spelled out everything. Upgradable items will automatically go to the
next upgrade.


LttP Name          |          Tracker Name

---Items---
Bow                |          Bow
Silver Arrows      |	      Silver
Hammer             |	      Hammer
Hookshot           |	      Hookshot
Fire Rod           |	      FireRod
Lantern            |	      Lantern
Cane of Somaria    |	      Somaria
Sword              |	      Sword
(all swords obtained are considered an upgrade)
Shield             |	      Shield
(all shields obtained are considered an upgrade)
Tunic              |	      Tunic
(all tunics obtained are considered an upgrade)
Bottle		   |	      Bottle
(all bottles obtained are considered an upgrade. After the 4th bottle, 
 upgrade progression is Red, Green, Blue, Fairy if you choose to track)
Net                |	      Net
Cane of Byrna      |	      Byrna
Boomerang          |	      Boomerang
(all boomerangs obtained are considered an upgrade)
Book of Mudora     |	      Book
Shovel             |	      Shovel
Flute              |	      Flute
Ice Rod            |	      IceRod
Mushroom           |	      Mushroom
Magic Powder       |	      Powder
Magic Cape         |	      Cape
Flippers           |	      Flippers
Boots              |	      Boots
Glove              |	      Glove
(all gloves obtained are considered upgrades)
Bombos Medallion   |	      Bombos
Ether Medallion    |	      Ether
Quake Medallion    |   	      Quake
Pendant of Courage |          PendantCourage
Pendant of Power   |          PendantPower
Pendant of Wisdom  |          PendantWisdom
Moon Pearl         |          Pearl
Mirror             |          Mirror
Agahnim            |          Agahnim

---Dungeons---
Eastern Palace     |          EP
Desert Palace	   |	      DP
Tower of Hera      |	      TOH
Palace of Darkness |	      POD
Swamp Palace       |	      SP
Skull Woods	   |	      SW
Thieves Town	   |	      TT
Ice Palace	   |	      IP
Misery Mire	   |	      MM
Turtle Rock	   |	      TR

---Rewards---
Blue/Red Pendant   |	      Pendant
Green Pendant	   |	      Pendant+
Crystal		   |	      Crystal
Crystal+	   |	      Crystal+
(replace # with the number associated to that obtained)