#include "playership.h"

playerShip::playerShip(int health, int shield, int atkDmg, int shieldDef): ship(health, shield, atkDmg, shieldDef)
{

}
void playerShip::addItems(item item)    {
    this->inventory.push_back(item);
}
vector<item> playerShip::getInventory() {
    return this->inventory;
}
QString playerShip::getInventoryDescription()   {
    QString tempQstr;
    string temp;
    if(this->inventory.size() == 0){
        tempQstr = "No items in your inventory\n";
        return tempQstr;
    }
    else
    {
        tempQstr = "Inventory: \n";
        unsigned int i;
        for(i = 0; i < this->inventory.size(); i++)
        {
            tempQstr += inventory[i].getDescription() + "\n";
        }
        tempQstr += QString::fromUtf8(temp.data(), temp.size());
        return tempQstr;
    }
    return tempQstr;
}

