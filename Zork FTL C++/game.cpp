#include "game.h"
#include "ui_game.h"

#include <QDebug>

Game::Game(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Game)
{
    ui->setupUi(this);
    startGame();
}

Game::~Game()
{
    delete ui;
}

void Game::startGame(){
    createPlanets();
    setupPlayer();
    printWelcome();
    displayPlayer();

}
void Game::printWelcome(){
    ui->textBrowser->append(">start\n>info for help");
    ui->textBrowser->append(currentPlanet->longDescription());
    ui->textBrowser_2->append(currentPlanet->shortDescription());
    ui->textBrowser_4->append(currentPlanet->shortDescription());
}
void Game::printHelp()  {
    temp = ">valid inputs are ";
    temp += parser.showCommands();
    ui->textBrowser->append(temp);
}
void Game::setupPlayer()    {
    player = new playerShip(100, 25, 15, 10);
}
void Game::displayPlayer()  {
    temp = ">Player Stats: Health:" + QString::number(player->getHealth()) + " Shields: " + QString::number(player->getShield());
    ui->textBrowser->append(temp);
    ui->shipHealth->display(player->getHealth());
    ui->shipShield->display(player->getShield());
}

void Game::goRoom(Command command)  {
    if(!command.hasSecondWord())    {
        temp = ">incomplete input\n";
        ui->textBrowser->append(temp);
        return;
    }

    QString direction = command.getSecondWord();

    planet* nextPlanet = currentPlanet->nextPlanet(direction);

    if(nextPlanet == NULL){
        temp = ">undefined input";
        ui->textBrowser->append(temp);
    }
    else    {
        currentPlanet = nextPlanet;
        temp = currentPlanet->longDescription();
        ui->textBrowser->append(temp);
        ui->textBrowser_2->clear();
        ui->textBrowser_2->append(currentPlanet->shortDescription());
        ui->textBrowser_4->clear();
        ui->textBrowser_4->append(currentPlanet->shortDescription());
        displayPlayer();
    }
}

void Game::createPlanets()  {

       planet *rorysSheepPlanet = new planet("Rorys Sheep Planet");
       planet *lorrainesPlanet = new planet("Lorraines Planet");
       planet *notGavinsPlanet = new planet("Not Gavins Planet");
       planet *planetXavier = new planet("Planet Xavier");
       planet *frozenPlanet = new planet("Frozen Planet");
       planet *planetLeprachaun = new planet("Planet of the Leprachauns");
       planet *planetLandMine = new planet("Planet of Land Mines");
       planet *planetOfFreedom = new planet("Planet of Freedom Bringers");
       planet *planetOfOverWorked = new planet("Planet of the Overworked Students");
       planet *moltenPlanet = new planet("Molten Planet");
       planet *ghastlyPlanet = new planet("Ghastly Planet");
       planet *planetPokemans = new planet("Planet PokeMans");
       planet *planetRascallyRabbits = new planet("Planet of the Rascally Rabbits");
       planet *bikerPlanet = new planet("Real Riders Planet");
       planet *catsMeowPlanet = new planet("Cats Meow Planet");
       planet *memeLordsPlanet = new planet("Meme Lords Planet");

       rorysSheepPlanet->setExits(NULL, lorrainesPlanet, NULL, NULL);
       lorrainesPlanet->setExits(notGavinsPlanet, frozenPlanet, NULL, rorysSheepPlanet);
       notGavinsPlanet->setExits(NULL, NULL, lorrainesPlanet, NULL);
       frozenPlanet->setExits(planetXavier, planetLeprachaun, NULL, lorrainesPlanet);
       planetXavier->setExits(NULL,NULL,frozenPlanet,NULL);
       planetLandMine->setExits(NULL,planetLeprachaun,ghastlyPlanet, moltenPlanet );
       planetLeprachaun->setExits(NULL,frozenPlanet,planetOfFreedom,planetLandMine);
       planetOfOverWorked->setExits(NULL,NULL,moltenPlanet,NULL);
       planetPokemans->setExits(ghastlyPlanet,NULL,NULL,NULL);
       planetRascallyRabbits->setExits(NULL,memeLordsPlanet,bikerPlanet,moltenPlanet);
       catsMeowPlanet->setExits(bikerPlanet,NULL,NULL,NULL);
       planetOfFreedom->setExits(planetLeprachaun, ghastlyPlanet,NULL,NULL);
       moltenPlanet->setExits(planetOfOverWorked,planetRascallyRabbits,NULL,planetLandMine);

       currentPlanet = rorysSheepPlanet;
       jumpD = "jump";
       north = "north";
       east = "east";
       south = "south";
       west = "west";
}

bool Game::processCommand(Command command) {
    if (command.isUnknown()) {
        temp = ">invalid input\n";
        ui->textBrowser->append(temp);
        return false;
    }
    QString commandWord = command.getCommandWord();
    if (commandWord.compare("info") == 0)
        printHelp();

    else if (commandWord.compare("map") == 0)
        {
        map =        ("       []            []                   []\n"
                      "        |             |                    |\n"
                      "        |             |                    |\n"
                      "[] --- [] --- [] --- [] --- [] --- [] --- [] --- [] --- []\n"
                      "                             |      |             |\n"
                      "                             |      |             |\n"
                      "                            [] --- []            []\n"
                      "                                    |             |\n"
                      "                                    |             |\n"
                      "                                   []            []\n");
        ui->textBrowser->append(map);
        }

    else if (commandWord.compare("jump") == 0)
        goRoom(command);

    else if (commandWord.compare("take") == 0)
    {
        if (!command.hasSecondWord()) {
            temp = ">incomplete input\n";
            ui->textBrowser->append(temp);
        }
        else
            if (command.hasSecondWord()) {
                temp = ">you're trying to take ";
                temp += command.getSecondWord() + "\n";
                ui->textBrowser->append(temp);

                int location = currentPlanet->isItemOnPlanet(command.getSecondWord());
            if (location  < 0 ) {
                ui->textBrowser->append(">item is not on the planet");
            }
            else{
                temp = ">item is on the planet\n>index number " + QString::number(location) + "\n>";
                temp += currentPlanet->longDescription() + "\n";
                ui->textBrowser->append(temp);
            }
        }
    }
    else if (commandWord.compare("put") == 0)
    {

    }
    /*
    {
    if (!command.hasSecondWord()) {
        cout << "incomplete input"<< endl;
        }
        else
            if (command.hasSecondWord()) {
            cout << "you're adding " + command.getSecondWord() << endl;
            itemsInRoom.push_Back;
        }
    }
    */
    else if (commandWord.compare("quit") == 0) {
        if (command.hasSecondWord())    {
            temp = ">overdefined input\n";
            ui->textBrowser->append(temp);
        }
        else
            return true; /**signal to quit*/
        }
        return false;

}

void Game::on_lineEdit_returnPressed()
{
    temp = ">";
    ui->textBrowser->append(temp + ui->lineEdit->text());
    temp = ui->lineEdit->text();
    command = parser.getCommand(temp);
    processCommand(*command);
    ui->lineEdit->clear();
    delete command; //free memory
}

void Game::on_sheepPlanet_released()
{
    qDebug() << "Rory's got sheep on his planet";
}

void Game::on_LorrainesPlanet_released()
{

}

void Game::on_rascallyRabbits_released()
{

}

void Game::on_notGavinsPlanet_released()
{

}

void Game::on_Xavier_released()
{

}

void Game::on_frozenPlanet_released()
{

}

void Game::on_leprachauns_released()
{

}

void Game::on_freedomBringer_released()
{

}

void Game::on_landmines_released()
{

}

void Game::on_ghastlyPlanet_released()
{

}

void Game::on_planetPokeMans_released()
{

}

void Game::on_moltenPlanet_released()
{

}

void Game::on_overWorkedStudents_released()
{

}

void Game::on_realRiders_released()
{

}

void Game::on_catsMeow_released()
{

}

void Game::on_memeLord_released()
{

}

void Game::on_jumpNorthBtn_released()
{
    Command jumpNorth(jumpD, north);
    processCommand(jumpNorth);
}

void Game::on_jumpWestBtn_released()
{
    Command jumpWest(jumpD, west);
    processCommand(jumpWest);
}

void Game::on_jumpEastBtn_released()
{
    Command jumpEast(jumpD, east);
    processCommand(jumpEast);
}

void Game::on_jumpSouthBtn_released()
{
    Command jumpSouth(jumpD, south);
    processCommand(jumpSouth);
}

void Game::on_atkBtn_released()
{

}

void Game::on_shieldBtn_released()
{

}

void Game::on_pushButton_released()
{

}

void Game::on_pushButton_2_released()
{

}

void Game::on_invenBtn_released()
{

}
