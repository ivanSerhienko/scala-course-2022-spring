package karazin.scala.users.group.week5.homework

object givens:
  
  trait JsonStringEncoder [T]:
    def encode (toEncode: T): String

  given IntToJson: JsonStringEncoder[Int] with
    override def encode(toEncode: Int): String = toEncode.toString

  given BoolToJson: JsonStringEncoder[Boolean] with
    override def encode(toEncode: Boolean): String = toEncode.toString

  given StringToJson: JsonStringEncoder[String] with
    override def encode(toEncode: String): String = "\"" + toEncode + "\""

  given ListEncoder[T] (using encoder: => JsonStringEncoder[T]): JsonStringEncoder[List[T]] with
    override def encode(toEncode: List[T]): String = 
      "[" + toEncode.foldLeft(List[String]()) {(acc, toEncode) => acc :+ encoder.encode(toEncode)}.mkString(", ") + "]"

  object EncodeToJsonRepresentation:
    def apply[T] (using encoder: => JsonStringEncoder[T]): JsonStringEncoder[T] =
      encoder