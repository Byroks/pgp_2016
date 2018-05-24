//Mit Hilfe von http://www.tutorialspoint.com/scala

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

  def inOrder(tree:AbstractBinTree):List[Int]= {
    val list = List[Int]()
    if (!tree.isEmpty) _inOrder(tree, list)
    else list
  }
  
  def _inOrder(tree:AbstractBinTree, list:List[Int]):List[Int]= {
    if (!tree.isEmpty) _inOrder(tree.getLeft, list):::tree.getData::_inOrder(tree.getRight, list)
    else list
  }
  
  def preOrder(tree:AbstractBinTree):List[Int]= {
    val list = List[Int]()
    if (!tree.isEmpty) _preOrder(tree, list:List[Int])
    else list
  }
  
  def _preOrder(tree:AbstractBinTree, list:List[Int]):List[Int]= {
    if (!tree.isEmpty) tree.getData::_preOrder(tree.getLeft, list):::_preOrder(tree.getRight, list)
    else list
  }
    
  def postOrder(tree:AbstractBinTree):List[Int]= {
    val list = List[Int]()
    if (!tree.isEmpty) _postOrder(tree, list)
    else list
  }
  
  def _postOrder(tree:AbstractBinTree, list:List[Int]):List[Int]= {
    if (!tree.isEmpty) _postOrder(tree.getLeft, list):::_postOrder(tree.getRight, list):::tree.getData::list
    else list
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

    println(inOrder(tree))
    println(preOrder(tree))
    println(postOrder(tree))
  }
}

/*********************
* Aufgabenteil b)
* für eine sortierte Ausgabe muss inOrder gewählt werden
*********************/