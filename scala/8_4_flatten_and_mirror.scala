object Main	{
	def flatten(xs: List[Any]): List[Any] = xs match {
		case Nil => Nil
		case Nil :: tail => flatten(tail)
		case (head :: subTail) :: tail => flatten(head :: subTail) ++ flatten(tail)
    case head :: tail => head :: flatten(tail)

		
		/*val list: List[Any] = List()
		_flatten(xs, list, xs.length-1)*/
	}
	
	/*def _flatten(xs: List[Any], list: List[Any], cnt:Int): List[Any] =	{
		
		if (cnt == xs.length-1) list
		if (xs.apply(cnt).equals(List(_)) _flatten(xs.apply(cnt), list, 0)
		if (xs.apply(cnt).equals(List(_)) == false) _flatten(xs, list++xs.apply(cnt), cnt+1)

	} */
	
	def mirror(xs: List[Any]): List[Any] = xs++xs.reverse

	def main(args: Array[String])	{
		val list = List(List(1,2,List(3,4)),List(123,456),900)
		val list2 = List("a",1,List(1,23))
		println(flatten(list))
		println(mirror(list2))
	}
}

/*Nutzen Sie für die nachfolgenden Aufgaben ggf. Pattern Matching und die List-Operationen. Arbeiten Sie funktional, d.h. insbesondere ohne Schleifen!

a) Schreiben Sie eine Funktion flatten(xs; List[Any]): List[Any], die eine beliebige Liste bestehend aus Listen verschiedener Verschachtelungstiefe in eine Liste ohne interne Listen umwandelt. Bspw. wird aus der Liste List(List(1,2,List(3,4)),List(123,456),900) die Liste List(1, 2, 3, 4, 123, 456, 900)

b) Schreiben Sie eine Funktion mirror(xs: List[Any]: List[Any], die eine beliebige Liste entgegennimmt und die Liste in gespiegelter Reihenfolge an die Ausgangsliste anhängt. Bspw. wird aus der Liste List("a",1,List(1,23)) die Liste List("a",1,List(1,23),List(1, 23), 1, "a")*/