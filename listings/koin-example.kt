data class MySimpleClass (val message: String)

// Define a module to provide the dependency
val myModule = module {
    single { MySimpleClass("Hello from Koin") }
}

startKoin {
    // Use the module
    modules(myModule)
}

// Inject the dependency in a class
class MyClass {
    val mySimpleClass: MySimpleClass by inject()
}

// Use the class
fun main() {
    val myClass = MyClass()
    println(myClass.mySimpleClass.message)
}