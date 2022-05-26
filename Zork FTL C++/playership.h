#ifndef PLAYERSHIP_H
#define PLAYERSHIP_H

#include <QString>
#include <string>
using namespace std;
#include <vector>
using std::vector;

#include "item.h"
#include "ship.h"

class playerShip : public ship
{
public:
    playerShip(int health, int shield, int atkDmg, int shieldDef);
    void addItems(item item);
    QString getInventoryDescription();
    vector<item> getInventory();


private:
    vector<item> inventory;
};

#endif // PLAYERSHIP_H
