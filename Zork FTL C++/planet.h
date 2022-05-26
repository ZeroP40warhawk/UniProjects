#ifndef PLANET_H
#define PLANET_H

#include <map>
#include <vector>
#include <QString>
#include "item.h"
#include "enemyship.h"
#include "spacestation.h"
#include "planet.h"

class planet
{
public:
    planet(QString description);
    void addEnemyShip(enemyShip enemy);
    bool isEnemyInRoom();
    enemyShip getEnemy();
    void addSpaceStation(spaceStation station);
    bool isSpaceStationInRoom();
    spaceStation getSpaceStation();
    void setExits(planet *north, planet *east, planet *south, planet *west);
    QString shortDescription();
    QString longDescription();
    planet* nextPlanet(QString direction);
    int numberOfItems();
    void addItem(item inItem);
    QString displayItem();
    int isItemOnPlanet(QString inString);
    void removeItemFromPlanet(int location);

private:
    QString description;
    map<QString, planet*> exits;
    QString exitString();
    vector <item> itemsOnPlanet;
    vector <enemyShip> enemy;
    vector <spaceStation> station;
    bool activeEnemy;
    bool activeStation;
};

#endif // PLANET_H
