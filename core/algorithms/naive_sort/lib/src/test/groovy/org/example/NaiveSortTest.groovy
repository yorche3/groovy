/*
 * naive_sort_test.groovy — Pruebas unitarias de la especificación 05_Naive_Sort
 */
package org.example

import spock.lang.Specification

class NaiveSortTest extends Specification {

    // Casos de prueba de la especificación 05_Naive_Sort.md
    static final List<Integer> STANDARD_INPUT = [5, 2, 9, 1, 5, 6]
    static final List<Integer> STANDARD_OUTPUT = [1, 2, 5, 5, 6, 9]

    static final List<Integer> SORTED_INPUT = [1, 2, 3, 4, 5]
    static final List<Integer> SORTED_OUTPUT = [1, 2, 3, 4, 5]

    static final List<Integer> REVERSE_INPUT = [5, 4, 3, 2, 1]
    static final List<Integer> REVERSE_OUTPUT = [1, 2, 3, 4, 5]

    static final List<Integer> IDENTICAL_INPUT = [7, 7, 7, 7]
    static final List<Integer> IDENTICAL_OUTPUT = [7, 7, 7, 7]

    static final List<Integer> NEGATIVE_INPUT = [3, -1, 4, -5, 0]
    static final List<Integer> NEGATIVE_OUTPUT = [-5, -1, 0, 3, 4]

    static final List<Integer> SINGLE_INPUT = [42]
    static final List<Integer> SINGLE_OUTPUT = [42]

    static final List<Integer> EMPTY_INPUT = []
    static final List<Integer> EMPTY_OUTPUT = []

    private static final List<Map> CASES = [
            [description: 'an unsorted array', input: STANDARD_INPUT, expected: STANDARD_OUTPUT],
            [description: 'an already sorted array', input: SORTED_INPUT, expected: SORTED_OUTPUT],
            [description: 'a reverse ordered array', input: REVERSE_INPUT, expected: REVERSE_OUTPUT],
            [description: 'an array of identical elements', input: IDENTICAL_INPUT, expected: IDENTICAL_OUTPUT],
            [description: 'an array with negative numbers', input: NEGATIVE_INPUT, expected: NEGATIVE_OUTPUT],
            [description: 'a single element array', input: SINGLE_INPUT, expected: SINGLE_OUTPUT],
            [description: 'an empty array', input: EMPTY_INPUT, expected: EMPTY_OUTPUT],
            [description: 'a null input', input: null, expected: null],
    ]

    // Helper compartido: recibe la función a probar y el nombre del algoritmo, y
    // ejecuta todos los casos con un mensaje descriptivo cada uno.
    // Cada caso ordena una copia del fixture, porque un algoritmo puede ordenar
    // in-place y contaminar los casos siguientes.
    // Caso nulo incluido: Groovy admite `null` y el contrato exige devolverlo
    // como indicador de fallo, sin lanzar excepciones.
    private static void assertSortsAllCases(Closure sort, String algorithm) {
        CASES.each { testCase ->
            List<Integer> input = testCase.input == null
                    ? null
                    : new ArrayList<Integer>(testCase.input as List<Integer>)
            assert sort(input) == testCase.expected :
                    "$algorithm should sort ${testCase.description}"
        }
    }

    def "selection_sort should sort all cases"() {
        expect:
        assertSortsAllCases({ List<Integer> arr -> NaiveSort.selectionSort(arr) }, 'selection_sort')
    }

    def "bubble_sort should sort all cases"() {
        expect:
        assertSortsAllCases({ List<Integer> arr -> NaiveSort.bubbleSort(arr) }, 'bubble_sort')
    }

    def "insertion_sort should sort all cases"() {
        expect:
        assertSortsAllCases({ List<Integer> arr -> NaiveSort.insertionSort(arr) }, 'insertion_sort')
    }
}
