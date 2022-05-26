#include "item.h"

item::item(QString description)
{
    this->description = description;
}
QString item::getDescription()   {
    return this->description;
}

