@PublishedApi
internal class AnySerializer<S> : KSerializer<S> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("kotlin.Any", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): S = TODO("Not yet implemented")

    override fun serialize(encoder: Encoder, value: S) = TODO("Not yet implemented")
}

@PublishedApi
internal inline fun <reified T> getSerializer(): KSerializer<T> = when (T::class) {
    Any::class -> AnySerializer()
    else -> serializer()
}