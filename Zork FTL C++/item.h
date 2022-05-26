#ifndef ITEM_H
#define ITEM_H

#include <QString>
#include <iostream>
using namespace std;

class item
{
public:
    item(QString description);
    QString getDescription();

private:
    QString description;
};

#endif // ITEM_H
