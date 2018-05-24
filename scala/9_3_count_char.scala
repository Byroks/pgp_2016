object Main {
	// ToDo code goes here
	def countChar(txt : String): List[(Char,Int)] = {
		val list: List[(Char,Int)] = List()
		_countChar(txt, 0, list)
	}
	
	def _countChar(txt: String, cnt: Int, list: List[(Char, Int)]): List[(Char, Int)] = {
	  if (txt.length() == 1 && !list.contains((txt.head, Int)))  {
	    list:+(txt.head, test(txt.head, txt.tail, 1))
	    list
	  }
	  else if(!list.contains((txt.head, Int))) _countChar(txt.tail, cnt+1, list:+(txt.head, test(txt.head, txt.tail, 1)))
		else _countChar(txt.tail, cnt+1, list)
	}

	def test(char: Char, txt: String, cnt: Int): Int = {
	  if(txt.head.equals(char)) 
	    if(txt.length >= 1) test(char, txt.tail, cnt+1)
	    else cnt+1
	  else 
	    if(txt.length >= 1) test(char, txt.tail, cnt)
	    else cnt
	}

	def main(args: Array[String]) = {
		print(countChar("Hello World !"))
	}
}

/*Schreiben Sie eine Funktion countChars(txt: String): List[(Char, Int)], die einen Text txt als String entgegennimmt und als Rückgabewert eine Liste mit Tupeln liefert, die jeden Buchstaben des Textes im ersten Tupelwert und deren absolute Häufigkeit im Text im zweiten Tupelwert enthält.

Bspw. ergibt countChars("Hello World !") die Liste List(('!',1), ('d',1), ('r',1), ('W',1), (' ',2), ('o',2), ('l',3), ('e',1), ('H',1))

Hinweis: Schleifen sind nicht erlaubt!*/