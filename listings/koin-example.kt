data class MySimpleClass (val message: String)
startKoin { 
    module { 
        single { MySimpleClass("Hello from Koin") } 
    }
}
class MyClass {
    val mySimpleClass: MySimpleClass by inject()
}

fun main() {
    val myClass = MyClass()
    println(myClass.mySimpleClass.message)
}