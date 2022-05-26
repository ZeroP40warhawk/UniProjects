#ifndef ENEMYSHIP_H
#define ENEMYSHIP_H

#include "ship.h"

class enemyShip: public ship
{
public:
    enemyShip(int health, int shield, int atkDmg, int shieldDef);
};

#endif // ENEMYSHIP_H
