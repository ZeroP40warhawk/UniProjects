#ifndef SPACESTATION_H
#define SPACESTATION_H

#include <vector>
#include "item.h"
#include "ship.h"

class spaceStation: public ship
{
public:
    spaceStation(int health, int shield, int atkDmg, int shieldDef, item aItem);
    item getItem();

private:
    vector<item> items;
};

#endif // SPACESTATION_H
