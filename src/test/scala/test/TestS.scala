package test

import com.lleggieri.N._
import com.lleggieri.N
import org.scalatest.FunSuite

import language.postfixOps

class TestS extends FunSuite {

  test("spire") {
    import spire.algebra._   // provides algebraic type classes
    import spire.math._      // provides functions, types, and type classes
    import spire.std._
    import com.lleggieri.Spire._
    import spire.implicits._ // provides infix operators, instances and conversions

    val n1 = one
    val n2 = twenty
    val result = n1 |+| n2
    assert ((twenty one) == result)

    implicit def MapMonoid[K, V: Semigroup] = new MapMonoid[K, V] {
      val scalar = Semigroup[V]
    }

    val map1: Map[String, N] = Map("x" -> one, "y" -> two, "z" -> four)
    val map2: Map[String, N] = Map("y" -> ten, "z" -> two, "w" -> eight)
    val map3 = map1 |+| map2
    assert(twelve == map3("y"))
  }

  test("scalaz with Int") {
    import scalaz.std.anyVal.intInstance
    import scalaz.syntax.monoid.ToSemigroupOps
    1 |+| 2

    import scalaz.syntax.bind.ToBindOps
    import scalaz.std.list.listInstance
    List(List(1)).join

    import scalaz.syntax.foldable.ToFoldableOps
    List(1, 2, 3) foldMap { identity }
  }

  test("scalaz with N") {
    val n1:N = one
    val n2:N = twenty
    import com.lleggieri.Scalaz.additiveMonoid
    import scalaz.syntax.monoid.ToSemigroupOps
    import scalaz.syntax.bind.ToBindOps
    val result:N = n1 |+| n2
    assert ((twenty one) == result)

    import scalaz.std.list.listInstance
    List(List(n1)).join

    import scalaz.syntax.foldable.ToFoldableOps

    val list: List[N] = List(one, two, three, four)
    val result2:N = list foldMap { identity }
    assert(ten == result2)

    import scalaz.std.map.mapMonoid
    val map1: Map[String, N] = Map("x" -> one, "y" -> two, "z" -> four)
    val map2: Map[String, N] = Map("y" -> ten, "z" -> two, "w" -> eight)
    val map3 = map1 |+| map2
    assert(twelve == map3("y"))

  }

}
