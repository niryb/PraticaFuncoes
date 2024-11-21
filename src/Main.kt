val materiasENotas = mutableMapOf<String, MutableList<Double>>()

fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.putIfAbsent(materia, notas) == null
}

fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]
    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}

fun adicionarVariasNotas(materia: String, vararg nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]
    return if (notasDaMateria != null) {
        notasDaMateria.addAll(nota.toList())
        true
    } else {
        false
    }
}

fun calcularMedia(notas: List<Double>): Double {
    return if (notas.isNotEmpty()) {
        notas.sum() / notas.size
    } else {
        0.0
    }
}

fun mostrarNotas(materia: String) {
    val listaNotas = materiasENotas[materia]
    if (listaNotas == null) {
        println("Materia $materia não encontrada")
    } else if (listaNotas.isEmpty()) {
        println("Não foi possível mostrar as notas da matéria $materia")
    } else {
        println("Materia: $materia")
        listaNotas.forEachIndexed { index, nota ->
            println("Nota ${index + 1}: $nota")
        }
        val media = calcularMedia(listaNotas)
        println("\nMédia: ${"%.1f".format(media)}\n")
    }
}


fun main() {
    // 1. adicionarDisciplinas
    adicionarDisciplina("Matemática", mutableListOf(7.5, 8.0))
    // 2. adicionarDisciplinas (atribuição nomeada)
    adicionarDisciplina(materia = "Português", notas = mutableListOf(6.5))
    // 3. alterar para valor padrão
    // (já alterado na função adicionarDisciplina acima)
    // 4. adicionar disciplina sem notas
    adicionarDisciplina("História")
    // 5. adicionar 3 notas
    adicionarNota("Matemática", 9.0)
    adicionarNota("Português", 7.0)
    adicionarNota("História", 8.5)
    // 6. mostrar notas
    mostrarNotas("Matemática")
    mostrarNotas("Português")
    mostrarNotas("História")
    // 7. adicionar mais 1 disciplina
    adicionarDisciplina("Geografia")
    // 8. implementar adicionarVariasNotas (já feito)
    // 9. adicionar 3 notas para Geografia
    adicionarVariasNotas("Geografia", 6.0, 7.5, 8.0)
    // 10. mostrar notas de Geografia
    mostrarNotas("Geografia")
    // 12. calcular média de 2 disciplinas
    println("Média de Matemática: ${calcularMedia(materiasENotas["Matemática"] ?: listOf())}")
    println("Média de Português: ${calcularMedia(materiasENotas["Português"] ?: listOf())}")
}
