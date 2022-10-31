# 1. Hodina
Cvičení na object's reflextion. Do souborů, které jsou v cz.spsmb.source nezapisujte!
Vytvořte třídu ProgramScanner, bude mít tyto metody:

 - Získá přihlašovací údaje z instance třídy PrivateField
 - Vypíše jaké jsou veřejné a privátní metody ve třídě DeclaredMethodList
 - Vytvoří několik instancí třídy Singleton

Po kontrole opravte kód ve třídě Singleton tak, aby to bylo správně.
Tj. aby byla pouze jedna jediná instance této třídy.

# Bonusová úloha
Posledním úkolem je hacknout licenční server. V reálu to asi nebude takto jednoduché, ale
principiálně to bude podobné.

Předpokládejme, že máte nelegální kopii a v programu se nachází tato třída kontrolující
vaši licenci. Licence je platná pokud server dokomunikuje na daný server a server vratí v HTTP status 200.
Vaším úkolem je donutit tuto tuto třídu vracet true, tak aby po zavolání Licence.startGame() program vypsal "Starting game".

Platí to samé jako v příkladech výše. Nesmíte upravovat žádný kód ve třídě LicenceServer.
