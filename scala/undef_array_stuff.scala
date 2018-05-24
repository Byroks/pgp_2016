object Main {
  def getValGreaterZero(arr:Array[Int]):Array[Int] = {
    return arr.filter { _ > 0 }
  }
 
  def sumAllValuesGreaterZero(arr:Array[Int],sum:Int):Int ={
    return getValGreaterZero(arr).sum
  }
  
  def sumAllValuesByCondition(arr:Array[Int],cond:Int=>Boolean):Int ={
    return arr.filter(cond).sum    
  }
 
  def main(args:Array[String]): Unit ={
    val x = Array(1, -7, 2, 0, -4, 5, -6)
    println(getValGreaterZero(x).deep)	
    println(sumAllValuesGreaterZero(x, 0))
    println(sumAllValuesByCondition(x, _<5))
  }
}