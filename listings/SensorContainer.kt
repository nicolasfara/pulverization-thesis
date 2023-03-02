abstract class SensorsContainer : PulverizedComponent {
    private var sensors: Set<Sensor<*>> = emptySet()

    operator fun <P, S : Sensor<P>>
    plusAssign(sensor: S) {
        sensors = sensors + sensor
    }

    fun <P, S : Sensor<P>>
    addAll(vararg allSensor: S) {
        sensors = sensors + allSensor.toSet()
    }

    operator fun <T, S : Sensor<T>>
    get(type: KClass<S>): S? =
        sensors.firstOrNull(type::isInstance) as? S

    fun <T, S : Sensor<T>>
    getAll(type: KClass<S>): Set<S> =
        sensors.mapNotNull { e -> 
            e.takeIf { type.isInstance(it) } as? S
        }.toSet()

    inline fun <reified S : Sensor<*>>
    get(): S? = this[S::class]

    inline fun <reified S : Sensor<*>>
    get(run: S.() -> Unit) = this[S::class]?.run()
}
