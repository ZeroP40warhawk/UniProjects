
from tale.base import Location, Exit
from zones.University_Gardens import university_gardens

#--BoatHouse

#defining the location
boathouse = Location("Boat House", "The boat house is the main entrance to the university for most travellers. Various ships and yachts are docked in the piers.")
#defining the exits to the location
Exit.connect(boathouse,
             ["gardens", "garden","university gardens", "outside"],
             "The boat house sits on the river that runs along the southern part of the university. "
             "It leads you into the <bright>University Gardens</>.",
             None,
             university_gardens,
             ["boat house", "boats", "yachts", "ships", "boathouse"],
             "The <bright>Boat House</> is a large wooden building sitting on the banks of the river. "
             "Numerous boats and shipts are docked in the piers."
             , None)
