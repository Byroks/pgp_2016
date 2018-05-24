object Main {

	// definiert den Konstruktor bestehend aus zwei Integern
	class ComplexNum(val real: Int, val img: Int)	{
		// überschreiben die Operatoren für +,-,*,/ - können Infix somit angewendet werden
		// erwarten jeweils ein neues Objekt vom Datentyp ComplexNum
		def +(that:ComplexNum) = new ComplexNum(this.real + that.real, this.img + that.img)
		def -(that:ComplexNum) = new ComplexNum(this.real - that.real, this.img - that.img)
		def *(that:ComplexNum) = {
			val a = this.real*that.real 
			val b = this.real*that.img
			val c = this.img * that.real
			val d = this.img * that.img
			
			val e = b + c	//Imaginärteil
			val f = d * -1	//i^2 = -1
			val g = a + f	//Realteil
			
			new ComplexNum(g, e)
		
		}
		def /(that:ComplexNum) = {	
		
			val a = that.img * -1				
			val b = this.real * that.real						//Zähler real
			val c = (this.img * a * -1) + b						//Zähler real fin
			val d = (this.real * a) + (this.img * that.real) 	//Zähler img fin
			val e = that.real * that.real						//Nenner real
			val f = (that.img * a * -1) + b						//Zähler img -> i^2 -> real + real --> Nenner real fin
			val g = (that.real * a)	+ (that.img * that.real)	//Nenner img fin
			
			new ComplexNum(f, d)			//c = Zähler real; f = Nenner, d = Zähler img 
		}
		override def toString = {
			this.real + "+" + this.img + "i"
		}
	}

	def addComplexList(xs: List[ComplexNum]):ComplexNum = xs match	{
		case head :: Nil => xs.head
		case head :: tail => xs.head+addComplexList(xs.tail)
	}
	def subComplexList(xs: List[ComplexNum]):ComplexNum = xs match	{
		case head :: Nil => xs.head
		case head :: tail => xs.head-subComplexList(xs.tail)
	}
	def mulComplexList(xs: List[ComplexNum]):ComplexNum = xs match	{
		case head :: Nil => xs.head
		case head :: tail => xs.head*mulComplexList(xs.tail)
	}
	def divComplexList(xs: List[ComplexNum]):ComplexNum = xs match	{
		case head :: Nil => xs.head
		case head :: tail => xs.head/divComplexList(xs.tail)
	}
	
	def main(args: Array[String]){
		/*val a = new ComplexNum(2, 3)
		val b = new ComplexNum(4, 5)
		println(a*b)

		val c = new ComplexNum(4, 2)
		val d = new ComplexNum(3, -1)
		println(c/d)*/
		
		val x = List(new ComplexNum(1,2),new ComplexNum(3,1),new ComplexNum(13,-1))
		println(addComplexList(x))
		println(subComplexList(x))
		println(mulComplexList(x))
		println(divComplexList(x))

  }
}

/*a) Ergänzen Sie die mathematischen Operationen der Klasse für komplexe Zahlen ComplexNum, indem Sie die mathematischen Operationen überschreiben.

b) Schreiben Sie für jede mathematische Operation eine Funktion, die eine Liste von ComplexNum entgegennimmt und von links beginnend die komplexen Zahlen verrechnet. Bspw ergibt addComplexList(List(new ComplexNum(1,2),new ComplexNum(3,1),new ComplexNum(13,-1))) ergibt 17+2i . Arbeiten Sie funktional, d.h. insbesondere ohne Schleifen.*/