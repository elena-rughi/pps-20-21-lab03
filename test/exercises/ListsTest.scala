package exercises

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List._
import exercises.Lists._

class ListsTest {

  @Test def testDrop() ={
    val lst = Cons(10 , Cons(20 , Cons(30 , Nil()))) // 10 20 30
    assertEquals(Cons(20 , Cons(30 , Nil())).toString(), drop( lst ,1).toString()) // Cons (20 , Cons (30 , Nil () ) )
    assertEquals(Cons(30 , Nil()).toString(), drop(lst ,2).toString())
    assertEquals(Nil().toString(), drop(lst ,5).toString())
  }

  @Test def testFlatMap() = {
    val lst = Cons(10, Cons(20, Cons(30, Nil()))) // 10 20 30

    assertEquals( Cons(11 , Cons(21 , Cons(31 , Nil()))).toString(),
                  flatMap(lst)(v => Cons(v+1, Nil())).toString())

    assertEquals( Cons(11 , Cons(12 , Cons(21 , Cons(22 , Cons(31 , Cons(32 , Nil())))))).toString(),
                  flatMap(lst)(v => Cons(v+1 , Cons(v+2 , Nil()))).toString())

  }

  @Test def testMap() = {
    val lst = Cons(10, Cons(20, Cons(30, Nil()))) // 10 20 30
    assertEquals( map(lst)(v => v+1).toString(),
                  myMap(lst)(v => v+1).toString())
  }

  @Test def testFilter() = {
    val lst = Cons(10, Cons(20, Cons(30, Nil()))) // 10 20 30
    assertEquals( filter[Int](lst)(_ >=20).toString(),
                  myFilter[Int](lst)(_ >=20).toString())
  }

}
