package ru.aton.corporatebus;

import java.util.Map;
import java.util.TreeMap;

/*
Поиск по произвольному полю могут обеспечить только коллекции-мапы, причём с удовлетворительной сложностью.
Поиск по числу, кроме них, обеспечивает только ArrayList, и его можно было бы использовать в качестве альтернативы,
но ArrayList хранит только индекс int, что противоречит заданию, а альтернативный вариант с
переписыванинием ArrayList, в котором индекс был бы long вместо int невозможен,
так как в его основе находится массив ограниченной длины.
Соответственно варианты: HashMap (получение элемента за O(1))  TreeMap (получение элемента за O(log n))
Программа создаёт экземпляр класса Structure (StructureHash), в котором хранятся данные.
В рамках проведённого исследования значительных различий в объёмах занимаемой памяти не выявлено, из-за чего предпочтение
отдано реализации StructureHash, имеющей большую скорость работы по операциям с элементами (O(1)).
 */

public class Main {
    public static void main(String[] args) {

        StructureHash structure = new StructureHash();

        for (int i = 0; i < 30000000; i++) {
            InMemoryEntity entity = new InMemoryEntity(234678 + i, "Иванов Иван Иванович", 2035.34);
            structure.add(entity);
        }


       //Подтверждение получения данных по любому из полей
       //System.out.println(structure.findByAccount(234678).getName());
       //System.out.println(structure.findByName("Иванов Иван Иванович").getAccount());
       //System.out.println(structure.findByValue(2035.34).getAccount());


        System.out.println("Размер коллекции: " + structure.size());


        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Использование памяти: " + usedMemory + " байт");

    }
}
