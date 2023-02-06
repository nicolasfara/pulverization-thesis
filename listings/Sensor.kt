interface Sensor<out T> : Initializable {
    
    suspend fun sense(): T
}
