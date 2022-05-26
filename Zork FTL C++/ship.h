#ifndef SHIP_H
#define SHIP_H


class ship
{
public:
    ship(int health, int shield, int atkDmg, int shieldDef);
    void setHealth(int health);
    void setShield(int shield);
    void setAtkDmg(int atkDmg);
    void setShieldDef(int shieldDef);

    bool isAlive();

    int getHealth();
    int getShield();
    int getAtkDmg();
    int getShieldDef();


private:
    int health;
    int shield;
    int atkDmg;
    int shieldDef;
};

#endif // SHIP_H
