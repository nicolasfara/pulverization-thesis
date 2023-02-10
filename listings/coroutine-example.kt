suspend fun guessLocaleFromText(text: String): Locale {
    // locale detection implementation
}

suspend fun guessWebPageLocale (url: URL): Locale {
    val text = HttpClient().get<String>(url)
    val localeGuess = guessLocaleFromText(text)
    return localeGuess
}
