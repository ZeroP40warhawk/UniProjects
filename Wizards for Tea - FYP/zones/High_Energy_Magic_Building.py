
from zones.Dormitories import dormitory
from NPCs.Eskarina_Smith_npc import eskarinaSmith
from NPCs.Pondor_S_npc import pondorStibbons
from NPCs.Hex_npc import hex

from tale.base import Location, Exit, Item

#defining the location
#----High Energy Building

highEnergyBuilding = Location("The High Energy Magic Building",
                              "The testing grounds for splitting the Thaum particle. "
                              "The test room has many layers of octiron walls to protect the outside world from runaway experiments.")

#----High Energy Building Test Hall

testHall = Location("Test Hall",
                    "The testing hall has thick walls infused with octiron to contain any runaway magical experiments.")

#----Hex Mainframe Room

hexMainframeRoom = Location("The Hex Mainframe",
                            "The Hex mainframe is the universities mainframe maintained by Pondor Stibons. "
                            "The mainframe is made up of millions of ants that process data that is inputed into it. "
                            "It expands itself over time and has become increasingly powerful.")

#----Pondor Stibbons Office

stibbonOffice = Location("Pondor Stibbons Office",
                         "Pondor Stibbons office is lined wall to wall with shelves. "
                         "All sorts of magical items and tomes sit on the shelves. "
                         "Stibbons is the only professor in the university that knows what is going on much to his displeasure.")

#defining the exits to the locations
#----Door to Pondor Stibbons Office

Exit.connect(highEnergyBuilding,
             ["office", "pondor stibbons office"],
             "At the end of the hall is <bright>Pondor Stibbons Office</>.",
             None,
             stibbonOffice,
             ["high energy magic building", "magic building", "hallway"],
             "The hall of the <bright>High Energy Magic Building</> is outside.",
             None)

#----Door to Test Hall

Exit.connect(highEnergyBuilding,
             ["hall", "test hall", "high energy test hall"],
             "The door to the <bright>High Energy Test Hall</> stands in front of you. The door looks rather large and heavy.",
             None,
             testHall,
             ["magic building", "high energy magic building", "hallway"],
             "Outside the thick walls of the testing room is the hallway of the <bright>High Energy Magic Building</>.",
             None)

#----Door to the Mainframe

Exit.connect(highEnergyBuilding,
             ["mainframe", "hex mainframe", "mainframe room"],
             "The door to the <bright>Hex Mainframe</> you can hear the sound of a million tiny legs scuttling away inside.",
             None,
             hexMainframeRoom,
             ["magic building", "high energy magic building", "hallway"],
             "Outside the mainframe room is the hallway to the <bright>High Energy Magic Building</>.",
             None)

#----Door to the dormitories

Exit.connect(highEnergyBuilding,
             ["dormitory"],
             "The <bright>Dormitory</> leads into the high energy magic building so that students can start experimenting as soon as they feel like getting up.",
             None,
             dormitory,
             ["magic building", "high energy magic building", "hallway"],
             "Next to the dormitory is the <bright>High Energy Magic Building</> where many unfortunate discoveries are made about spells gone awry.",
             None)


#----NPC
#adding the npcs to their locations
#----Eskarina Smith in the Test Hall
eskarinaS = eskarinaSmith("Eskarina Smith", "f", title = "Eskarina Smith", descr = "Eskarina Smith a powerful wizard and one of the few female wizards in Discworld.")

eskarinaS.aliases = {"Eskarina Smith", "Miss Smith", "Eskarina"}

testHall.init_inventory([eskarinaS])

#----Pondor Stibbons in his Office

pondorS = pondorStibbons("Pondor Stibbons", "m", title="Pondor Stibbons", descr = "Pondor Stibbons the only professor in the university that knows whats going on. Much to his misfortune.")

pondorS.aliases = {"Pondor", "Prof Stibbons"}

stibbonOffice.init_inventory([pondorS])

#----Hex the mainframe in his room

hexMainframe = hex("Hex",
                   "m",
                   title="Hex",
                   descr="Hex the universities mainframe. Anthill inside and also a mouse nest of glass tubes. "
                   )

hexMainframeRoom.init_inventory([hexMainframe])

#----Scrolls with the requirements for each wizard
#giving the npcs their items
#---Pondors requirements scrolls

pondorScroll = Item("Pondors Requirement Scroll",
                    "Pondors Requirement Scroll",
                    descr = "Pondor requires the staff to tell the caster how much magic they have left in their store.")
pondorScroll.aliases = {"Requirements Scroll", "Scroll", "Pondors Scroll"}
pondorS.init_inventory([pondorScroll])

#---Eskarinas Scroll

eskarinaScroll = Item("Eskarinas Requirement Scroll",
                      "Eskarinas Requirement Scroll",
                      descr= "Eskarina requires the staff to allow the user to remember the spells after they cast them.")

eskarinaScroll.aliases = {"Requirements Scroll", "Eskarinas Scroll", "Scroll"}
eskarinaS.init_inventory([eskarinaScroll])

#----Staff created by Hex

staff = Item("New Staff",
             "New Staff",
             descr="The new staff devised from the requirements you've given Hex.")

hexMainframe.init_inventory([staff])
