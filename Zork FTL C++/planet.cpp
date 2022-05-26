#include "planet.h"
#include "spacestation.h"

planet::planet(QString description)
{
    this->description = description;
    this->activeEnemy = false;
    this->activeStation = false;
}
void planet::addEnemyShip(enemyShip enemy)
{
    this->enemy.push_back(enemy);
    this->activeEnemy = true;
}

bool planet::isEnemyInRoom() {
    return this->activeEnemy;
}
enemyShip planet::getEnemy()    {
    return this->enemy[0];
}
void planet::addSpaceStation(spaceStation station)  {
    this->station.push_back(station);
    this->activeStation = true;
}
bool planet::isSpaceStationInRoom() {
    return this->activeStation;
}
spaceStation planet::getSpaceStation()  {
    return this->station[0];
}
void planet::setExits(planet *north, planet *east, planet *south, planet *west) {
    if (north != NULL)
        exits["north"] = north;
    if (east != NULL)
        exits["east"] = east;
    if (south != NULL)
        exits["south"] = south;
    if (west != NULL)
        exits["west"] = west;
}
QString planet::shortDescription(){
    return this->description;
}
QString planet::longDescription()    {
    return ">Planet = " + description + ".\n" + displayItem() + exitString();
}
QString planet::displayItem()    {
    QString tempString = ">items in room = ";
    int sizeItems = (itemsOnPlanet.size());
    if (itemsOnPlanet.size() < 1) {
        tempString = ">no items in room\n";
        }
    else if (itemsOnPlanet.size() > 0) {
       int x = (0);
        for (int n = sizeItems; n > 0; n--) {
            tempString += tempString + itemsOnPlanet[x].getDescription() + "  " ;
            x++;
            }
        }
    return tempString;
}
QString planet::exitString() {
    QString returnString = ">exits =";
    for (map<QString, planet*>::iterator i = exits.begin(); i != exits.end(); i++)
        // Loop through map
        returnString += "  " + i->first;	// access the "first" element of the pair (direction as a string)
    return returnString;
}
int planet::isItemOnPlanet(QString inString) {
    int sizeItems = (itemsOnPlanet.size());
    if (this->itemsOnPlanet.size() < 1) {
        return false;
        }
    else if (itemsOnPlanet.size() > 0) {
       int x = (0);
        for (int n = sizeItems; n > 0; n--) {
            // compare inString with short description
            int tempFlag = inString.compare( itemsOnPlanet[x].getDescription());
            if (tempFlag == 0) {
                itemsOnPlanet.erase(itemsOnPlanet.begin()+x);
                return x;
            }
            x++;
            }
        }
    return -1;
}
void planet::removeItemFromPlanet(int location) {
    itemsOnPlanet.erase(itemsOnPlanet.begin()+location);
}
int planet::numberOfItems() {
    return itemsOnPlanet.size();
}
void planet::addItem(item inItem)  {
    this->itemsOnPlanet.push_back(inItem);
}
planet* planet::nextPlanet(QString direction)   {
    map<QString, planet*>::iterator next = exits.find(direction); //returns an iterator for the "pair"
    if (next == exits.end())
        return NULL; // if exits.end() was returned, there's no room in that direction.
    return next->second; // If there is a room, remove the "second" (Room*)
                // part of the "pair" (<string, Room*>) and return it.
}
