package stevens.software.wordoftheday.data

class WordsDataSource {

    fun getAllWords() : List<WordAndMeaning>{
        return words
    }

    private val words = listOf<WordAndMeaning>(
        WordAndMeaning("Photosynthesis", "The process by which green plants use sunlight to make their own food."),
        WordAndMeaning("Democracy", "A system of government in which power is held by the people, typically through elected representatives."),
        WordAndMeaning("Atom", "The smallest unit of matter that retains the properties of an element."),
        WordAndMeaning("Simile", "A figure of speech comparing two different things using “like” or “as."),
        WordAndMeaning("Ecosystem", "A community of living organisms and their physical environment interacting as a system."),
        WordAndMeaning("Revolution", "A significant change in political power or organizational structures that takes place in a relatively short period of time."),
        WordAndMeaning("Gravity", "The force that attracts two bodies toward each other, especially the pull of the Earth."),
        WordAndMeaning("Thesis", "A statement or theory that is put forward as a premise to be maintained or proved."),
        WordAndMeaning("Culture", " The ideas, customs, and social behavior of a particular group of people or society."),
        WordAndMeaning("Equator", ": An imaginary line around the middle of the Earth, equidistant from the poles."),
        WordAndMeaning("Inference", "A conclusion reached on the basis of evidence and reasoning."),
        WordAndMeaning("Magnetism", "A physical phenomenon produced by the motion of electric charge, resulting in attractive and repulsive forces"),
        WordAndMeaning("Alliteration", "The repetition of the same sound at the beginning of closely connected words."),
        WordAndMeaning("Allegory", " A story, poem, or picture that can be interpreted to reveal a hidden meaning, typically a moral or political one."),
        WordAndMeaning("Monarchy", "A form of government with a monarch at the head."),
        WordAndMeaning("Hypothesis", "A proposed explanation made on the basis of limited evidence as a starting point for further investigation."),
        WordAndMeaning("Precipitation", "Any form of water—liquid or solid—that falls from clouds and reaches the ground."),
        WordAndMeaning("Perspective", "A point of view or way of looking at something, especially in writing or art."),
        WordAndMeaning("Dialogue", "A conversation between two or more people as a feature of a book, play, or movie."),
        WordAndMeaning("Tundra", "A vast, flat, treeless Arctic region in which the subsoil is permanently frozen.")
    )
}

data class WordAndMeaning(
    val word: String,
    val meaning: String
)