object Main{

	def grouping(xs : List[Int], rule: Int=>Boolean): Tuple2[List[Int],List[Int]] = (xs.filter(rule(_)), xs.filter(!rule(_)))
		

	def groupingRules(xs: List[Int], rules: List[Int=>Boolean]): List[List[Int]] = rules match{
		case Nil => Nil
		case head :: tail => xs.filter(head) :: groupingRules(xs,tail)
	}
	
	def main(args: Array[String])	{
		val list = List[Int](1,2,100,3,4,501,12)
		val t = grouping(list, _ <= 100)
		val rules = List[Int=>Boolean]((x:Int)=>x>=100, (x:Int)=>2*(x/2)==x)
		
		
		println(t)
		println(groupingRules(list, rules))
	}
}

/*a) Schreiben Sie eine Funktion grouping(xs: List[Int], rule Int=>Boolean): Tuple2(List[Int],List[Int]], die eine Liste und eine Regel nimmt und ein Tupel aus zwei Listen zurückgibt, wobei im ersten Tupelteil die Elemente stehen, die die Regel erfüllen, und im zweiten Teil die Elemente stehen, die die Regel nicht erfüllen. Bspw. ergibt grouping(List(1,2,100,3,4,501,12),(x:Int)=>x>=100) das Tupel (List(100, 501),List(1, 2, 3, 4, 12))

b) Schreiben Sie eine Funktion groupingRules(xs: List[Int], rules: Int=>Boolean): List[List[Int]], die eine Liste mit Zahlen und eine Liste von Regeln entgegennimmt und als Ausgabe eine Liste mit Listen erzeugt, bei die erste Liste die Elemente enthält, die die erste Regel erfüllen, die zweite Liste die Elemente, die die zweite Regeln erfüllen usw.. Bspw ergibt groupingRules(List(1,2,100,3,4,501,12),List((x:Int)=>x>=100,(x:Int)=>2*(x/2)==x)) die Liste List(List(100, 501), List(2, 100, 4, 12)).*/