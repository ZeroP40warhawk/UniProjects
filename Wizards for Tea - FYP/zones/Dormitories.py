
from tale.base import Location, Exit, Item

#defining the locations
#----Dormitory

dormitory = Location("The Dormitory",
                     "The dormitories where all the student wizards reside. They infinitely expand to add more rooms as new wizards arrive.")

#----Kitchen

kitchen = Location("The Kitchen",
                   "The kitchen is directly beside the dormitories so students can feed themselves at any time of day. "
                   "In the case of some they have taken up permanent residency here.")

#----Door to the kitchen
#defining the exits to the locations
Exit.connect(dormitory,
             ["Kitchen"],
             "The <bright>Kitchen</> is directly beside the dormitories so students are never left hungry.",
             None,
             kitchen,
             ["dormitory"],
             "The kitchen leads back to the <bright>Dormitories</>.",
             None)

#----cheese for the computer
#adding item to a location
cheese =  Item("cheese", "Block of Cheese",
               descr= "A block of rather smelly cheese.")
cheese.aliases = {"cheese", "smelly cheese"}
kitchen.init_inventory([cheese])
