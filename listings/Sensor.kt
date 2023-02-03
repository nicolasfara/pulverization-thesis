/** Models the concept of single [Sensor] in the pulverization context.
 * A [Sensor] can [sense] the environment by measuring one of its magnitudes.
 * @param T the type of the measuring after the [sense] operation.
 * @param I the identifier of the sensor.
 */
interface Sensor<out T> : Initializable {
    /**
     * The operation of sensing a magnitude from the environment.
     */
    suspend fun sense(): T
}
