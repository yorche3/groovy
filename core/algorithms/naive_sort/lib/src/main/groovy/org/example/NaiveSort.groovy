/*
 * naive_sort.groovy — Módulo Naive Sort con ordenamientos elementales
 *
 * Especificación: 05_Naive_Sort
 *
 * Contrato de las funciones (List<Integer> -> List<Integer>), de menor a mayor:
 *   selectionSort  — encuentra el mínimo del tramo no ordenado y lo ubica al inicio
 *   bubbleSort     — compara e intercambia adyacentes, con bandera `swapped`
 *   insertionSort  — inserta cada elemento en su sub-lista ordenada
 *
 * Caso nulo: Groovy admite `null`, así que el indicador de fallo es devolver
 * `null` cuando la entrada es `null`, sin lanzar excepciones.
 */
package org.example

class NaiveSort {
    static List<Integer> selectionSort(List<Integer> list) {
        if (list == null) return null
        List<Integer> arr = list.clone()
        for (int i = 0; i < arr.size() - 1; i++) {
            int minIndex = i
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                int temp = arr[i]
                arr[i] = arr[minIndex]
                arr[minIndex] = temp
            }
        }
        return arr
    }

    static List<Integer> bubbleSort(List<Integer> list) {
        if (list == null) return null
        List<Integer> arr = list.clone()
        boolean swapped
        do {
            swapped = false
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    swapped = true
                }
            }
        } while (swapped)
        return arr
    }

    static List<Integer> insertionSort(List<Integer> list) {
        if (list == null) return null
        List<Integer> arr = list.clone()
        for (int i = 1; i < arr.size(); i++) {
            int key = arr[i]
            int j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key
        }
        return arr
    }
}
