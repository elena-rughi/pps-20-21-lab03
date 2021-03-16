package exercises

import u03.Lists.List

object Streams {
  sealed trait Stream[A]

  object Stream {
    private case class Empty[A]() extends Stream[A]
    private case class Cons[A](head: () => A, tail: () => Stream[A]) extends Stream[A]

    def empty[A](): Stream[A] = Empty()

    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
    }

    def toList[A](stream: Stream[A]): List[A] = stream match {
      case Cons(h,t) => List.Cons(h(), toList(t()))
      case _ => List.Nil()
    }

    def map[A, B](stream: Stream[A])(f: A => B): Stream[B] = stream match {
      case Cons(head, tail) => cons(f(head()), map(tail())(f))
      case _ => Empty()
    }

    def filter[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match {
      case Cons(head, tail) if (pred(head())) => cons(head(), filter(tail())(pred))
      case Cons(_, tail) => filter(tail())(pred)
      case _ => Empty()
    }

    def take[A](stream: Stream[A])(n: Int): Stream[A] = (stream,n) match {
      case (Cons(head, tail), n) if n>0 => cons(head(), take(tail())(n - 1))
      case _ => Empty()
    }

    def iterate[A](init: => A)(next: A => A): Stream[A] = cons(init, iterate(next(init))(next))

    /*
      5. Define a function, dual to take(s)(n), called drop(s)(n),
      which drops the first n elements of the stream s.
     */
    def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream,n) match {
      case (Cons(_, tail), n) if n>0 => drop(tail())(n - 1)
      case _ => stream
    }

    /*
      6. Implement a generic function constant(k) which generates an infinite
      stream of value k.
     */
    def constant[A](v: => A): Stream[A] = cons(v, constant(v))

    /*
      7. Implement an infinite stream for the Fibonacci series
     */
    def fibonacci(): Stream[Int] =  fib(0, 1)
    private def fib(a: => Int, b: => Int): Stream[Int] = cons(a, fib(b, a+b))

  }
}
