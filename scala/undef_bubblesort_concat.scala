object Main {
 
  def swap(arr: Array[Int], i: Int, j: Int): Array[Int] = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
    return arr
  }
 
  def bubbleSortRec(arr: Array[Int]): Array[Int] = {
    return _bubbleSortRec(arr, 0, arr.length - 1)
  }
 
  def _bubbleSortRec(arr: Array[Int], i: Int, l: Int): Array[Int] = {
    if (l == 1) return arr
    else if (i == l) return _bubbleSortRec(arr, 0, l - 1)
    else if (arr(i)> arr(i+ 1))	return _bubbleSortRec(swap(arr, i, i + 1), i+1, l)
    else return _bubbleSortRec(arr, i + 1, l)
  }
 
  def main(args: Array[String]): Unit = {
    val x = Array(1, 4, -3, 0, -10, 42, -1)
    val y = bubbleSortRec(x)
    println(y.deep)
  }
}