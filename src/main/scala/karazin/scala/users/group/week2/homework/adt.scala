package karazin.scala.users.group.week2.homework

/* 
  Custom implementation of Option (Maybe monad in Haskell)
  Implemented via Scala 3 way for Algebraic Data Types (ADT)
  
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/


object adt:

  enum ErrorOr[+V]:

    case Or(x: V) extends ErrorOr[V]
    case Error(ex: Throwable) extends ErrorOr[V]

    // The method is used for defining execution pipelines
    def flatMap[Q](f: V => ErrorOr[Q]): ErrorOr[Q] =
      this match
        case ErrorOr.Error(ex)  => ErrorOr.Error(ex)
        case ErrorOr.Or(x)      => try f(x) catch {
          case ex: Throwable    => ErrorOr.Error(ex)
        }

    //The method is used for changing the internal object
    def map[Q](f: V => Q): ErrorOr[Q] =
      this match
        case ErrorOr.Error(ex) => ErrorOr.Error(ex)
        case ErrorOr.Or(x)     => try ErrorOr.Or(f(x)) catch {
          case ex: Throwable   => ErrorOr.Error(ex)
        }

    //The method is used for filtering
    def withFilter(p: V => Boolean): ErrorOr[V] =
      this match
        case ErrorOr.Error(ex) => ErrorOr.Error(ex)
        try {
          this match
            case ErrorOr.Or(x) if p(x) => ErrorOr.Or(x)
        } catch {
          case ex: Throwable   => ErrorOr.Error(ex)
    }

    //The method is used for getting rid of internal box
    def flatten[U](implicit ev: V <:< ErrorOr[U]): ErrorOr[U] = 
      this match 
        case ErrorOr.Error(ex) => ErrorOr.Error(ex)
        case ErrorOr.Or(x)     => try ev(x) catch {
          case ex: Throwable   => ErrorOr.Error(ex)
        }

    //The method is used for applying side effects without returning any result
    def foreach[U](f: V => U): Unit =
      this match 
        case ErrorOr.Error(ex) => ()
        case ErrorOr.Or(x)     => f(x)

  // Companion object to define constructor
  object ErrorOr:
    def apply[V](v: => V): ErrorOr[V] =
      try ErrorOr.Or(v) catch {
        case ex: Throwable => ErrorOr.Error(ex)
      }