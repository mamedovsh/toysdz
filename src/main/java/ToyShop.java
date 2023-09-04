import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ToyShop {
    private static List<Toy> toys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Добавить новую игрушку.");
            System.out.println("2. Изменить вес игрушки.");
            System.out.println("3. Начать раздачу.");
            System.out.println("4. Выход.");
            System.out.println("Введите ваш выбор: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    addNewToy();
                    break;
                case 2:
                    changeToyWeight();
                    break;
                case 3:
                    startToyGiveaway();
                    break;
                case 4:
                    System.out.println("Выход..");
                    break;
                default:
                    System.out.println("Неправильгый выбор. Попробуйте снова");
                    break;
            }
        }
        while (choice !=4);

    }
    private static void addNewToy(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id игрушки: ");
        int id = scanner.nextInt();

        System.out.print("введите название игрушки: ");
        String name = scanner.next();

        System.out.print("Введите количество игрушек: ");
        int quantity = scanner.nextInt();

        System.out.print("Введите вес игрушки в %: ");
        double weight = scanner.nextDouble();

        Toy toy = new Toy(id,name,quantity,weight);
        toys.add(toy);

        System.out.println("Новая игрушка успешно добавлена");

    }

    private static void changeToyWeight(){
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Введите id игрушки: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Toy toy : toys){
            if (toy.getId() == id){
                System.out.print("Введите вес новой игрушки в %: ");
                double weight = scanner.nextDouble();
                toy.setWeight(weight);
                System.out.println("Вес игрушки добавлен");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Игрушка с таким id не найдена.");

        }
    }
    private static void startToyGiveaway(){
        double totalWeight = 0;
        for (Toy toy : toys){
            totalWeight += toy.setWeight();
        }
        if (totalWeight == 0){
            System.out.println("Игрушек нет.");
            return;
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;
        double cumulativeWeight = 0;
        Toy selectedToy = null;

        for (Toy toy : toys){
            cumulativeWeight += toy.setWeight();
            if(randomNumber < cumulativeWeight){
                selectedToy = toy;
                break;
            }
        }

        if (selectedToy != null) {
            if(selectedToy.getQuantity() ==0){
                System.out.println("Все игрушки такого типа розданы.");

            } else {
                selectedToy.setQuantity(selectedToy.getQuantity() -1);
                System.out.println("Поздравляем! вы выиграли" + selectedToy.getName() + ".");

            }
        }

    }
}
