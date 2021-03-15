package exercises

import u03.Lists._

object Lists {
  /*
    Consider the List type introduced in class. Analogously to sum and
    append, create the following functions:
      a) def drop[A](l: List[A], n: Int): List[A]
      b) def flatMap[A,B](l: List[A])(f: A => List[B]): List[B]
      c) Write map in terms of flatMap
      d) Write filter in terms of flatMap
  */

  // select all the elements except the first n elements of the list.
  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (List.Cons(h, t), n) if n > 0 && h != List.Nil() => drop(t, n-1)
    case _ => l
  }

}
