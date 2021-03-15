package exercises

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List._
import exercises.Lists._

class ListsTest {

  @Test def testDrop(){
    val lst = Cons(10 , Cons(20 , Cons(30 , Nil() ) ) ) // 10 20 30
    assertEquals(Cons(20 , Cons(30 , Nil())).toString(), drop( lst ,1).toString()) // Cons (20 , Cons (30 , Nil () ) )
    assertEquals(Cons(30 , Nil()).toString(), drop(lst ,2).toString())
    assertEquals(Nil().toString(), drop(lst ,5).toString())
  }

}
