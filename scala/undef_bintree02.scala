//define functions every tree has
abstract class AbstractBinTree{
  // check if tree is empty
  def isEmpty: Boolean
  // get data
  def getData: Int
  //get left child
  def getLeft:AbstractBinTree
  //get right child
  def getRight:AbstractBinTree
  // getString
  def getString(indend: Int):String
  // use getString method for output
  override def toString = getString(1)
}

//represent empty Tree
case object EmptyTree extends AbstractBinTree{
  //an empty tree doesn't contain anything
  def isEmpty: Boolean = true
  def getData: Int = throw new RuntimeException("Cannot get data from empty tree")
  def getLeft:AbstractBinTree= throw new RuntimeException("Cannot get left tree from empty tree")
  def getRight:AbstractBinTree= throw new RuntimeException("Cannot get right tree from empty tree")
  def getString(indend: Int):String = ""
}

//an actual binary tree
//to enforce functional programming, all members are final
case class BinTree(data: Int, left: AbstractBinTree, right: AbstractBinTree) extends AbstractBinTree {
  def isEmpty: Boolean = false
  def getData: Int = data
  def getLeft: AbstractBinTree = left
  def getRight: AbstractBinTree = right
  def getString(indend: Int): String = {
    var dataPart = "|-" + data
    if (!(left isEmpty)) {
      dataPart += "\n" + "   " * indend + left.getString(indend + 1)
    }
    if (!(right isEmpty)) {
      dataPart += "\n" + "   " * indend + right.getString(indend + 1)
    }
    dataPart
  }
}

object Main{

  def getMinSumOnPath(tree:AbstractBinTree):Int= {
    if(tree.isEmpty) 0
    else {
      tree.getData + Math.min(_getMinSumOnPath(tree.getLeft, tree.getLeft.getData), _getMinSumOnPath(tree.getRight, tree.getRight.getData))
    }
  }
  
  def _getMinSumOnPath(tree:AbstractBinTree, sum:Int): Int = {
    if(!tree.getLeft.isEmpty) _getMinSumOnPath(tree.getLeft, sum+tree.getData)
    else if(!tree.getRight.isEmpty) _getMinSumOnPath(tree.getRight, sum+tree.getData)
    else sum
  }

  def main(args: Array[String]){
    var tree = BinTree(10,BinTree(20,BinTree(30,EmptyTree,BinTree(40,EmptyTree,EmptyTree)),BinTree(50,EmptyTree,EmptyTree)),BinTree(60,EmptyTree,EmptyTree));
    println(tree)
    println
    println(tree.getLeft)
    println
    println(tree.getLeft.getRight)
    println
    println("should be empty:"+tree.getLeft.getRight.getLeft)

    println(getMinSumOnPath(tree))
  }
}

/************************
* Aufgabenteil b)
* In binären Teilbäumen kann die Suche ggf. früher abbrechen, wenn ein Teilbaum bereits die Summe 0 hat.
* Der zweite Teilbaum muss nicht mehr durchlaufen werden, denn das Ergebnis kann bei natürlichen Zahlen nicht
* kleiner als 0 werden.
************************/