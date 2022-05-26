
from tale.base import Location, Item
from NPCs.Orangutan_npc import Orangutan

#defining the locations
#----Library

library = Location("The Library",
                   "The library contains hundreds of volumes from everywhere point in time. "
                   "Time and Space is warped because of the Library being in L-space. "
                   "A wizard can enter one library and exit in another. "
                   "All of the volumes are chained to the shelves to protect the students from the books. "
                   "The Orangutan that swings from shelf to shelf is the librarian. "
                   "He was one of the professors that had been accidently transformed but now doesn't wish to be transformed back as the advantages of being an orangutan.")

#----Orangutan
#setting up the npc object and adding to the location
orangutan = Orangutan("Orangutan",
                      "m",
                      title = "Orangutan",
                      descr = "The Orangutan is the universities Librarian. He was a professor that was accidentally changed to an Orangutan."
                              "He chose to stay as an Orangutan as it was quite useful.")

library.init_inventory([orangutan])

#----req scroll
#giving the npc their item
oranScroll = Item("orangutans requirement scroll",
                    "Orangutans Requirement Scroll",
                    descr="Orangutan requires the staff to measure magic levels in the area.")
oranScroll.aliases = {"Requirements Scroll", "Scroll", "Orangutans Scroll"}
orangutan.init_inventory([oranScroll])