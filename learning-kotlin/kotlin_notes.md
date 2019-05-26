# Notes:

## Basic Variables:

*val* cannot be changed
*var* can be changed

To make sure something is casted a certain way:
```kotlin
var name:<desired class> = <value>

//ex:
var integer:Int = 1234
var doubleVal:Double = 1234
// print(doubleVal) = 1234.0
...and so forth...
```

## No Nulls!

Well, there are no strictly null types.

For example
```kotlin
//These will all throw errors
var nonNull:Int = null
var nonNull:Double = null
var nonNull:Float = null

//These will not
var nonNull:Int? = null
var nonNull:Double? = null
var nonNull:Float? = null
```

This does not allow errors like this to occur:
```java
String str = null;
System.out.println(str.length); //This will throw an error
```

```kotlin
//if we declare the variable as a Nullable
var str:String? = "Kotlin is fun"
//this will not even be allowed to compile. It'll throw a
// compilation error as opposed to a runtime error which
// is pretty amazing imho
print(str.length)

//This can cause problems, however, because you will sometimes
// need to call a Nullable.length. In this, you can make a
// safe call, which would be
str?.length
// which does not allow for any NullPointerExceptions. It will
// instead just return a value of *null* instead of losing its
// mind
// This causes a problem, however, if you are attempting to
// store str.length into an int, as it will not allow it.
// To circumvent this, you must have a Nullable Int receive
// the str.length
var nullableString:String? = "kotlin is kind of great"
var length:Int = nullableString.length //will throw an error
var length:Int? = nullableString.length //will not
```
You can tell Kotlin that you are SURE that a variable will not
be null (so you don't have to catch it will a Nullable type
```kotlin
var str:String? = null //obviously a Nullable String
 //will post an error. It only compiled because we
 // guaranteed the compiler we knew what we were doing
 // and we obviously didn't
print(str!!.length)
```

## Conditionals:
When statements are essentially just switch statements