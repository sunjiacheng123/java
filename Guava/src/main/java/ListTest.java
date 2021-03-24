import com.google.common.collect.Lists;

import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Animal> animalList = Lists.newArrayList();

        processDogs(animalList);
    }

    public static void processDogs(List<Animal> animalList) {
        // animalList, 1000
        List<Dog> dogList = Lists.newArrayList(); // 10

        // 準備好處理的集合
        animalList.forEach(animal -> {
            Dog dog = new Dog();
            dog.setName(animal.getName() + "Dog");
            dogList.add(dog); // 5, list.stroageSize ? , malloc() Memory
        });

        // 處理集合
        // dogList.color -> dog;
    }


    private static class Animal {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Dog extends Animal {
        private String name;
        private String color;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }


}
