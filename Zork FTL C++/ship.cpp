#include "ship.h"

ship::ship(int health, int shield, int atkDmg, int shieldDef)
{
    this->health = health;
    this->shield = shield;
    this->atkDmg = atkDmg;
    this->shieldDef = shieldDef;
}
int ship::getHealth() {
    return this->health;
}
int ship::getShield()  {
    return this->shield;
}
int ship::getAtkDmg()   {
    return this->atkDmg;
}
int ship::getShieldDef()    {
    return this->shieldDef;
}
bool ship::isAlive()    {
    if(this->health > 0)
        return true;
    else
        return false;
}
void ship::setHealth(int health)    {
    this->health = health;
}

void ship::setShield(int shield)    {
    this->shield = shield;
}

void ship::setAtkDmg(int atkDmg)    {
    this->atkDmg = atkDmg;
}

void ship::setShieldDef(int shieldDef)  {
    this->shieldDef = shieldDef;
}

