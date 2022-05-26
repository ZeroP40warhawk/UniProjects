#include "spacestation.h"

spaceStation::spaceStation(int health, int shield, int atkDmg, int shieldDef, item aItem):ship(health, shield, atkDmg, shieldDef)
{
    this->items.push_back(aItem);
}
item spaceStation::getItem()    {
    return this->items[0];
}
