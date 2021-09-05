# Algorithms


Andreas Rud Zimmer, S344051

oppgave 1: Lagde return-metode for antall ved bruk av instansvariabelen antall, og brukte samme instansvariabel til å lage  tom-metoden. Lgde så DobbeltLenketListe(T[] a) metoden. Denne sjekker først om tabellen = null, så går det en for-løkke gjennom tabellen og sjekker etter null-verdier, disse vil ikke bli lagt til i den dobbelt lenkede listen, samt plassere verdiene fra hode til hale. 

oppgave 2: Brukte Stringbuilder her. Begynner med å sette en start-firkantet parantes i Stringen. Deretter sjekkes om listen er tom. Dersom den er det hopper metoden til siste steg og setter slutt-firkantet parantes. Dersom den ikke er tom benyttes en while-loop til å sette inn verdiene i listen til Stringbuilderen. omvendtString() ble lagd på lik måte, bare her fylles Stringen fra hale til hode. 

oppgave 3: finnNode. Her sjekkes først om noden befinner seg i første eller andre halvdel av listen utfran dens indeks. Dersom den er i første halvdel vil en for-løkke jobbe seg fra hode frem til noden. Dersom den befinner seg i andre halvdel vil en for-løkke jobbe seg fra hale til noden. Noden returneres. hent() sjekker først at indeksen er gyldig. Derretter returneres verdien til noden ved å bruke samme metoden finnNode(). Oppdater(): Her finner vi først verdien som skal oppdateres ved å bruke finnNode(). Metoden holder på denne verdien i T mid. Derretter setter vi verdien i listen lik verdien vi ønsker å sette inn. Til slutt returnerer vi T mid, som er den verdien vi byttet ut. subliste(): Her går jobber en for-løkke seg gjennom dobbeltlenketliste fra indeks(fra) til indeks(til). Metoden sjekker at fra > til. Derretter plasserer den verdiene med indekser mellom fra og til i en ny dobbeltlenketliste. 

oppgave 4: indeksTil(): Metoden setter først r = -1, så derom det ikke er noen slike verdier i listen vil denne returneres. Så jobber den seg gjennom en while-løkke og sjekker verdiene fra hode til hale. Dersom den finner en lik verdi vil denne bli returnert. Den teller også hvor mange av denne verdien den finner med i++.

oppgave 5: leggInn(): Sjekker først at indeksen er gyldig. Så sjekker den om verdien er gyldig. Derretter jobber den seg gjennom den debbelt lenkede listen og plasserer den i riktig indeks. Verdier med indeks etter denne vil bli flyttet +1. 

oppgave 6: boolean fjern(): Metoden går gjennom verdiene i listen. Sjekker om verdien ligger i hodet reller halen. Dersom den er det blir hode = hode.neste eller hale = hale.forrige. Dersom de ikke er der vil metoden finne noden med den verdien ved bruk av finnNode(). T fjern(): Sjekker først om indeksen er gyldig. Derretter vil den sile ut verdien med indeksen vi ønsker å fjerne. 

oppgave 8: T next(): Sjekker først om iterator er ulik endringer. Dersom den er det kaster den en ConcurrentModificationException. Så sjekker den om hasNext er ulik true. Dersom den er det kaster den en NoSuchElementException. Setter så fjernOk true og flyttes til neste node. Iterator<T> iterator(): Returnerer en instans av iterator-klassen. DobbeltLenketListeIterator(): Setter pekeren denne ved å bruke finnNode metoden. Iterator<T> iterator(int indeks): Sjekker at indeksen er lovlig. bruker så DobbeltLenketListeIterator(int indeks) til å returnere en instans av iterator-klassen.
